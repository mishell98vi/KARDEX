package kardex.test;

import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Detalle_VentaTest {

    public Detalle_VentaTest() {
    }

    @Test
    public void testGeneral() {
        Detalle_VentaI deveDao = new Detalle_VentaImp();
        /////////INSERTAR TEST
//        int filas = 0;
//
//        Categoria ca = new Categoria(1, "ABC", "Cuadernoss");
//        Producto producto = new Producto(2, ca, "Universitario", 1.25);
//        Cliente cli = new Cliente("1234567890", "David", "Campps", "La condamine", "0991575474", "jc@gmail.com", new java.util.Date());
//        Factura_Venta facturaventa = new Factura_Venta(1, new java.util.Date(), cli);
//        Detalle_Venta detalleventa = new Detalle_Venta(1, producto, facturaventa, 1, 2);
//
//        try {                                                                  
//            filas = deveDao.ingresar(detalleventa);
//            System.out.println("Filas insertadas: " + filas);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(filas > 0);

        //////////////////////////////// obtener por codigo 
//        Detalle_Venta dt = new Detalle_Venta();
//
//        try {
//            dt = deveDao.obtener(1);
//            System.out.println(dt.getCodigoDVenta()+ " " + dt.getProducto().getCodigoProducto()+ " " + dt.getfVenta().getCodFVenta()+ " " + dt.getCantidad() + " " + dt.getpTotal());
//        } catch (Exception e) {
//            System.out.println("error: " + e.getMessage());
//        }
//        assertEquals(dt != null, true);
//OBTENER LISTA
        ArrayList<Detalle_Venta> dec = new ArrayList<>();
        try {
            dec = deveDao.obtener();
            for (Detalle_Venta det : dec) {
                System.out.println(det.getCodigoDVenta() + " " + det.getProducto().getCodigoProducto() + " " + det.getfVenta().getCodFVenta() + " " + det.getCantidad() + " " + det.getpTotal());
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        assertTrue(dec.size() > 0);
    }

}
