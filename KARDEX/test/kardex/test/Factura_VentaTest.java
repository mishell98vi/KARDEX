
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Factura_VentaTest {
    
    public Factura_VentaTest() {
    }
     @Test
    public void testGeneral() {
        Factura_VentaI efacturaventaDao = new Factura_VentaImp();
        
//TEST INSERTAR

        int filas = 0;
        Cliente cliente=new Cliente("1600712770", "Mishell", "Viteri", "M", "099513620","mishell98@gmail.com", new java.util.Date());
        Factura_Venta nFacVen=new Factura_Venta(2,new java.util.Date(), cliente);
        try {
            filas = efacturaventaDao.ingresar(nFacVen);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertTrue(filas > 0);
        
       
//TEST OBTENER POR CODIGO

        Factura_Venta facvent = new Factura_Venta();
        try {
            facvent = efacturaventaDao.obtener(1);
            System.out.println(facvent.getCodFVenta()+"     "+facvent.getFecha()+ "    " + facvent.getCliente().getCedula()+"\n\n");
        } catch (Exception e) {
        }
      //assertEquals(facvent != null, true);
        
////TEST LISTADO
        
        ArrayList<Factura_Venta> facven = new ArrayList<>();
        try {
            facven = efacturaventaDao.obtener();
            for (Factura_Venta facVent : facven) {
                System.out.println(facVent.getCodFVenta()+"\t\t\t"+facVent.getFecha()+"\t\t\t"+facVent.getCliente().getCedula());
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        assertTrue(facven.size() > 0);
    }
    
    
}
