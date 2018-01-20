/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;

import kadex.negocio.entidades.*;
import java.util.*;

public interface ProveedorI {
    
    public int ingresar(Proveedor proveedor) throws Exception;
    public int modificar(Proveedor proveedor) throws Exception;
    public int eliminar(Proveedor proveedor) throws Exception;
    public Proveedor obtener(String ruc) throws Exception;
    public ArrayList<Proveedor> obtener() throws Exception;
}
