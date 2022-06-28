package demo.reflect;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 15:26
 */
public class ReflectTarget {
    //---------构造函数-----------
    //(默认的带参数构造函数)
    ReflectTarget(String str) {
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造函数
    public ReflectTarget() {
        System.out.println("调用了公有的无参构造方法 。。。");
    }

    //有一个参数的构造函数
    public ReflectTarget(char name) {
        System.out.println("调用了带有一个参数的构造方法，参数值为 " + name);
    }

    //有多个参数的构造函数
    public ReflectTarget(String name, int index) {
        System.out.println("调用了带有多个参数的构造方法，参数值为【目标名】： " + name + " 【序号】" + index);
    }

    //受保护的构造函数
    protected ReflectTarget(boolean n) {
        System.out.println("受保护的构造方法 n :" + n);
    }

    /**
     * 私有的构造函数
     */
    private ReflectTarget(int index) {
        System.out.println("私有的构造方法 序号：" + index);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //三种方式获取class
        ReflectTarget reflectTarget = new ReflectTarget();
        Class aClass1 = reflectTarget.getClass();
        System.out.println("one:" + aClass1.getName());
        Class aClass2 = ReflectTarget.class;
        System.out.println("two:" + aClass2.getName());
        System.out.println(aClass1 == aClass2);
        Class aClass3 = Class.forName("demo.reflect.ReflectTarget");
        System.out.println("three:" + aClass3.getName());
        System.out.println(aClass2 == aClass3);
    }
}
