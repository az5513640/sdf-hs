package com.sdf.demo.test;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @ClassName FileTest
 * @Description: TODO
 * @Author ShuDingfeng
 * @createDate 2020-06-05-15:25
 * @Version 1.0
 **/

public class FileTest {

    @Test
    private void test1(){
        File file = new File("E:\\downmoban\\imptempfile\\{0A00007F-FFFF-FFFF-8324-0AF700000001}.xlsx");
        System.out.println(file.getName());
    }
}
