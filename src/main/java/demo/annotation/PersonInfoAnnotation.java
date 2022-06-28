package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author KouChaoJie
 * @since: 2022/6/28 14:15
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfoAnnotation {
    /**
     * 名字
     */
    String name();

    /**
     * 年龄
     */
    int age() default 18;

    /**
     * 性别
     */
    String gender() default "男";

    /**
     * 语言
     */
    String[] language();
}
