package com.example.carservice.mto;

public class mtoTipoMto {
    private int id_tipo_mto;
    private String nombre_tipo_mto;

    public mtoTipoMto() {
    }

    public mtoTipoMto(int id_tipo_mto, String nombre_tipo_mto) {
        this.id_tipo_mto = id_tipo_mto;
        this.nombre_tipo_mto = nombre_tipo_mto;
    }

    public int getId_tipo_mto() {
        return id_tipo_mto;
    }

    public void setId_tipo_mto(int id_tipo_mto) {
        this.id_tipo_mto = id_tipo_mto;
    }

    public String getNombre_tipo_mto() {
        return nombre_tipo_mto;
    }

    public void setNombre_tipo_mto(String nombre_tipo_mto) {
        this.nombre_tipo_mto = nombre_tipo_mto;
    }
}
