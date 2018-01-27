package kardex.negocio.entidades;

import java.util.*;
import java.sql.*;

public class Detalle_Compra {

    private int codigoDcompra;
    private Producto producto;
    private Factura_Compra fCompra;
    private int cantidad;
    private double pTotal;

    public Detalle_Compra() {
    }

    public Detalle_Compra(int codigoDcompra, Producto producto, Factura_Compra fCompra, int cantidad, double pTotal) {
        this.codigoDcompra = codigoDcompra;
        this.producto = producto;
        this.fCompra = fCompra;
        this.cantidad = cantidad;
        this.pTotal = pTotal;
    }

    public int getCodigoDcompra() {
        return codigoDcompra;
    }

    public void setCodigoDcompra(int codigoDcompra) {
        this.codigoDcompra = codigoDcompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura_Compra getfCompra() {
        return fCompra;
    }

    public void setfCompra(Factura_Compra fCompra) {
        this.fCompra = fCompra;
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
