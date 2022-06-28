package demo.pattern.factory.simple;

import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.LogiMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 21:41
 */
public class MouseFactory {
    public static Mouse createMouse(int type) {
        switch (type) {
            case 0:
                return new LogiMouse();
            case 1:
                return new DellMouse();
            default:
                return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }
}
