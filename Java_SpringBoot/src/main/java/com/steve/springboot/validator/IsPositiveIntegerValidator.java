package com.steve.springboot.validator;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: STEVE
 * @Description: 自定义正整数非空字符串格式校验
 * @since: 2024/1/5
 */
public class IsPositiveIntegerValidator implements ConstraintValidator<IsPositiveInteger, String> {

    /**
     * 是否可以为空
     */
    private boolean blankable;

    @Override
    public void initialize(IsPositiveInteger constraintAnnotation) {
        this.blankable = constraintAnnotation.blankable();
    }

    /**
     * 检验字段是否有效
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        /* 如果不能为空 */
        if(BooleanUtil.isFalse(blankable) && StrUtil.isBlank(value)) {
            return false;
        }
        /* 校验字符串格式是否为正整数的正则表达式 */
        String regex = "^\\+?[1-9][0-9]*$";
        /* 组件正则Pattern */
        Pattern regexPattern = Pattern.compile(regex);
        if(StrUtil.isNotBlank(value)) {
            /* 进行匹配 */
            Matcher matcher = regexPattern.matcher(value);
            if(!matcher.find()){
                /* 未匹配到 */
                return false;
            }
        }
        /* 匹配到 */
        return true;
    }

}
