
package kardex.negocio.dao;
import java.util.ArrayList;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.text.*;
public interface kardexMensualI {
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    public ArrayList<Kardex> listadoKardexFecha(int codProducto,String mes,String anio) throws Exception;
}
