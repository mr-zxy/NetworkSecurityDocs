# 元注解的作用就是负责注解其他注解，元注解有以下6种
* @Retention：指定其所修饰的注解的保留策略
* @Document：该注解是一个标记注解，用于指示一个注解将被文档化
* @Target：用来限制注解的使用范围
* @Inherited：该注解使父类的注解能被其子类继承
* @Repeatable：该注解是Java8新增的注解，用于开发重复注解
类型注解（Type Annotation）：该注解是Java8新增的注解，可以用在任何用到类型的地方
>Retention注解
1. Retention注解注解用于指定被修饰的注解可以保留多长时间，即指定JVM策略在哪个时间点上删除当前注解。保留策略值有以下三个：
    * Retention.SOURCE 注解只在源文件中保留，在编译期间删除
    * Retention.CLASS 注解只在编译期间存在于.class文件中，运行时JVM不可获取注解信息，该策略值也是默认值
    * Retention.RUNTIME	 运行时JVM可以获取注解信息（反射），是最长注解持续期
> Document注解
1. Document注解用于指定被修饰的注解可以被javadoc工具提取成文档。定义注解类时使用@Document注解进行修饰，则所有使用该注解修饰的程序元素的API文档中将会包含该注解说明。
> Target注解
1. @Target注解用来限制注解的使用范围，即指定被修饰的注解能用于哪些程序单元
```java
@Target({ElementType.Type,ElementType.FIELD	})
```
* ElementType.Type 可以修饰类、接口、注解或枚举类型
* ElementType.FIELD  可以修饰属性（成员变量），包括枚举常量
* ElementType.METHOD 可以修饰方法
* ElementType.PAPAMETER 可以修饰参数
* ElementType.CONSTRUCTOR 可以修饰构造方法
* ElementType.LOCAL_VARIABLE 可以修饰局部变量
* ElementType.ANNOTATION_TYPE 可以修饰注解类
* ElementType.PACKAGE 可以修饰包
---
* ElementType.TYPE_USE Java8为ElementType枚举增加了TYPE_PARAMETER和TYPE_USE两个枚举类值，允许在定义枚举类时使用,在Java8之前，只能在定义类、接口、方法和成员变量等程序元素时使用注解，从Java8开始新增的类型注解可以用在任何用到类型的地方。
除了在定义类、接口和方法等常见的程序元素时可以使用类型注解，还可以在以下几个位置使用类型注解进行修饰：
* 创建对象（使用new关键字创建）
* 类型转换
* 使用implements实现接口
* 使用throws声明抛出异常序列

```java
//定义一个简单的类型注解，不带任何成员变量
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface NotNull{
    String value();
}

//定义类时使用@NotNull类型注解
@NotNull("demo")
public class Demo {
    @NotNull("age")
    public Integer age = 21;
    @NotNull("age12")
    public Integer age1 = 21;

    public @NotNull("number") Integer number(@NotNull("不可为空") Integer num) {
        return num;
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Annotation[] annotations = Demo.class.getAnnotations();
        System.out.println("类上的注解 = " + annotations[0]);

        AnnotatedType[] numbers1 = Demo.class.getMethod("number", Integer.class).getAnnotatedParameterTypes();
        Annotation[] annotations1 = numbers1[0].getAnnotations();
        System.out.println("形参上的注解 = " + annotations1[0]);


        AnnotatedType number = Demo.class.getMethod("number", Integer.class).getAnnotatedReturnType();
        System.out.println("方法返回值的注解 = " + number.getAnnotation(NotNull.class));

        NotNull notNull = Demo.class.getField("age1").getAnnotatedType().getAnnotation(NotNull.class);
        System.out.println("成员变量上的注解 = " + notNull.value());

        Annotation[][] numbers2 = Demo.class.getMethod("number", Integer.class).getParameterAnnotations();
        System.out.println("形参注解长度: " + numbers2[0].length);

    }
}
```

>Inherited注解
1. @Inherited注解指定注解具有继承性，如果某个注解使用@Inherited进行修饰，则该类使用该注解时，其子类将自动被修饰
2. 例子：使用父级构造方法可以拿到继承事例的参数
``` java 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface InheritedAnno1 {
    String comment();
    int order() default 1;
}

//使用自定义的@InheritedAnno1注解修饰Base
@InheritedAnno1(comment = "继承注解", order = 2)
class Base{

}
//InheritedDemo只继承了Base类
//并未直接使用@InheritedAnno1注解
public class InheritedDemo extends Base{
    public static void main(String[] args) {
        //从InheritedDemo中获取InheritedAnno1注解信息
        InheritedAnno1 anno = InheritedDemo.class.getAnnotation(InheritedAnno1.class);
        //输出InheritedAnno1注解成员信息
        System.out.println(anno.comment()+":"+anno.order());
        //打印InheritedDemo类是否具有@InheritedAnno1修饰
        System.out.println(InheritedDemo.class.isAnnotationPresent(InheritedAnno1.class));
    }
}
```
> @Repeatable注解是Java8新增的注解，用于开发重复注解。在Java8之前，同一个程序元素前只能使用一个相同类型的注解，如果需要在同一个元素前使用多个相同类型的注解必须通过注解容器来实现。从Java8开始，允许使用多个相同的类型注解来修饰同一个元素，前提是该类型的注解是可重复的，即在定义注解时要用 @Repeatable元注解进行修饰。
* jdk8之前不存在可重复注解，即一个注解不能出现在同一个元素(Class、Method、Constructor、Field)2次以上。下面的写法是被禁止的：
```java
@RepeatableAnnol(age = 10)
@RepeatableAnnol(name = "寻找南瓜", age = 22)
public class RepeatableAnnolDemo {
    
}
```
* 使用 @Repeatable(AnnolContents.class) 注解解决
```java

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnolContents {//该注解是容器

    //定义value成员变量，该成员变量可以接受多个@RepeatableAnnol注解
    RepeatableAnnol[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(AnnolContents.class)
@interface RepeatableAnnol {
    String name() default "南瓜仔仔";

    int age();
}

@RepeatableAnnol(age = 10)
@RepeatableAnnol(name = "寻找南瓜", age = 22)
public class RepeatableAnnolDemo {
    public static void main(String[] args) {
        //使用java8新增的getDeclaredAnnotationsByType()方法获取
        //修饰类的多个@RepeatableAnnol注解
        RepeatableAnnol[] annols = RepeatableAnnolDemo.class.getDeclaredAnnotationsByType(RepeatableAnnol.class);
        //遍历@RepeatableAnnol注解并显示
        for (RepeatableAnnol annol : annols) {
            System.out.println(annol.name() + "--->" + annol.age());
        }
        //使用传统的getDeclaredAnnotation()方法获取修饰类的@AnnolContents注解
        AnnolContents container = RepeatableAnnolDemo.class.getDeclaredAnnotation(AnnolContents.class);
        System.out.println(container);
    }
}

```
>