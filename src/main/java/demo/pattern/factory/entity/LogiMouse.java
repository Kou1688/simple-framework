package demo.pattern.factory.entity;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 21:38
 */
public class LogiMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("我是罗技鼠标");
    }
}
