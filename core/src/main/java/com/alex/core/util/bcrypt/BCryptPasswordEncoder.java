package com.alex.core.util.bcrypt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.crypto.generators.BCrypt;

import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/1 18:03
 * @Version:    1.0
 *
*/
public class BCryptPasswordEncoder {

    private final Log logger = LogFactory.getLog(BCryptPasswordEncoder.class);

    private final int strength;

    private final SecureRandom random;

    private Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

    public BCryptPasswordEncoder(int strength) {
        this(strength, null);
    }

    public BCryptPasswordEncoder(int strength, SecureRandom random) {
        if (strength != -1 && strength < BCrypt.M)
    }
}
