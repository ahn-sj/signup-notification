package tally.notification.application.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsSignupListener {

    @SqsListener("${aws.sqs.queue.name.user-signup}")
    public void handleWelcomeMail(String rawMessage) {
        log.info(rawMessage);
    }
}
