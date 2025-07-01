package tally.notification.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    private User(final String email, final String name) {
        Assert.hasText(email, "이메일은 비어 있을 수 없습니다.");
        Assert.hasText(name, "이름은 비어 있을 수 없습니다.");

        this.email = email;
        this.name = name;
    }

    public static User signUp(
            final String email,
            final String name
    ) {
        return new User(email, name);
    }
}
