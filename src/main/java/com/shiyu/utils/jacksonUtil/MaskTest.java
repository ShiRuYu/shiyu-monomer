package com.shiyu.utils.jacksonUtil;


import com.shiyu.utils.MaskRule;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

@Slf4j
class MaskTest {

    @Test
    void testMask() {
        User user = new User();
        user.setId(9L);
        user.setName("zhangsan");
        user.setMobile("13112345678");
        log.info("user={}", user);

        // 判断日志中是否脱敏
    }

    @Getter
    @Setter
    @ToString
    static class User implements Serializable {
        private Long id;
        @MaskLog(MaskRule.NAME)
        private String name;
        @MaskLog(MaskRule.MOBILE)
        private String mobile;
    }

}
