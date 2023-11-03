import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
        public static void main(String[] args) {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

            HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloworld");
            HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloworld");

            Cat cat1 = (Cat) applicationContext.getBean("cat");
            Cat cat2 = (Cat) applicationContext.getBean("cat");

            System.out.println("HelloWorld: " + (helloWorld1 == helloWorld2));
            System.out.println("Cat: " + (cat1 == cat2));
        }
    }