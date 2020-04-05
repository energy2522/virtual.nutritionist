package ua.nure.virtual.nutritionist.domain;

import java.sql.Date;
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
@Table(name = "personal_diet")
public class PersonalDiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "goal")
    private double goal;

    @ManyToOne
    @JoinColumn(name = "diet_id", nullable = false)
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
