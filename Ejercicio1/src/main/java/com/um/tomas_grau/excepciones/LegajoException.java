package com.um.tomas_grau.excepciones;

public class LegajoException extends Exception{

    public LegajoException() {
        super("Ha ocurrido un problema con el legajo");
    }

    public LegajoException(String message) {
        super(message);
    }
}
