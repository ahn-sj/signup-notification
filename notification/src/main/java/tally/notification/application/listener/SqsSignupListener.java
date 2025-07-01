package tally.notification.application.listener;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsSignupListener {

    @SqsListener("${aws.sqs.queue.name.signup-welcome-email}")
    public void handleWelcomeMail(String rawMessage) {
        log.info("[send mail] message = {}", rawMessage);
    }

    @SqsListener("${aws.sqs.queue.name.signup-welcome-coupon}")
    public void handleWelcomeCoupon(String rawMessage) {
        log.info("[issue coupon] message = {}", rawMessage);
    }
}
