/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadex.negocios.impl;

import kardex.accesoadatos.*;
import kardex.negocio.dao.*;
import kadex.negocio.entidades.*;
import kadex.negocios.impl.*;
import java.sql.*;
import java.util.*;

public class Detalle_CompraImp implements Detalle_CompraI{

    @Override
    public int ingresar(Detalle_Compra detalleCompra) throws Exception {
        
        int numFilas = 0;
        String sqlC = "INSERT INTO DetalleCompra (codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleCompra.getCodigoDcompra()));
        lisParametros.add(new Parametro(2, detalleCompra.getProducto().getCodigoProducto()));
        lisParametros.add(new Parametro(3, detalleCompra.getfCompra().getCodFCompra()));
        lisParametros.add(new Parametro(4, detalleCompra.getCantidad()));
        lisParametros.add(new Parametro(5, detalleCompra.getpTotal()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;

    }

    @Override
    public int modificar(Detalle_Compra detalleCompra) throws Exception {
        
        int numFilas = 0;
        String sqlC = "UPDATE DetalleCompra SET codDetalleCompra=?, codProducto=?, codFacturaCompra=?, cantidad=?, precioTotal=? WHERE codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleCompra.getCodigoDcompra()));
        lisParametros.add(new Parametro(2, detalleCompra.getProducto().getCodigoProducto()));
        lisParametros.add(new Parametro(3, detalleCompra.getfCompra().getCodFCompra()));
        lisParametros.add(new Parametro(4, detalleCompra.getCantidad()));
        lisParametros.add(new Parametro(5, detalleCompra.getCantidad()));
        lisParametros.add(new Parametro(6, detalleCompra.getCodigoDcompra()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
  
        
    }

    @Override
    public int eliminar(Detalle_Compra detalleCompra) throws Exception {
      
      int numFilas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleCompra.getCodigoDcompra()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;  
    }

    @Override
    public Detalle_Compra obtener(int codigoDCompra) throws Exception {
       
 
        Detalle_Compra detalle = null;
        String sqlC = "SELECT codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal FROM DetalleCompra Where id=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codigoDCompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
//            IProducto productoDao = new ImplProducto();
            Producto produc = null;
            Factura_CompraI factCompraDao = new Factura_CompraImp();
            Factura_Compra factCompra = new Factura_Compra();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                detalle = new Detalle_Compra();
                produc = new Producto();
                factCompra = new Factura_Compra();
                detalle.setCodigoDcompra(rst.getInt(1));
//                produc = productoDao.obtener(rst.getInt(2));
                detalle.getProducto();
                factCompra = factCompraDao.obtener(rst.getInt(3));
                detalle.setCantidad(rst.getInt(4));
                detalle.setpTotal(rst.getDouble(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return detalle;
        
    } 

    @Override
    public ArrayList<Detalle_Compra> obtener() throws Exception {
    ArrayList<Detalle_Compra> lstDetalle=new ArrayList<>();
        Detalle_Compra detalle = null;
        String sqlC = "SELECT codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal FROM DetalleCompra";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
//            IProducto productoDao = new ImplProducto();
            Producto produc = null;
            Factura_CompraI factCompraDao = new Factura_CompraImp();
            Factura_Compra factCompra = new Factura_Compra();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                detalle = new Detalle_Compra();
                produc = new Producto();
                factCompra = new Factura_Compra();
                detalle.setCodigoDcompra(rst.getInt(1));
//                produc = productoDao.obtener(rst.getInt(2));
                detalle.getProducto();
                factCompra = factCompraDao.obtener(rst.getInt(3));
                detalle.setCantidad(rst.getInt(4));
                detalle.setpTotal(rst.getDouble(5));
                lstDetalle.add(detalle);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lstDetalle;
    }
    
}
