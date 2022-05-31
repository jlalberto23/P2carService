package com.example.carservice.mto;

public class mtoMarcaAuto extends mtoModeloAuto {
    private int id_marca;
    private String nombre_marca;

    public mtoMarcaAuto() {
    }

    public mtoMarcaAuto(int id_modelo, String nombre_modelo, int id_marca, String nombre_marca) {
        super(id_modelo, nombre_modelo);
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }
}
