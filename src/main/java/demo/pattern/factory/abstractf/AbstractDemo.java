package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 14:53
 */
public class AbstractDemo {
    public static void main(String[] args) {
//        ComputerFactory factory=new LogiComputerFactory();
        ComputerFactory factory=new DellComputerFactory();
        Mouse mouse = factory.createMouse();
        Keyboard keyBoard = factory.createKeyBoard();
        mouse.sayHi();
        keyBoard.sayHello();
    }
}
