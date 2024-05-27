package com.example.lab4_fragmentjava;

public class UserData {
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;

    public UserData(String nombres, String apellidos, String usuario, String contrasena) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}
