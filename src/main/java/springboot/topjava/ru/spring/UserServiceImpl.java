package springboot.topjava.ru.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired ConfigProperties configProperties;
    @Value("${spring.application.name}")
    String name;
    @Override
    public BaseResponse pay(BaseResponse response) {
        System.out.println(name);
        response.setAge(configProperties.getAge());
        response.setPayment(configProperties.getPayment());
        return  response;
    }
}
