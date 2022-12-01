package org.example.annotation;
import java.lang.annotation.*;
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
    public String name() default "defaultName";
    public String value() default "defaultValue";
}

