package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 类相关工具类
 *
 * @author KouChaoJie
 * @since: 2022/7/1 11:36
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";
    public static final String CLASS_FILE_SUFFIX = ".class";

    /**
     * 根据包名获取包里所有类集合<br/>
     * 1. 获取到类加载器<br/>
     * 2. 通过类加载器获取到加载的资源信息<br/>
     * 3. 依据不同的资源类型,采用不同方式获取资源集合<br/>
     *
     * @param packageName 包名
     * @return 类集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        //获取到类加载器
        ClassLoader classLoader = getClassLoader();
        //获取加载的资源信息,注意资源名是"/"分割
        URL resourceUrl = classLoader.getResource(packageName.replace(".", "/"));
        if (resourceUrl == null) {
            log.warn("包:{},找不到资源信息", packageName);
            //找不到资源,返回null
            return null;
        }

        //获取资源集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型资源
        if (resourceUrl.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            //获取资源路径的目录
            File packageDir = new File(resourceUrl.getPath());
            //提取出资源集合
            extractClassSet(classSet, packageDir, packageName);
        }

        return classSet;
    }

    /**
     * 获取ClassLoader
     *
     * @return 当前获取ClassLoader
     */
    public static ClassLoader getClassLoader() {
        //程序是被当前线程执行,找到当前线程,获取线程的的类加载器
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 实例化class
     *
     * @param clazz      class
     * @param <T>        class类型
     * @param accessible 是否禁止java语言检查
     * @return class实例化对象
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            //是否禁止java语言访问检查
            constructor.setAccessible(accessible);
            //返回class对象实例
            return (T) constructor.newInstance();
        } catch (Exception e) {
            log.error("new Instance error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置类的属性值
     *
     * @param field      成员变量
     * @param target     类实例
     * @param fieldValue 成员变量的值
     * @param accessible 是否禁止java语言检查
     */
    public static void setField(Field field, Object target, Object fieldValue, boolean accessible) {
        field.setAccessible(accessible);
        try {
            field.set(target, fieldValue);
        } catch (IllegalAccessException e) {
            log.error("setField:" + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 递归获取目标package里面所有class文件(包括子包里的class)
     *
     * @param emptyClassSet 装载目标类集合
     * @param fileSource    文件名或文件目录
     * @param packageName   包名
     */
    private static void extractClassSet(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        //递归基准条件,如果没有子文件夹,终止递归
        if (!fileSource.isDirectory()) {
            return;
        }

        File[] childFiles = fileSource.listFiles(new FileFilter() {
            //过滤出文件夹及class文件
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String absolutePath = file.getAbsolutePath();
                    //如果是class文件,直接加载
                    if (absolutePath.endsWith(CLASS_FILE_SUFFIX)) {
                        addToClassSet(absolutePath);
                    }
                }
                return false;
            }

            /**
             * 将类实例对象加载进classSet
             * 从class文件绝对路径中提取包含package的全类名,方便反射调用
             * 通过反射机制获取对应的Class对象并加入到classSet中
             *
             * @param absolutePath class文件的绝对路径
             */
            private void addToClassSet(String absolutePath) {
                String packageAbsolutePath = absolutePath.replace(File.separator, ".");
                //获取全类名,根据包名截取绝对路径并去掉文件后缀即可
                String referenceClassName = packageAbsolutePath.substring(packageAbsolutePath.indexOf(packageName)).replace(CLASS_FILE_SUFFIX, "");
                //将获取到的class对象加入到set集合中
                emptyClassSet.add(loadClass(referenceClassName));
            }
        });

        //递归条件,fileSource是一个文件夹,获取当前文件夹下的文件和子文件夹并加载class文件
        //必须判断childFiles是否为空,foreach遇到file为空会抛出异常
        if (!ValidationUtil.isEmpty(childFiles)) {
            for (File childFile : childFiles) {
                //递归调用
                extractClassSet(emptyClassSet, childFile, packageName);
            }
        }
    }

    /**
     * 获取class对象
     *
     * @param referenceClassName 全类名
     * @return Class
     */
    private static Class<?> loadClass(String referenceClassName) {
        try {
            return Class.forName(referenceClassName);
        } catch (ClassNotFoundException e) {
            log.error("load class error:", e);
            throw new RuntimeException(e);
        }
    }
}
