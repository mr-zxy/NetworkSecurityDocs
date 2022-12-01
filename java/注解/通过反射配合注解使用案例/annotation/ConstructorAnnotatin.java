package org.example.annotation;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR})
public @interface ConstructorAnnotatin {
    String constructorName() default "";
    String remark() default "构造器";
}
