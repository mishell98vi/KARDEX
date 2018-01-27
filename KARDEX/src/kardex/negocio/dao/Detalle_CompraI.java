package kardex.negocio.dao;

import kardex.negocio.entidades.Detalle_Compra;
import java.util.*;

public interface Detalle_CompraI {

    public int ingresar(Detalle_Compra detalleCompra) throws Exception;

    public int modificar(Detalle_Compra detalleCompra) throws Exception;

    public int eliminar(Detalle_Compra detalleCompra) throws Exception;

    public Detalle_Compra obtener(int codigoDCompra) throws Exception;

    public ArrayList<Detalle_Compra> obtener() throws Exception;

}
