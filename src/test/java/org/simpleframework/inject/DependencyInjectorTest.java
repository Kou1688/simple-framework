package org.simpleframework.inject;

import com.kou.controller.frontend.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KouChaoJie
 * @since: 2022/7/5 14:44
 */
public class DependencyInjectorTest {

    @Test
    @DisplayName("依赖注入doIoc")
    public void doIocTest() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.kou");
        assertTrue(beanContainer.isLoaded());
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        assertTrue(mainPageController instanceof MainPageController);
        assertNull(mainPageController.getHeadLineShopCategoryService());
        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null, mainPageController.getHeadLineShopCategoryService());
    }
}