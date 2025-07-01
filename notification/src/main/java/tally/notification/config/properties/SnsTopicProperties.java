package tally.notification.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "aws.sns.topic.arn")
@AllArgsConstructor
public class SnsTopicProperties {
    private final String userSignup;
}
