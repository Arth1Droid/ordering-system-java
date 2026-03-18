package br.dev.arthdroid1.SpringCRUDProject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Category;
import br.dev.arthdroid1.SpringCRUDProject.models.entities.Order;
import br.dev.arthdroid1.SpringCRUDProject.models.entities.User;
import br.dev.arthdroid1.SpringCRUDProject.models.entities.enums.OrderStatus;
import br.dev.arthdroid1.SpringCRUDProject.repositories.CategoryRepository;
import br.dev.arthdroid1.SpringCRUDProject.repositories.OrderRepository;
import br.dev.arthdroid1.SpringCRUDProject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
 
    @Override
    public void run(String... args) throws Exception {
    	
        Category category1 = new Category("Eletronics", null);
        Category category2 = new Category("Books", null);
        Category category3 = new Category("Computers", null);
        
        User u1 = new User(null, "Artwa Broa", "artwa@gmail.com", "9888388888", "123456");
        User u2= new User(null, "Linda Brim", "linda@gmail.com", "9888379688", "123457");

        Order order1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order order2 = new Order(null, Instant.parse("2025-07-20T18:53:06Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order order3 = new Order(null, Instant.parse("2025-07-20T16:30:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(order1,order2,order2));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }
}
