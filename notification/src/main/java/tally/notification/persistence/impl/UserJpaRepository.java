package tally.notification.persistence.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import tally.notification.domain.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
