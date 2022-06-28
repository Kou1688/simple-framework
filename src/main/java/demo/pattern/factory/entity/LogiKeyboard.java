package demo.pattern.factory.entity;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 14:49
 */
public class LogiKeyboard implements Keyboard {
    @Override
    public void sayHello() {
        System.out.println("我是罗技键盘");
    }
}
