package com.um.tomas_grau;

import com.um.tomas_grau.excepciones.LegajoException;

import java.util.HashMap;

public class AlumnoDao {

    private HashMap<Integer, Alumno> alumnos = new HashMap<Integer, Alumno>();

    public AlumnoDao() {
    }

    public void create(int legajo, Alumno alumno) throws LegajoException {
        if (legajo <= 0){
            throw new LegajoException("El numero de legajo debe ser mayor a 0");
        }

        if (alumnos.get(legajo) == null){
            alumnos.put(legajo, alumno);
        }
        else{
            System.out.println("No se pudo ingresar al alumno " + alumno.getNombre() + " " + alumno.getApellido() + ", este legajo ya existe");
        }
    }

    public Alumno get(int legajo) {
        return alumnos.get(legajo);
    }

    public void update(int legajo, String nombre, String apellido) {
        Alumno alumno_update = alumnos.get(legajo);
        alumno_update.setNombre(nombre);
        alumno_update.setApellido(apellido);
        alumnos.put(legajo, alumno_update);
    }

    public String delete(int legajo){
        if (alumnos.get(legajo) != null) {
            String nombre = alumnos.get(legajo).getNombre();
            String apellido = alumnos.get(legajo).getApellido();

            alumnos.remove(legajo);
            return "El alumno " + nombre + " " + apellido + " fue eliminado de la base de datos";
        }
        else {
            return "No existe ningun alumno con este numero de legajo";
        }
    }
}
