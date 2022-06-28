package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.LogiKeyboard;
import demo.pattern.factory.entity.LogiMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 14:52
 */
public class LogiComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new LogiMouse();
    }

    @Override
    public Keyboard createKeyBoard() {
        return new LogiKeyboard();
    }
}
