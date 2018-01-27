package kardex.negocio.entidades;

import java.util.*;

public class Factura_Compra {

    private int codFCompra;
    private Date Fecha;
    private Proveedor proveedor;

    public Factura_Compra() {
    }

    public Factura_Compra(int codigoFCompra, Date Fecha, Proveedor proveedor) {
        this.codFCompra = codigoFCompra;
        this.Fecha = Fecha;
        this.proveedor = proveedor;
    }

    public int getCodFCompra() {
        return codFCompra;
    }

    public void setCodFCompra(int codigoFCompra) {
        this.codFCompra = codigoFCompra;
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
