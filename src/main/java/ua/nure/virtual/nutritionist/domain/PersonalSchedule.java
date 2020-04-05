package ua.nure.virtual.nutritionist.domain;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "personal_schedule")
public class PersonalSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day", nullable = false)
    private Date day;

    @Column(name = "time", nullable = false)
    private Time time;

    @Column(name = "done", nullable = false)
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "personal_diet_id", nullable = false)
    private PersonalDiet personalDiet;


}
