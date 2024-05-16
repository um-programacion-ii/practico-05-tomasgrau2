package com.um.tomas_grau;

import com.um.tomas_grau.excepciones.LegajoException;

public class Main {
    public static void main(String[] args) throws LegajoException {
        Alumno carlos = new Alumno("Carlos","Pinzas");
        Alumno andres = new Alumno("Andres","Pinzas");
        AlumnoDao dao = new AlumnoDao();

        dao.create(1,carlos);
        dao.create(1,andres);
        Alumno alumno = dao.get(2);
        System.out.println(alumno);
    }
}