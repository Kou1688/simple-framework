package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.DellKeyBoard;
import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @author KouChaoJie
 * @since: 2022/6/23 14:51
 */
public class DellComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyBoard() {
        return new DellKeyBoard();
    }
}
