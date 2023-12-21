package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("XRay", 106);
      Car car2 = new Car("Toyota", 1742);
      Car car3 = new Car("Niva", 2141);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car3));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car1));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car2));

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);

      System.out.println(userService.getUserByCar("XRay", 106));

      context.close();
   }
}
