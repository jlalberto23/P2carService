package com.example.carservice.mto;

public class mtoDiagnosticoFalla {
    private int id_falla, id_diagnostico;

    public mtoDiagnosticoFalla() {
    }

    public mtoDiagnosticoFalla(int id_falla, int id_diagnostico) {
        this.id_falla = id_falla;
        this.id_diagnostico = id_diagnostico;
    }

    public int getId_falla() {
        return id_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }
}
