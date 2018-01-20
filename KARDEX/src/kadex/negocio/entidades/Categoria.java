/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadex.negocio.entidades;


import java.util.*;
public class Categoria {
    
    private int codigoCategoria;
    private String nombre;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int codigoCategoria, String nombre, String descripcion) {
        this.codigoCategoria = codigoCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
