package com.example.ApiClassRoom.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    public Attendance() {
    }

    public Attendance(Integer id, Date date, String status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
