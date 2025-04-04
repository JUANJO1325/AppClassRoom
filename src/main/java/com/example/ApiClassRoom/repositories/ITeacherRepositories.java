package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepositories extends JpaRepository<Teacher, Integer> {
}
