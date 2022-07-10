package com.course.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // helper class that contains business/validation logic
@Target({ ElementType.METHOD, ElementType.FIELD}) // indicates that where you can apply this annotation
@Retention(RetentionPolicy.RUNTIME) // How long the marked annotation will be used or stored. Runtime - retain this annotation in the Java class file and process it at runtime.
public @interface CourseCode {

    // default course code
    public String value() default "LUV";

    // default error message
    public String message() default "must start with LUV";

    // default groups
    public Class<?>[] groups() default {};

    // default payload - provide custom details about validation failure(security level, error code etc)
    public Class<? extends Payload>[] payload() default {};
}
