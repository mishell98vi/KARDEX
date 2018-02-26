
package kardex.negocio.dao;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import kardex.accesoadatos.*;
import java.util.*;

public interface KardexI {
    public int insertar(Kardex kardex) throws Exception;

    public int modificar(Kardex kardex) throws Exception;

    public int eliminar(Kardex kardex) throws Exception;

    public Kardex obtener(int codKardex, int codProducto) throws Exception;

    public ArrayList<Kardex> obtener() throws Exception;
    
    public ArrayList<Kardex> obtenerkardexProducto(int producto) throws Exception;
}
