package kardex.negocio.impl;

import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class Detalle_VentaImp implements Detalle_VentaI {

    @Override
    public int ingresar(Detalle_Venta detalleVenta) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "INSERT INTO DetalleVenta (codigoDetalleVenta, codigoProducto, codigoFacturaVenta, cantidad, preciototal) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, detalleVenta.getCodigoDVenta()));
        listParam.add(new Parametro(2, detalleVenta.getProducto().getCodigoProducto()));
        listParam.add(new Parametro(3, detalleVenta.getfVenta().getCodFVenta()));
        listParam.add(new Parametro(4, detalleVenta.getCantidad()));
        listParam.add(new Parametro(5, detalleVenta.getpTotal()));
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
    public int modificar(Detalle_Venta detalleVenta) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE DetalleVenta SET codigoDetalleVenta=?, codigoProducto=?, codigoFacturaVenta=?, cantidad=?, preciototal=? WHERE codDetalleVenta=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, detalleVenta.getCodigoDVenta()));
        listParam.add(new Parametro(2, detalleVenta.getProducto().getCodigoProducto()));
        listParam.add(new Parametro(3, detalleVenta.getfVenta().getCodFVenta()));
        listParam.add(new Parametro(4, detalleVenta.getCantidad()));
        listParam.add(new Parametro(5, detalleVenta.getpTotal()));
        listParam.add(new Parametro(6, detalleVenta.getCodigoDVenta()));
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
    public int eliminar(Detalle_Venta detalleVenta) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM DetalleVenta WHERE codigoDetalleVenta=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, detalleVenta.getCodigoDVenta()));
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
    public Detalle_Venta obtener(int codDetalleVenta) throws Exception {
        Detalle_Venta detalle = null;
        String sqlC = "SELECT codigoDetalleVenta, codigoProducto, codigoFacturaVenta, cantidad, preciototal FROM DetalleVenta Where codigoDetalleVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codDetalleVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ProductoI productoDao = new ProductoImp();
            Producto produc = null;
            Factura_VentaI factVentaDao = new Factura_VentaImp();
            Factura_Venta factVenta = new Factura_Venta();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                detalle = new Detalle_Venta();
                produc = new Producto();
                factVenta = new Factura_Venta();
                detalle.setCodigoDVenta(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                detalle.setProducto(produc);
                factVenta = factVentaDao.obtener(rst.getInt(3));
                detalle.setfVenta(factVenta);
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
        String sqlC = "SELECT codigoDetalleVenta, codigoProducto, codigoFacturaVenta, cantidad, preciototal FROM DetalleVenta";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ProductoI productoDao = new ProductoImp();
            Producto produc = null;
            Factura_VentaI factVenDao = new Factura_VentaImp();
            Factura_Venta factVenta = new Factura_Venta();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                detalle = new Detalle_Venta();
                produc = new Producto();
                factVenta = new Factura_Venta();
                detalle.setCodigoDVenta(rst.getInt(1));
                produc = productoDao.obtener(rst.getInt(2));
                detalle.setProducto(produc);
                factVenta = factVenDao.obtener(rst.getInt(3));
                detalle.setfVenta(factVenta);
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
