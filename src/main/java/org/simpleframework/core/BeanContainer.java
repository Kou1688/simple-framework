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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
}
