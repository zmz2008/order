package com.meipingmi.domain.order.test;

import com.baomidou.mybatisplus.core.toolkit.AES;

/***
 * @Description : TODO
 * @Author : zhoumiaozhong
 * @Date : 2020/7/13-17:57
 */
public class AesTest {

    public static void main(String[] args) {
        String randomKey = AES.generateRandomKey();
        System.out.println(randomKey);
        String result = AES.encrypt("mpm_test", randomKey);
        System.out.println(result);
        String result1 = AES.encrypt("mpm@t#", randomKey);
        System.out.println(result1);
    }
}
