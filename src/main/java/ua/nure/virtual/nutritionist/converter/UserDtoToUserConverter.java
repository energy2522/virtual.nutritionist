package ua.nure.virtual.nutritionist.converter;

import org.springframework.core.convert.converter.Converter;

import ua.nure.virtual.nutritionist.domain.User;
import ua.nure.virtual.nutritionist.dto.UserDto;
import ua.nure.virtual.nutritionist.service.DateTimeService;

public class UserDtoToUserConverter implements Converter<UserDto, User> {
    private DateTimeService dateTimeService;

    public UserDtoToUserConverter(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setSex(userDto.getSex());
        user.setBirthday(dateTimeService.parseDate(userDto.getBirthday()));

        return user;
    }
}
