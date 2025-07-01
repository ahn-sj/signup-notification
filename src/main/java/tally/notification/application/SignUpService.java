package tally.notification.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tally.notification.domain.entity.User;
import tally.notification.persistence.impl.UserJpaRepository;

@Slf4j
@Service
public class SignUpService {

    private final UserJpaRepository userJpaRepository;

    public SignUpService(final UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public void signUp(
            final String email,
            final String name
    ) {
        final User user = User.signUp(email, name);
        userJpaRepository.save(user);
    }
}
