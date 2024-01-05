package com.steve.springboot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: STEVE
 * @Description: 自定义数字字符串格式校验器 - 校验是否由正整数组成且是否为空
 * @since: 2024/1/5
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsPositiveIntegerValidator.class)
public @interface IsPositiveInteger {

    /**
     * 错误信息
     *
     * @return
     */
    String message() default "数字字符串字段格式错误，应上送非空的正整数字符串";

    /**
     * 是否可以为空
     *
     * @return
     */
    boolean blankable() default false;

    /**
     * 默认值
     *
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 默认值
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};

}
