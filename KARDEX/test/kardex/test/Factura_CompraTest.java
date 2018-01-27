
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Factura_CompraTest {
    
    public Factura_CompraTest() {
    }
    @Test

    public void testGeneral() {

        Factura_CompraI FacComDao = new Factura_CompraImp();

        // TEST INSERETAR 
        int filas = 0;

        Proveedor pro = new Proveedor("", "", "", "", "");
        Factura_Compra fc = new Factura_Compra(1, new java.util.Date(), pro);

        try {
            filas = FacComDao.ingresar(fc);
            System.out.println("Filas insertadas: " + filas);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        assertEquals(filas > 0,true);
        
        /// listar por codigo test
        
        Factura_Compra fa = new Factura_Compra();
        
        try {
            fa = FacComDao.obtener(1);
            System.out.println(fa.getCodFCompra()+""+fa.getFecha()+""+fa.getProveedor().getRuc());
                    
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
        assertEquals(fa != null, true );
        //////test listado
        
        ArrayList<Factura_Compra> fac = new ArrayList<>();
        try {
            fac = FacComDao.obtener();
            for (Factura_Compra far : fac ){
                 System.out.println(fa.getCodFCompra()+""+fa.getFecha()+""+fa.getProveedor().getRuc());
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            
        }
        
        

    }
}
