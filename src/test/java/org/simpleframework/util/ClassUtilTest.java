package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KouChaoJie
 * @since: 2022/7/1 15:12
 */
public class ClassUtilTest {

    @DisplayName("提取目标类方法:extractPackageClassTest")
    @Test
    public void extractPackageClassTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.kou.entity");
        for (Class<?> aClass : classSet) {
            System.out.println(aClass);
        }
        assert classSet != null;
        Assertions.assertEquals(4, classSet.size());
    }

    @Test
    public void getClassLoaderTest() {
    }
}