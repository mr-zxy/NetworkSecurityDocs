// 构造方法注入
@Autowired
private String nameAll(@Qualifier("Person1") Person person){
    System.out.println(person.name+"person.name");
    return null;
};

// 属性注入
@Autowired
@Qualifier("name1")
private String name1;