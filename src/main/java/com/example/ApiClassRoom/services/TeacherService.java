package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.aids.MessageAPI;
import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.repositories.ITeacherRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    ITeacherRepositories repositorie;

    // Guardar
    public Teacher saveTeacher(Teacher dataTeacher) throws Exception {
        try {
            return this.repositorie.save(dataTeacher);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Actualizar
    public Teacher modifyTeacher(Integer id, Teacher dataTeacher) throws Exception {
        try {
            Optional<Teacher> searchTeacher = this.repositorie.findById(id);
            if (searchTeacher.isPresent()) {
                searchTeacher.get().setSpecialty(dataTeacher.getSpecialty());
                return this.repositorie.save(searchTeacher.get());
            } else {
                throw new Exception(MessageAPI.DOCENTE_NO_ENCONTRADO.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por Id
    public Teacher searchTeacherId(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherInSearch = this.repositorie.findById(id);
            if (teacherInSearch.isPresent()) {
                return teacherInSearch.get();
            } else {
                throw new Exception(MessageAPI.DOCENTE_NO_ENCONTRADO.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos
    public List<Teacher> searchAllTeacher() throws Exception {
        try {
            return this.repositorie.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public boolean deleteTeacher(Integer id) throws Exception {
        try {
            Optional<Teacher> searchTeacher = this.repositorie.findById(id);
            if (searchTeacher.isPresent()) {
                this.repositorie.deleteById(id); // puedes eliminarlo aquí si deseas
                return true;
            } else {
                throw new Exception(MessageAPI.DOCENTE_NO_ENCONTRADO.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
