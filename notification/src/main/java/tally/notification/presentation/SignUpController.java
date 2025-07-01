package tally.notification.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tally.notification.application.SignUpService;
import tally.notification.presentation.dto.SignUpRequest;

@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/api/v1/signup")
    public void signUp(
            @RequestBody SignUpRequest signUpRequest
    ) {
        signUpService.signUp(signUpRequest.getEmail(), signUpRequest.getName());
    }
}
