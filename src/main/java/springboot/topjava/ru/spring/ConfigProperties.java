package springboot.topjava.ru.spring;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "default")


public class ConfigProperties {
    private Integer age;
    private Integer payment;

    public Integer getAge() {
        return age;
    }

    public Integer getPayment() {
        return payment;
    }

}
