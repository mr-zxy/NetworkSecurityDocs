package org.example.annotation;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface MethodAnnotation {
    public enum MethodTypeEnum {
        TYPE1,TYPE2
    }
    public String name() default "defaultName";
    public MethodTypeEnum type() default MethodTypeEnum.TYPE1;
}

