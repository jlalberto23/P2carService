package com.example.carservice.mto;

public class mtoEmpleado {
    private int id_empleado, id_cargo;
    private String nombre, apellidos, usuario;

    public mtoEmpleado() {
    }

    public mtoEmpleado(int id_empleado, int id_cargo, String nombre, String apellidos, String usuario) {
        this.id_empleado = id_empleado;
        this.id_cargo = id_cargo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
