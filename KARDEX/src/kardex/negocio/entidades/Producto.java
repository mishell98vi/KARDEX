package kardex.negocio.entidades;

import java.util.*;
import java.sql.*;

public class Producto {

    private int codigoProducto;
    private Categoria categoria;
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(int codigoProducto, Categoria categoria, String nombre, double precio) {
        this.codigoProducto = codigoProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
