package tally.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tally.notification.config.properties.SnsTopicProperties;

@EnableConfigurationProperties(
        SnsTopicProperties.class
)
@SpringBootApplication
public class SimpleNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleNotificationApplication.class, args);
    }

}
