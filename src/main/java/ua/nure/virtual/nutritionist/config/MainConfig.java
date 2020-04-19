package ua.nure.virtual.nutritionist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ua.nure.virtual.nutritionist.converter.UserDtoToUserConverter;
import ua.nure.virtual.nutritionist.service.DateTimeService;

@Configuration
public class MainConfig implements WebMvcConfigurer {
    private DateTimeService dateTimeService;

    public MainConfig(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserDtoToUserConverter(dateTimeService));
    }
}
