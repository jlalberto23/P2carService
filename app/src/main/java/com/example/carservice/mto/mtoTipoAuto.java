package com.example.carservice.mto;

public class mtoTipoAuto {
    private int id_tipo_auto;
    private String tipo_auto;

    public mtoTipoAuto() {
    }

    public mtoTipoAuto(int id_tipo_auto, String tipo_auto) {
        this.id_tipo_auto = id_tipo_auto;
        this.tipo_auto = tipo_auto;
    }

    public int getId_tipo_auto() {
        return id_tipo_auto;
    }

    public void setId_tipo_auto(int id_tipo_auto) {
        this.id_tipo_auto = id_tipo_auto;
    }

    public String getTipo_auto() {
        return tipo_auto;
    }

    public void setTipo_auto(String tipo_auto) {
        this.tipo_auto = tipo_auto;
    }
}
