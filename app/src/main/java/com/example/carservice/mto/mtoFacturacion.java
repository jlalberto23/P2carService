package com.example.carservice.mto;

import java.util.Date;

public class mtoFacturacion {
    private int id_facturacion,id_mto;
    private double monto,efectivo,cambio;
    private String fecha_factura;

    public mtoFacturacion() {
    }

    public mtoFacturacion(int id_facturacion, int id_mto, double monto, double efectivo, double cambio, String fecha_factura) {
        this.id_facturacion = id_facturacion;
        this.id_mto = id_mto;
        this.monto = monto;
        this.efectivo = efectivo;
        this.cambio = cambio;
        this.fecha_factura = fecha_factura;
    }

    public int getId_facturacion() {
        return id_facturacion;
    }

    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public int getId_mto() {
        return id_mto;
    }

    public void setId_mto(int id_mto) {
        this.id_mto = id_mto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }
}