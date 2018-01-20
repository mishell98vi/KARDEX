/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadex.negocios.impl;

import kardex.accesoadatos.*;
import kardex.negocio.dao.*;
import kadex.negocio.entidades.*;
import java.util.*;
import java.sql.*;
public class Detalle_VentaImp implements Detalle_VentaI {
    
    @Override
    public int ingresar(Detalle_Venta detalleVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO DetalleVenta (codDetalleVenta, codProducto, codFacturaVenta, cantidad, precioTotal) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleVenta.getCodigoDVenta()));
        lisParametros.add(new Parametro(2, detalleVenta.getProducto().getCodigoProducto()));
        lisParametros.add(new Parametro(3, detalleVenta.getfVenta().getCodFVenta()));
        lisParametros.add(new Parametro(4, detalleVenta.getCantidad()));
        lisParametros.add(new Parametro(5, detalleVenta.getpTotal()));
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
    public int modificar(Detalle_Venta detalleVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE DetalleVenta SET codDetalleVenta=?, codProducto=?, codFacturaVenta=?, cantidad=?, precioTotal=? WHERE codDetalleVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleVenta.getCodigoDVenta()));
        lisParametros.add(new Parametro(2, detalleVenta.getProducto().getCodigoProducto()));
        lisParametros.add(new Parametro(3, detalleVenta.getfVenta().getCodFVenta()));
        lisParametros.add(new Parametro(4, detalleVenta.getCantidad()));
        lisParametros.add(new Parametro(5, detalleVenta.getpTotal()));
        lisParametros.add(new Parametro(6, detalleVenta.getCodigoDVenta()));
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
    public int eliminar(Detalle_Venta detalleVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM DetalleVenta WHERE codDetalleVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, detalleVenta.getCodigoDVenta()));
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
    public Detalle_Venta obtener(int codDetalleVenta) throws Exception {
        Detalle_Venta detalle = null;
        String sqlC = "SELECT codDetalleVenta, codProducto, codFacturaVenta, cantidad, precioTotal FROM DetalleVenta Where id=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codDetalleVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
//            IProducto productoDao = new ImplProducto();
            Producto produc = null;
            Factura_VentaI factVentaDao = new Factura_VentaImp();
            Factura_Venta factVenta = new Factura_Venta();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                detalle = new Detalle_Venta();
                produc = new Producto();
                factVenta = new Factura_Venta();
                detalle.setCodigoDVenta(rst.getInt(1));
//                produc = productoDao.obtener(rst.getInt(2));
                detalle.getProducto();
                factVenta = factVentaDao.obtener(rst.getInt(3));
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
    public ArrayList<Detalle_Venta> obtener() throws Exception {
        ArrayList<Detalle_Venta> lstDetalle=new ArrayList<>();
        Detalle_Venta detalle = null;
        String sqlC = "SELECT codDetalleVenta, codProducto, codFacturaVenta, cantidad, precioTotal FROM DetalleVenta";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
//            IProducto productoDao = new ImplProducto();
            Producto produc = null;
            Factura_VentaI factVentaDao = new Factura_VentaImp();
            Factura_Venta factVenta = new Factura_Venta();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                detalle = new Detalle_Venta();
                produc = new Producto();
                factVenta = new Factura_Venta();
                detalle.setCodigoDVenta(rst.getInt(1));
//                produc = productoDao.obtener(rst.getInt(2));
                detalle.getProducto();
                factVenta = factVentaDao.obtener(rst.getInt(3));
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
