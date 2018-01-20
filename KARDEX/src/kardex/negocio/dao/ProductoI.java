/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;

import kadex.negocio.entidades.*;
import java.util.*;

public interface ProductoI {
    
    public int ingresar(Producto producto) throws Exception;
    public int modificar(Producto producto) throws Exception;
    public int eliminar(Producto producto) throws Exception;
    public Producto obtener(int codigoProducto) throws Exception;
    public ArrayList<Producto> obtener() throws Exception;
         
}
