package kardex.negocio.dao;

import kardex.negocio.entidades.Proveedor;
import java.util.*;

public interface ProveedorI {

    public int ingresar(Proveedor proveedor) throws Exception;

    public int modificar(Proveedor proveedor) throws Exception;

    public int eliminar(Proveedor proveedor) throws Exception;

    public Proveedor obtener(String ruc) throws Exception;

    public ArrayList<Proveedor> obtener() throws Exception;
}
