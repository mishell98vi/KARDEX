/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;

import kadex.negocio.entidades.*;
import java.util.*;

public interface Factura_CompraI {
    
    public int ingresar(Factura_Compra facturaCompra) throws Exception;
    public int modificar(Factura_Compra facturaCompra) throws Exception;
    public int eliminar(Factura_Compra facturaCompra) throws Exception;
    public Factura_Compra obtener(int codigoCompra) throws Exception;
    public ArrayList<Factura_Compra> obtener() throws Exception;
    
}
