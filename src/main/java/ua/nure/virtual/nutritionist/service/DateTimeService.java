package ua.nure.virtual.nutritionist.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateTimeService {
    private String DATE_PATTERN = "dd/MM/yyyy";

    public Date parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        return Date.valueOf(LocalDate.parse(date, formatter));
    }
}
