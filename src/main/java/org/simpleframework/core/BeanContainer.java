package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IOC容器
 *
 * @author KouChaoJie
 * @since: 2022/7/4 10:37
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {
    /**
     * 存放所有被配置标记的目标对象Map
     * key:Class
     * value:实例
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 容器是否已经加载过bean
     */
    private boolean loaded = false;

    /**
     * 加载bean的注解列表
     * BEAN_ANNOTATION
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION = Arrays.asList(
            Component.class, Controller.class, Repository.class, Service.class
    );

    private enum ContainerHolder {
        /**
         * 容器枚举字段
         */
        HOLDER;
        private final BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 获取Bean容器实例
     *
     * @return Bean容器实例
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    /**
     * 容器是否已经加载过bean
     *
     * @return 容器是否加载
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * bean实例数量
     *
     * @return 数量
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 扫描加载所有bean
     *
     * @param packageName 包名
     */
    public synchronized void loadBeans(String packageName) {
        //判断容器是否加载
        if (isLoaded()) {
            log.warn("BeanContainer has been loaded!");
            return;
        }
        //获取该包下所有class
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        //判空
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName:{}", packageName);
            return;
        }

        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                //如果当前类被指定注解修饰,加载进IOC容器
                if (clazz.isAnnotationPresent(annotation)) {
                    //实例化class对象,并加载进容器
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 添加一个class对象及其Bean实例
     *
     * @param clazz class对象
     * @param bean  bean实例
     * @return bean实例, 没有返回null
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    /**
     * 删除一个bean
     *
     * @param clazz class对象
     * @return bean实例, 没有返回null
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取Bean实例
     *
     * @param clazz class对象
     * @return bean实例
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取所有class对象集合
     *
     * @return class对象集合
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * 获取所有bean实例集合
     *
     * @return 容器bean实例集合
     */
    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }

    /**
     * 通过注解获取被注解标注的class
     *
     * @param annotation 注解
     * @return 被annotation标注的class对象集合
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        if (ValidationUtil.isEmpty(getClasses())) {
            log.warn("nothing in beanMap");
            return null;
        }

        Set<Class<?>> classSet = new HashSet<>();
        //判断key是否被annotation标注,并添加进集合
        for (Class<?> clazz : getClasses()) {
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }

        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过父类获取对应的子类class集合
     *
     * @param superClazz 父类
     * @return Class集合
     */
    public Set<Class<?>> getClassesBySuper(Class<?> superClazz) {
        if (ValidationUtil.isEmpty(getClasses())) {
            log.warn("nothing in beanMap");
            return null;
        }

        Set<Class<?>> classSet = new HashSet<>();
        //判断clazz是否是传入接口或者类的子类,并添加进集合
        for (Class<?> clazz : getClasses()) {
            if (superClazz.isAssignableFrom(clazz) && !clazz.equals(superClazz)) {
                classSet.add(clazz);
            }
        }

        return classSet.size() > 0 ? classSet : null;
    }
}
