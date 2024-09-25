package kg.alatoo.weatherwatch.services.user.impl;


import kg.alatoo.weatherwatch.dto.SignUpUserDto;
import kg.alatoo.weatherwatch.entities.UserAuthorityEntity;
import kg.alatoo.weatherwatch.entities.UserEntity;
import kg.alatoo.weatherwatch.exceptions.ApiException;
import kg.alatoo.weatherwatch.models.AppUserDetails;
import kg.alatoo.weatherwatch.models.AuthorityModel;
import kg.alatoo.weatherwatch.repositories.AuthorityRepository;
import kg.alatoo.weatherwatch.repositories.UserRepository;
import kg.alatoo.weatherwatch.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u -> new AppUserDetails(
                                u.getId(),
                                u.getUsername(),
                                u.getName(),
                                u.getPassword(),
                                u.getAuthorities().stream().map(a -> new AuthorityModel(a.getName(), a.getDescription())).toList(),
                                u.getCreatedAt()
                        )
                )
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    @Override
    public void saveUser(SignUpUserDto userDto) {
        log.info("Sign up user: {}", userDto.getUsername());
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setAuthorities(authorityRepository.findAllByNameIn(List.of("default")));
        try {
            userRepository.save(userEntity);
            log.info("User: {} is signed up", userDto.getUsername());
        } catch (DataIntegrityViolationException e) {
            log.error("Exception when user saving", e);
            throw new ApiException("Idempotency error, user already exists", HttpStatusCode.valueOf(409));
        } catch (Exception e) {
            throw new ApiException("Error while user creating", HttpStatusCode.valueOf(400));
        }
    }

}
