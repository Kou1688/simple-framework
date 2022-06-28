package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 15:37
 */
public class ConstructorCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("demo.reflect.ReflectTarget");
        System.out.println("所有公有构造方法:");
        Constructor[] constructors = clazz.getConstructors();
        System.out.println(Arrays.toString(constructors));

        System.out.println("所有构造方法");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        System.out.println("带两个参数的公有方法");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        System.out.println("私有的构造方法");
        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);

        System.out.println("调用私有构造方法创建实例");
        //禁止 Java 语言访问检查
        declaredConstructor.setAccessible(true);
        ReflectTarget reflectTarget = (ReflectTarget) declaredConstructor.newInstance(1);
    }
}
