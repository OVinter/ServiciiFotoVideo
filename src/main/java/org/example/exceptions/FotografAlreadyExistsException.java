package org.example.exceptions;

public class FotografAlreadyExistsException extends Exception {

    private String rol;

    public FotografAlreadyExistsException(String rol) {
        super(String.format("An account with the\nrole %s already exists!", rol));
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
