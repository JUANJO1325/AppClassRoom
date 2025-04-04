package com.example.ApiClassRoom.services;
import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.repositories.ITeacherRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    @Autowired//Inyeccion de dependendicias que sirve para traer una clase s oatra y tulizarla en una secundaria
    ITeacherRepositories repositorie;

    //En el servicio implementamos los metodos

    //Que necesitamos segun los servicios a ofrecer

    //El optional es un tipo de datos, donde puedo tener los datos, o puedo tener un null si no estan

    //Guardar

    public Teacher saveTeacher(Teacher dataTeacher) throws Exception {
        try {
            return this.repositorie.save(dataTeacher);
        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    //Actualizar

    public Teacher modifyTeacher(Integer id, Teacher dataTeacher) throws Exception {
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opciones (Puede estar o no)
            Optional<Teacher> searchTeacher = this.repositorie.findById(id);

            // Apenas los busques pregunta si si estaba

            if (searchTeacher.isPresent()) {
                //Modifiquelo pues papa
                searchTeacher.get().setSpecialty(dataTeacher.getSpecialty());  // Modificar un dato viejo
                return this.repositorie.save(searchTeacher.get());

            } else {
                // No estaba
                throw new Exception("The user to be modified is not found in the DB");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

        //Buscar por Id


        //Buscar todos


        //Eliminar

    }
}