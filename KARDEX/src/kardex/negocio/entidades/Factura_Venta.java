package kardex.negocio.entidades;

import java.util.*;

public class Factura_Venta {

    private int codigoFVenta;
    private Date fecha;
    private Cliente cliente;

    public Factura_Venta() {
    }

    public Factura_Venta(int codigoFVenta, Date fecha, Cliente cliente) {
        this.codigoFVenta = codigoFVenta;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getCodFVenta() {
        return codigoFVenta;
    }

    public void setCodFVenta(int codigoFVenta) {
        this.codigoFVenta = codigoFVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
