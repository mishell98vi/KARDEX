/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;

import kadex.negocio.entidades.*;
import java.util.*;

public interface Factura_VentaI {
    
    public int ingresar(Factura_Venta facturaVenta) throws Exception;
    public int modificar(Factura_Venta facturaVenta) throws Exception;
    public int eliminar(Factura_Venta facturaVenta) throws Exception;
    public Factura_Venta obtener(int codigoVenta) throws Exception;
    public ArrayList<Factura_Venta> obtener() throws Exception;
    
}
