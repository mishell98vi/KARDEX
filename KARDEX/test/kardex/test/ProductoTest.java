
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTest {
    
    public ProductoTest() {
    }
         @Test
    public void testGeneral() {
        ProductoI productoDao = new ProductoImp();
        
//TEST INSERTAR

        int filas = 0;
        Categoria ncategoria = new Categoria(1, "ABC", "Cuadernoss");
        Producto produc = new Producto(2,ncategoria,  "Academico", 1.75);
        try {
            filas = productoDao.ingresar(produc);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertTrue(filas > 0);
        
////TEST OBTENER POR CODIGO

        Producto producto = new Producto();
        try {
            producto = productoDao.obtener(1);
            System.out.println(producto.getCodigoProducto() + "\t\t" + producto.getCategoria().getCodigoCategoria() + "\t\t" + producto.getNombre() + "\t\t" + producto.getPrecio() + "\t\t" + "\n\n");
        } catch (Exception e) {
        }
        assertEquals(producto != null, true);
        
//TEST LISTADO

        ArrayList<Producto> productos = new ArrayList<>();
        try {
            productos = productoDao.obtener();
            for (Producto nProductos : productos) {
                System.out.println(nProductos.getCodigoProducto()+"\t\t\t"+ nProductos.getCategoria().getCodigoCategoria()+"\t\t\t"+nProductos.getNombre()+"\t\t\t"+nProductos.getPrecio());
            }
        } catch (Exception e) {
        }
        assertTrue(productos.size() > 0);
    }

}
