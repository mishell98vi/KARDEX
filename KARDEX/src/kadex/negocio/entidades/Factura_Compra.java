/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadex.negocio.entidades;

import java.util.*;
public class Factura_Compra {
 
    private int codigoFCompra;
    private Date Fecha;
    private Proveedor proveedor;

    public Factura_Compra() {
    }

    public Factura_Compra(int codigoFCompra, Date Fecha, Proveedor proveedor) {
        this.codigoFCompra = codigoFCompra;
        this.Fecha = Fecha;
        this.proveedor = proveedor;
    }

    public int getCodigoFCompra() {
        return codigoFCompra;
    }

    public void setCodigoFCompra(int codigoFCompra) {
        this.codigoFCompra = codigoFCompra;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
}
