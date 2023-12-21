package com.steve.demo.designMode.adapter.interfaceadapter;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/12/14
 */
public class WrapperTest {

    public static void main(String[] args) {
        SourceSub1 source1 = new SourceSub1();
        SourceSub2 source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }

}
