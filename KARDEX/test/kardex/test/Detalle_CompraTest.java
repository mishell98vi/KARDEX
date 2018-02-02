
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Detalle_CompraTest {
    
    @Test
    public void testGeneral() {
        Detalle_CompraI decoDao = new Detalle_CompraImp();
        
//        ///////INSERTAR TEST
        int filas = 0;

        Categoria ca = new Categoria(1,"ABC","Papel Ministro");
        Producto producto = new Producto(2, ca, "A4", 4.00);
        Proveedor pro = new Proveedor("0623547932", "Carlos", "Maldonado Norte", "09929291063",  "jc@gmail.com");
        Factura_Compra facturacompra = new Factura_Compra(1, new java.util.Date(), pro);
        Detalle_Compra detallecompra = new Detalle_Compra (1, producto, facturacompra, 20 , 60);

        try {                                                                  
            filas = decoDao.ingresar(detallecompra);
            System.out.println("Filas insertadas: " + filas);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);

        //////////////////////////////// obtener por codigo 
        Detalle_Compra dc = new Detalle_Compra();

        try {
            dc = decoDao.obtener(1);
            System.out.println(dc.getCodigoDcompra() + " " + dc.getProducto().getCodigoProducto() + " " + dc.getfCompra().getfCompra() + " " + dc.getCantidad() + " " + dc.getpTotal());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        assertEquals(dc != null, true);

        ArrayList<Detalle_Compra> dec = new ArrayList<>();
        try {
            dec = decoDao.obtener();
            for (Detalle_Compra det : dec) {
                System.out.println(det.getCodigoDcompra() + " " + det.getProducto().getCodigoProducto() + " " + det.getfCompra().getfCompra() + " " + det.getCantidad() + " " + det.getpTotal());
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
         assertTrue(dec.size()>0);
    }

    
    
}
