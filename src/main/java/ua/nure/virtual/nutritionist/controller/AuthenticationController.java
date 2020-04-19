package ua.nure.virtual.nutritionist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import ua.nure.virtual.nutritionist.dto.UserDto;
import ua.nure.virtual.nutritionist.service.SecurityService;
import ua.nure.virtual.nutritionist.service.UserService;

@Slf4j
@Controller
public class AuthenticationController {
    private UserService userService;
    private SecurityService securityService;

    public AuthenticationController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping({"/", "/signin"})
    public String main() {
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(UserDto userDto) {
        return "main";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserDto userDto, BindingResult bindingResult, RedirectAttributes attributes) {
        userService.saveUser(userDto);
        securityService.login(userDto.getUsername(), userDto.getPassword());

        return "redirect:/main";
    }
}
