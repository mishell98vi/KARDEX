package kardex.negocio.dao;

import kardex.negocio.entidades.Producto;
import java.util.*;

public interface ProductoI {

    public int ingresar(Producto producto) throws Exception;

    public int modificar(Producto producto) throws Exception;

    public int eliminar(Producto producto) throws Exception;

    public Producto obtener(int codigoProducto) throws Exception;

    public ArrayList<Producto> obtener() throws Exception;

}
