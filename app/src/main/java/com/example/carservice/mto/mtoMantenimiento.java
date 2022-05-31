package com.example.carservice.mto;

import java.util.Date;

public class mtoMantenimiento {
    private int id_mto,id_diagnostico,id_tipo_mto,id_sucursal,id_empleado;
    private String estado_mto,descripcion,fecha_mto, proximo_mto;

    public mtoMantenimiento() {
    }

    public mtoMantenimiento(int id_mto, int id_diagnostico, int id_tipo_mto, int id_sucursal, int id_empleado, String estado_mto, String descripcion, String fecha_mto, String proximo_mto) {
        this.id_mto = id_mto;
        this.id_diagnostico = id_diagnostico;
        this.id_tipo_mto = id_tipo_mto;
        this.id_sucursal = id_sucursal;
        this.id_empleado = id_empleado;
        this.estado_mto = estado_mto;
        this.descripcion = descripcion;
        this.fecha_mto = fecha_mto;
        this.proximo_mto = proximo_mto;
    }

    public int getId_mto() {
        return id_mto;
    }

    public void setId_mto(int id_mto) {
        this.id_mto = id_mto;
    }

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public int getId_tipo_mto() {
        return id_tipo_mto;
    }

    public void setId_tipo_mto(int id_tipo_mto) {
        this.id_tipo_mto = id_tipo_mto;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getEstado_mto() {
        return estado_mto;
    }

    public void setEstado_mto(String estado_mto) {
        this.estado_mto = estado_mto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_mto() {
        return fecha_mto;
    }

    public void setFecha_mto(String fecha_mto) {
        this.fecha_mto = fecha_mto;
    }

    public String getProximo_mto() {
        return proximo_mto;
    }

    public void setProximo_mto(String proximo_mto) {
        this.proximo_mto = proximo_mto;
    }
}