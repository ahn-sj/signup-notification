package tally.notification.application.infra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

import java.util.Objects;

@Slf4j
@Component
public class SnsPublisher {

    private final SnsClient snsClient;

    public SnsPublisher(
            final SnsClient snsClient
    ) {
        this.snsClient = Objects.requireNonNull(snsClient);
    }

    public void publishEvent(
            final String arn,
            final String payload
    ) {
        try {
            final PublishRequest message = PublishRequest.builder()
                    .topicArn(arn)
                    .message(payload)
                    .build();

            final PublishResponse published = snsClient.publish(message);
            log.info("Published event: {}", published);
            log.info("Published messageId: {}", published.messageId());
        } catch (SnsException e) {
            log.error("Publish event failed", e);
            throw e;
        }
    }
}
