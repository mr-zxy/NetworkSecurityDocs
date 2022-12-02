// 构造方法注入 Autowired
@Autowired
private String nameAll(@Qualifier("Person1") Person person){
    System.out.println(person.name+"person.name");
    return null;
};

// 构造方法注入 Bean
@Bean("beanTest")
public String test(@Qualifier("Person2") Person person1){
    System.out.println(person1.name+"person1");
    return null;
}

// 属性注入
@Autowired
@Qualifier("name1")
private String name1;

