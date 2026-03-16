package br.dev.arthdroid1.SpringCRUDProject.config;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.User;
import br.dev.arthdroid1.SpringCRUDProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Artwa Broa", "artwa@gmail.com", "9888388888", "123456");
        User u2= new User(null, "Linda Brim", "linda@gmail.com", "9888379688", "123457");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
