package com.example.carservice.mto;

public class mtoCategoriaFalla {
    private int id_categoria_falla;
    private String nombre_categoria_falla, descripcion;

    public mtoCategoriaFalla() {
    }

    public mtoCategoriaFalla(int id_categoria_falla, String nombre_categoria_falla, String descripcion) {
        this.id_categoria_falla = id_categoria_falla;
        this.nombre_categoria_falla = nombre_categoria_falla;
        this.descripcion = descripcion;
    }

    public int getId_categoria_falla() {
        return id_categoria_falla;
    }

    public void setId_categoria_falla(int id_categoria_falla) {
        this.id_categoria_falla = id_categoria_falla;
    }

    public String getNombre_categoria_falla() {
        return nombre_categoria_falla;
    }

    public void setNombre_categoria_falla(String nombre_categoria_falla) {
        this.nombre_categoria_falla = nombre_categoria_falla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
