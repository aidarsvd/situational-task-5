package kg.alatoo.weatherwatch.services.user;



import kg.alatoo.weatherwatch.dto.SignUpUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveUser(SignUpUserDto signUpUserDto);

}
