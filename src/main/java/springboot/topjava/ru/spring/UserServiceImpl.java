package springboot.topjava.ru.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Value("${spring.application.name}")
    String name;
    @Override
    public void pay() {
        System.out.println(name);
        //do some action
    }
}
