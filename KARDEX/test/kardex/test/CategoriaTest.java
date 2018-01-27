
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoriaTest {
    
    public CategoriaTest() {
    }
     @Test
    public void testGeneral() {
        CategoriaI categoriaDao = new CategoriaImp();
        // TEST INSERTAR

        int filas = 0;
        Categoria categoria = new Categoria(1, "p", "pequeño");
        try {
            filas = categoriaDao.insertar(categoria);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);

        //TEST OBTENER POR CODIGO
        
        Categoria categori = new Categoria();
        try {
            categori = categoriaDao.obtener(1);
            System.out.println(categori.getCodigoCategoria() + "    " + categori.getNombre() + "    " + categori.getDescripcion());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(categori!=null, true);
        
        //TEST LISTADO
        
        ArrayList<Categoria> categ = new ArrayList<>();
        try {
            categ = categoriaDao.obtener();
            System.out.println("Codigo de Categoria \t" + "Nombre \t" + " \t Descripcion\t");
            for (Categoria cate : categ) {
                System.out.println(cate.getCodigoCategoria()+ "\t\t" + cate.getNombre() + "\t\t" + cate.getDescripcion() + "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(categ.size() > 0);
    }
    
}
