package demo.pattern.factory.entity;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 14:48
 */
public class DellKeyBoard implements Keyboard{
    @Override
    public void sayHello() {
        System.out.println("我是戴尔键盘");
    }
}
