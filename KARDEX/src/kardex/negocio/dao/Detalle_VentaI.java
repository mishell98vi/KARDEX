/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;

import kadex.negocio.entidades.*;
import java.util.*;

public interface Detalle_VentaI {
    
    public int ingresar(Detalle_Venta detalleVenta) throws Exception;
    public int modificar(Detalle_Venta detalleVenta) throws Exception;
    public int eliminar(Detalle_Venta detalleVenta) throws Exception;
    public Detalle_Venta obtener(int codigoDetalle) throws Exception;
    public ArrayList<Detalle_Venta> obtener() throws Exception;
    
}
