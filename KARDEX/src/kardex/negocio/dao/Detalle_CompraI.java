/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;

import kadex.negocio.entidades.*;
import java.util.*;
public interface Detalle_CompraI {
    public int ingresar(Detalle_Compra detalleCompra) throws Exception;
    public int modificar(Detalle_Compra detalleCompra) throws Exception;
    public int eliminar(Detalle_Compra detalleCompra) throws Exception;
    public Detalle_Compra obtener(int codigoDCompra) throws Exception;
    public ArrayList<Detalle_Compra> obtener() throws Exception;
}
