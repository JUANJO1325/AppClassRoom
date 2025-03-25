package com.example.ApiClassRoom.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public Registration() {
    }

    public Registration(Integer id, Date registrationDate) {
        this.id = id;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
