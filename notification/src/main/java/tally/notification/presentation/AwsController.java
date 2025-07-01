package tally.notification.presentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tally.notification.application.infra.SnsPublisher;

import java.util.Objects;

@RestController
public class AwsController {

    public final SnsPublisher snsPublisher;
    private String arn;

    public AwsController(
            final SnsPublisher snsPublisher,
            @Value("${aws.sns.topic.arn.user-signup}") final String arn
    ) {
        this.snsPublisher = Objects.requireNonNull(snsPublisher);
        this.arn = arn;
    }

    @PostMapping("/sns/publish")
    public void snsPublish(
            @RequestBody PublishRequest request
    ) {
        snsPublisher.publishEvent(arn, request.payload);
    }

    public record PublishRequest(String payload) {}
}
