package kardex.negocio.dao;

import kardex.negocio.entidades.Factura_Venta;
import java.util.*;

public interface Factura_VentaI {

    public int ingresar(Factura_Venta facturaVenta) throws Exception;

    public int modificar(Factura_Venta facturaVenta) throws Exception;

    public int eliminar(Factura_Venta facturaVenta) throws Exception;

    public Factura_Venta obtener(int codigoVenta) throws Exception;

    public ArrayList<Factura_Venta> obtener() throws Exception;

}
