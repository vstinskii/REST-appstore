package com.vitaliy.appstore.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = OneOfValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OneOf {

    int[] value();

    String message() default "Content rate must be one of the following : 3, 7, 12, 16, 18";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
