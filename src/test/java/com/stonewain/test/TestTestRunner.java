package com.stonewain.test;

import org.junit.Assert;
import org.junit.Test;

public class TestTestRunner {
    @Test
    public void testQuickMaths() {
        Assert.assertEquals(2+2, 4, 0);
    }
}
