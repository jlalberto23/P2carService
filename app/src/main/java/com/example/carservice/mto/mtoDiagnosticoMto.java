package com.example.carservice.mto;

public class mtoDiagnosticoMto {
    private int id_diagnostico_mto;
    private String descripcion;

    public mtoDiagnosticoMto() {
    }

    public mtoDiagnosticoMto(int id_diagnostico_mto, String descripcion) {
        this.id_diagnostico_mto = id_diagnostico_mto;
        this.descripcion = descripcion;
    }

    public int getId_diagnostico_mto() {
        return id_diagnostico_mto;
    }

    public void setId_diagnostico_mto(int id_diagnostico_mto) {
        this.id_diagnostico_mto = id_diagnostico_mto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
