@RestController
public class BookController {
    // 定义属性
    @Autowired
    private ComponentDemo componentDemo;
    // 定义方法
    @Autowired
    private String nameAll(ComponentDemo componentDemo){
        System.out.println(componentDemo.getName());
        return null;
    };
}