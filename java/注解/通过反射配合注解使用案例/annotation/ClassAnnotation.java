package org.example.annotation;
import java.lang.annotation.*;

@Documented    //定义可以被文档工具文档化
@Retention(RetentionPolicy.RUNTIME)//声明周期为runtime，运行时可以通过反射拿到
@Target(ElementType.TYPE)//注解修饰范围为类、接口、枚举
public @interface ClassAnnotation {
    public String name() default "defaultService";
    public String version() default "1.1.0";
}

