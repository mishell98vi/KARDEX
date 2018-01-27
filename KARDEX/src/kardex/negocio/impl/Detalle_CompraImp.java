package kardex.negocio.impl;

import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class Detalle_CompraImp implements Detalle_CompraI {
    @Override
    public int ingresar(Detalle_Compra detalleCompra) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "INSERT INTO DetalleCompra (codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, detalleCompra.getCodigoDcompra()));
        listParam.add(new Parametro(2, detalleCompra.getProducto().getCodigoProducto()));
        listParam.add(new Parametro(3, detalleCompra.getfCompra().getCodFCompra()));
        listParam.add(new Parametro(4, detalleCompra.getCantidad()));
        listParam.add(new Parametro(5, detalleCompra.getpTotal()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutarComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;
    }
    @Override
    public int modificar(Detalle_Compra detalleCompra) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE DetalleCompra SET codDetalleCompra=?, codProducto=?, codFacturaCompra=?, cantidad=?, precioTotal=? WHERE codDetalleCompra=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, detalleCompra.getCodigoDcompra()));
        listParam.add(new Parametro(2, detalleCompra.getProducto().getCodigoProducto()));
        listParam.add(new Parametro(3, detalleCompra.getfCompra().getCodFCompra()));
        listParam.add(new Parametro(4, detalleCompra.getCantidad()));
        listParam.add(new Parametro(5, detalleCompra.getCantidad()));
        listParam.add(new Parametro(6, detalleCompra.getCodigoDcompra()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutarComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;
    }
    @Override
    public int eliminar(Detalle_Compra detalleCompra) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codDetalleCompra=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, detalleCompra.getCodigoDcompra()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutarComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;
    }
    @Override
    public Detalle_Compra obtener(int codigoDCompra) throws Exception {
        Detalle_Compra detalle = null;
        String sqlC = "SELECT codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal FROM DetalleCompra Where id=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, codigoDCompra));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ProductoI productoDao = new ProductoImp();
            Producto produc = null;
            Factura_CompraI factCompraDao = new Factura_CompraImp();
            Factura_Compra factCompra = new Factura_Compra();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            while (rst.next()) {
                detalle = new Detalle_Compra();
                produc = new Producto();
                factCompra = new Factura_Compra();
                detalle.setCodigoDcompra(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                detalle.setProducto(produc);
                factCompra = factCompraDao.obtener(rst.getInt(3));
                detalle.setCantidad(rst.getInt(4));
                detalle.setpTotal(rst.getDouble(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return detalle;
    }
    @Override
    public ArrayList<Detalle_Compra> obtener() throws Exception {
        ArrayList<Detalle_Compra> lstDetalle = new ArrayList<>();
        Detalle_Compra detalle = null;
        String sqlC = "SELECT codDetalleCompra, codProducto, codFacturaCompra, cantidad, precioTotal FROM DetalleCompra";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ProductoI productoDao = new ProductoImp();
            Producto produc = null;
            Factura_CompraI factCompraDao = new Factura_CompraImp();
            Factura_Compra factCompra = new Factura_Compra();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                detalle = new Detalle_Compra();
                produc = new Producto();
                factCompra = new Factura_Compra();
                detalle.setCodigoDcompra(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                detalle.setProducto(produc);
                factCompra = factCompraDao.obtener(rst.getInt(3));
                detalle.setCantidad(rst.getInt(4));
                detalle.setpTotal(rst.getDouble(5));
                lstDetalle.add(detalle);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return lstDetalle;
    }
}
