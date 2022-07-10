package com.course.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefixes = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result = false;

        if (theCode != null){
            for (String tmpPrefix: coursePrefixes){
                result = theCode.startsWith(tmpPrefix);
                if (result){
                    break;
                }
            }
        } else {
            result = true;
        }
        return result;
    }
}
