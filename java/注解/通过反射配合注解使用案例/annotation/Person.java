package org.example.annotation;

@ClassAnnotation(name = "personBean", version = "1.2.1")
public class Person {
    @FieldAnnotation(name = "description", value = "This is my personal annotation")
    private String description;

    @ConstructorAnnotatin(constructorName="Person()")
    public Person(String val) {
        System.out.println(val+"---val");
        description=val;
    }

    @FieldAnnotation(name = "xxx", value = "This is my personal annotation")
    private String description1;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @MethodAnnotation(name = "sayHello", type = MethodAnnotation.MethodTypeEnum.TYPE2)
    public void sayHello() {
        System.out.println("Hello Annotation!");
    }
}


