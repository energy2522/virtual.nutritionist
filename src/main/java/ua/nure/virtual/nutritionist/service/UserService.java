package ua.nure.virtual.nutritionist.service;

import java.util.Collections;
import java.util.List;

import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.virtual.nutritionist.domain.Role;
import ua.nure.virtual.nutritionist.domain.User;
import ua.nure.virtual.nutritionist.dto.UserDto;
import ua.nure.virtual.nutritionist.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private ConversionService conversionService;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ConversionService conversionService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<String> saveUser(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        Role role = new Role();
        role.setId(1);
        role.setName("user");
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return Collections.emptyList();
    }
}
