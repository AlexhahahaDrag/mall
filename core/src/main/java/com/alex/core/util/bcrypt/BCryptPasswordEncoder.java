package com.alex.core.util.bcrypt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

    public BCryptPasswordEncoder() {
        this(-1);
    }

    public BCryptPasswordEncoder(int strength) {
        this(strength, null);
    }

    public BCryptPasswordEncoder(int strength, SecureRandom random) {
        if (strength != -1 && strength < BCrypt.MIN_LOG_ROUNDS || strength > BCrypt.MAX_LOG_ROUNDS)
            throw new IllegalArgumentException("bad strength");
        this.strength = strength;
        this.random = random;
    }

    public String encode(CharSequence rawPassword) {
        String salt;
        if (strength > 0) {
            if (random != null)
                salt = BCrypt.gensalt(strength, random);
            else
                salt = BCrypt.gensalt(strength);
        } else
            salt = BCrypt.gensalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() ==0) {
            logger.warn("Empty encoded password");
            return false;
        }
        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            logger.warn("Encoded password does not look like BCrypt");
            return false;
        }
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
