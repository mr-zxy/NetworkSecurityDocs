``` java
@Primary：意思是在众多相同的bean中，优先使用用@Primary注解的bean。

1.在多数据源的时候，使用@Primary注解用于指定其中一个作为主数据源，即如果数据库操作没有指明使用哪个数据源的时候，默认使用主数据源，这个时候我们就使用到了@primary这个注解。

在此之前先认识一下@Qualifier、@Bean注解的意思：

@Qualifier：指定某个bean有没有资格进行注入。

@Bean：用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
```
```java
     @Autowired
    public Person person;
```
> 由此可以看出 同时注入了两个一样类型的的Bean，正常情况会抛出异常的，但是使用了@Primary只有 Person1 被正常引用了，没有产生报错。打印：name。
> 注意：一定要给Bean加上名称。
```java
@Configuration
public class QuickstartConfiguration {
    @Bean("Person2")
    public Person person() {
        Person person = new Person();
        person.name="name2";
        return person;
    }
}
```java
@Component("Person1")
@Primary
public class Person {
    public String name="name";
}
```