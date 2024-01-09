package com.steve.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: STEVE
 * @Description: 测试类
 * @since: 2023/12/21
 */
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

}
