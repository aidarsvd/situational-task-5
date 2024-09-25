package kg.alatoo.weatherwatch.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kg.alatoo.weatherwatch.dto.SignUpUserDto;
import kg.alatoo.weatherwatch.dto.SuccessDto;
import kg.alatoo.weatherwatch.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trusted/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/sign-up")
    @Operation(summary = "Signup to system")
    public SuccessDto signUp(@Valid @RequestBody SignUpUserDto signUpUserDto) {
        userService.saveUser(signUpUserDto);
        return SuccessDto.builder().build();
    }

}
