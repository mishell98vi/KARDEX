
package kardex.negocio.dao;
import java.sql.*;
import kardex.negocio.impl.*;
import kardex.negocio.entidades.*;
import java.util.*;
public interface KardexProductoI {
    public ArrayList<Kardex> listadoKardexProducto(int codProducto) throws Exception;
}
