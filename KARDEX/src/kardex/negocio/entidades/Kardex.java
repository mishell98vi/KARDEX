
package kardex.negocio.entidades;
import java.util.*;
public class Kardex {
    private int codigoKardex;
    private Producto producto;
    private Date fecha_Emision;
    private String tipo_Transaccion;
    private int existencias;
    private int cantidad_Editable;
    private double valor_Total;

    public Kardex() {
    }

    public Kardex(int codigoKardex, Producto producto, Date fecha_Emision, String tipo_Transaccion, int existencias, int cantidad_Editable, double valor_Total) {
        this.codigoKardex = codigoKardex;
        this.producto = producto;
        this.fecha_Emision = fecha_Emision;
        this.tipo_Transaccion = tipo_Transaccion;
        this.existencias = existencias;
        this.cantidad_Editable = cantidad_Editable;
        this.valor_Total = valor_Total;
    }

    

    public int getCodKardex() {
        return codigoKardex;
    }

    public void setCodKardex(int codigoKardex) {
        this.codigoKardex = codigoKardex;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaEmision() {
        return fecha_Emision;
    }

    public void setFechaEmision(Date fecha_Emision) {
        this.fecha_Emision = fecha_Emision;
    }

    public String getTipoTransaccion() {
        return tipo_Transaccion;
    }

    public void setTipoTransaccion(String tipo_Transaccion) {
        this.tipo_Transaccion = tipo_Transaccion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getValorTotal() {
        return valor_Total;
    }

    public void setValorTotal(double valor_Total) {
        this.valor_Total = valor_Total;
    }

    public int getCantEditable() {
        return cantidad_Editable;
    }

    public void setCantEditable(int cantidad_Editable) {
        this.cantidad_Editable = cantidad_Editable;
    }
    
    
    
}
