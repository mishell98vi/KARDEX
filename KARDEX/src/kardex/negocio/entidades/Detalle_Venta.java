package kardex.negocio.entidades;

import java.util.*;
import java.sql.*;

public class Detalle_Venta {

    private int codigoDVenta;
    private Producto producto;
    private Factura_Venta fVenta;
    private int cantidad;
    private double pTotal;

    public Detalle_Venta() {
    }

    public Detalle_Venta(int codigoDVenta, Producto producto, Factura_Venta fVenta, int cantidad, double pTotal) {
        this.codigoDVenta = codigoDVenta;
        this.producto = producto;
        this.fVenta = fVenta;
        this.cantidad = cantidad;
        this.pTotal = pTotal;
    }

    public int getCodigoDVenta() {
        return codigoDVenta;
    }

    public void setCodigoDVenta(int codigoDVenta) {
        this.codigoDVenta = codigoDVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura_Venta getfVenta() {
        return fVenta;
    }

    public void setfVenta(Factura_Venta fVenta) {
        this.fVenta = fVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getpTotal() {
        return pTotal;
    }

    public void setpTotal(double pTotal) {
        this.pTotal = pTotal;
    }

}
