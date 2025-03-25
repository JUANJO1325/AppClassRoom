package com.example.ApiClassRoom.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    private Double score;

    @Temporal(TemporalType.DATE)
    private Date evaluationDate;

    public Grade() {
    }

    public Grade(Integer id, Double score, Date evaluationDate) {
        this.id = id;
        this.score = score;
        this.evaluationDate = evaluationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
