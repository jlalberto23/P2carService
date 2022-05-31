package com.example.carservice.mto;

public class mtoAuto extends mtoMarcaAuto {
    private int id_auto,id_tipo_auto, año;
    private String placa;

    public mtoAuto() {
    }

    public mtoAuto(int id_modelo, String nombre_modelo, int id_marca, String nombre_marca, int id_auto, int id_tipo_auto, int año, String placa) {
        super(id_modelo, nombre_modelo, id_marca, nombre_marca);
        this.id_auto = id_auto;
        this.id_tipo_auto = id_tipo_auto;
        this.año = año;
        this.placa = placa;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public int getId_tipo_auto() {
        return id_tipo_auto;
    }

    public void setId_tipo_auto(int id_tipo_auto) {
        this.id_tipo_auto = id_tipo_auto;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
