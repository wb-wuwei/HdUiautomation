package com.testng.cn;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
  TestNG 部分常用校验方式
 相等：
 Assert.assertEquals();
 不等：
 Assert.assertNotEquals();
 不为空：
 Assert.assertNotNull();
 为空
 Assert.assertNull();
 */
public class TestNgDemo2 {
    /**
     * 注意：断言后最好不要接case（可以接建议不要接），断言后可以继续接断言，  如场景：登陆成功后
     * 在继续操作新增或者删除，可以直接另外在写一个case,
     */
    @Test
    public  void asserteQualsTest(){
        //相等 Assert.assertEquals();
        String c="a";
        String d="a";
        Assert.assertEquals(c,d);

        //失败
        String a="a";
        String b="b";
        Assert.assertEquals(a,b,"不相等");
    }
    @Test
    public  void asserteQualsTest1(){
        //不等：Assert.assertNotEquals();
        String c="a";
        String d="b";
        Assert.assertNotEquals(c,d);
    }

    @Test
    public  void assertNotNullTest(){
        //不为空：
        // Assert.assertNotNull();
        String s="";
        Assert.assertNotNull(s);
    }
    @Test
    public void assertNullTest(){
        // 为空
        // Assert.assertNull();
        String s=null;
        Assert.assertNull(s);
    }
}
