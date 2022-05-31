package com.example.carservice.mto;

public class mtoDetalleMto {
    private int id_mto,id_falla;

    public mtoDetalleMto() {
    }

    public mtoDetalleMto(int id_mto, int id_falla) {
        this.id_mto = id_mto;
        this.id_falla = id_falla;
    }

    public int getId_mto() {
        return id_mto;
    }

    public void setId_mto(int id_mto) {
        this.id_mto = id_mto;
    }

    public int getId_falla() {
        return id_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }
}
