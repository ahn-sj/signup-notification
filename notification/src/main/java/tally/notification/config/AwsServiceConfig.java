package tally.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsServiceConfig {

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder().build();
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder().build();
    }
}
