package kardex.negocio.dao;

import kardex.negocio.entidades.Detalle_Venta;
import java.util.*;

public interface Detalle_VentaI {

    public int ingresar(Detalle_Venta detalleVenta) throws Exception;

    public int modificar(Detalle_Venta detalleVenta) throws Exception;

    public int eliminar(Detalle_Venta detalleVenta) throws Exception;

    public Detalle_Venta obtener(int codigoDetalle) throws Exception;

    public ArrayList<Detalle_Venta> obtener() throws Exception;

}
