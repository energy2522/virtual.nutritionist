package ua.nure.virtual.nutritionist.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserDto {

    private int id;
    private String username;
    private String password;
    private String birthday;
    private int age;
    private String email;
    private String sex;
    private double weight;
    private double height;
}
