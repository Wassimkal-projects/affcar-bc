/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {

    private static final int DEF_COUNT = 20;

    public RandomUtil() {
    }

    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }

    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    public static String generateResetKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

}
