package org.simpleframework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author KouChaoJie
 * @since: 2022/7/4 14:18
 */
public class BeanContainerTest {
    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @Test
    public void getInstanceTest() {
    }

    @Test
    public void isLoadedTest() {
    }

    @Test
    public void loadBeansTest() {
        assertFalse(beanContainer.isLoaded());
        beanContainer.loadBeans("com.kou");
        Assertions.assertEquals(6, beanContainer.size());
        Assertions.assertTrue(beanContainer.isLoaded());
    }
}