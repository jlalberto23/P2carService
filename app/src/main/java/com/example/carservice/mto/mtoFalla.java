package com.example.carservice.mto;

public class mtoFalla extends mtoCategoriaFalla {
    private int id_falla;
    private  String descripcion;

    public mtoFalla() {
    }

    public mtoFalla(int id_categoria_falla, String nombre_categoria_falla, String descripcion, int id_falla, String descripcion1) {
        super(id_categoria_falla, nombre_categoria_falla, descripcion);
        this.id_falla = id_falla;
        this.descripcion = descripcion1;
    }

    public int getId_falla() {
        return id_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
