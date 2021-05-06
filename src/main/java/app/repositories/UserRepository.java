package app.repositories;

import app.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private List<User> users = new ArrayList<>();

    @Bean
    @PostConstruct
    public void initUsers() {
        users.add(new User("Artem", "123", "ADMIN"));
        users.add(new User("Andrew", "123", "ADMIN"));
    }

    public User getByName(String name) {
        return users.stream().filter(x -> (x.getName().equals(name))).findFirst().orElseThrow();
    }
}
