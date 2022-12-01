@Configuration
public class AppConfig {

    @Bean("beanName")
    public String init() {
        return "test-bean";
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String c = context.getBean("beanName",String.class);
        System.out.println(c);
    }
}