package com.vitaliy.appstore.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OneOfValidator implements ConstraintValidator<OneOf, Integer> {

    int[] contentRateValues;

    @Override
    public void initialize(OneOf oneOf) {
        contentRateValues = oneOf.value();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        //checking the content rate of certain numbers
        return integer == contentRateValues[0] | integer == contentRateValues[1] |
                integer == contentRateValues[2] | integer == contentRateValues[3] | integer == contentRateValues[4];
    }
}
