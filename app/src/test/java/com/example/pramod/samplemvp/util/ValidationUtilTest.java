package com.example.pramod.samplemvp.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pramod on 12/01/18.
 */

public class ValidationUtilTest {

    @Test
    public void checkEmail_inValidEmail_returnsFalse() {
        Assert.assertEquals(false, ValidationUtil.checkEmail("asd@as"));
    }

    @Test
    public void checkEmail_validEmail_returnsTrue() {
        Assert.assertEquals(true, ValidationUtil.checkEmail("pramod@gmail.com"));
    }
}
