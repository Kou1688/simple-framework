package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 14:50
 */
public interface ComputerFactory {
    Mouse createMouse();

    Keyboard createKeyBoard();
}
