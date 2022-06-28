package demo.pattern.factory.entity;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 21:39
 */
public class DellMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是戴尔鼠标");
    }
}
