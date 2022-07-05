package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * 依赖注入服务
 *
 * @author KouChaoJie
 * @since: 2022/7/5 13:49
 */
@Slf4j
public class DependencyInjector {
    /**
     * bean容器
     */
    private final BeanContainer beanContainer;

    public DependencyInjector() {
        this.beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IOC
     */
    public void doIoc() {
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("beanContainer is empty!");
            return;
        }
        //1.遍历Bean容器中所有的Class对象
        for (Class<?> clazz : beanContainer.getClasses()) {
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            //2.遍历Class对象的所有成员变量
            for (Field field : fields) {
                //3.找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();
                    //4.获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取这些成员变量的类型在容器里对应的实例(实现类)
                    Object fieldValue = getFieldInstance(fieldClass, autowiredValue);
                    if (fieldValue == null) {
                        throw new RuntimeException("unable to inject relevant type,target fieldClass is:" + field.getName() + autowiredValue);
                    } else {
                        //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据Class在beanContainer里获取其实例或实现类
     *
     * @param fieldClass class
     * @return 实例
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null) {
            return fieldValue;
        } else {
            Class<?> implementedClass = getImplementedClass(fieldClass, autowiredValue);
            if (implementedClass != null) {
                return beanContainer.getBean(implementedClass);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     *
     * @param fieldClass 接口class
     * @return 获取class接口的实现类
     */
    private Class<?> getImplementedClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classSet)) {
            //如果没有具体指定bean名称
            if (ValidationUtil.isEmpty(autowiredValue)) {
                //如果容器里只有一个实现类实例
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    throw new RuntimeException("multiple implemented classes for" + fieldClass.getName() + "please set @Autuwired's value to pick one ");
                }
            } else {
                //如果指定了名称
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    for (Class<?> clazz : classSet) {
                        if (autowiredValue.equals(clazz.getSimpleName())) {
                            return clazz;
                        }
                    }
                }
            }
        }
        return null;
    }
}
