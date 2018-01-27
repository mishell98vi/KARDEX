package kardex.negocio.impl;

import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class Factura_CompraImp implements Factura_CompraI {
    @Override
    public int modificar(Factura_Compra facturacompra) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE FacturaCompra SET codFacturaCompra=?, fecha=?, codProveedor=? WHERE codFacturaCompra=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturacompra.getCodFCompra()));
        if (facturacompra.getFecha() instanceof java.util.Date) {
            listParam.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturacompra.getFecha()).getTime())));
        } else {
            listParam.add(new Parametro(2, facturacompra.getFecha()));
        }
        listParam.add(new Parametro(3, facturacompra.getProveedor()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutarComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;
    }
    @Override
    public int eliminar(Factura_Compra facturacompra) throws Exception {
        int filas = 0;
        String sqlC = "DELETE FROM FacturaCompra  WHERE codFacturaCompra=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturacompra.getCodFCompra()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filas = conect.ejecutarComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filas;
    }
    @Override
    public Factura_Compra obtener(int facturacompra) throws Exception {
        Factura_Compra nFC = null;
        String sqlC = "SELECT codFacturaCompra, fecha, codProveedor FROM FacturaCompra WHERE codFacturaCompra=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturacompra));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            Proveedor nProveedor = null;
            ProveedorI obFC = new ProveedorImp();
            while (rst.next()) {
                nProveedor = new Proveedor();
                nFC = new Factura_Compra();
                nFC.setCodFCompra(rst.getInt(1));
                nFC.setFecha(rst.getDate(2));
                nProveedor = obFC.obtener(rst.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return nFC;
    }
    @Override
    public ArrayList<Factura_Compra> obtener() throws Exception {
        ArrayList<Factura_Compra> listFacturaCompra = new ArrayList<>();
        String sqlC = "SELECT codFacturaCompra, fecha, codProveedor FROM FacturaCompra";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            Proveedor nProveedor = null;
            ProveedorI obFC = new ProveedorImp();
            while (rst.next()) {
                Factura_Compra nFCompra = new Factura_Compra();
                nProveedor = new Proveedor();
                nFCompra.setCodFCompra(rst.getInt(1));
                nFCompra.setFecha(rst.getDate(2));
                nProveedor = obFC.obtener(rst.getString(3));
                nFCompra.setProveedor(nProveedor);
                listFacturaCompra.add(nFCompra);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return listFacturaCompra;
    }
    @Override
    public int ingresar(Factura_Compra facturaCompra) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "INSERT INTO FacturaCompra (codFacturaCompra,fecha, codProveedor) VALUES (?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturaCompra.getCodFCompra()));
        if (facturaCompra.getFecha() instanceof java.util.Date) {
            listParam.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaCompra.getFecha()).getTime())));
        } else {
            listParam.add(new Parametro(2, facturaCompra.getFecha()));
        }
        listParam.add(new Parametro(3, facturaCompra.getProveedor()));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            filasAfectadas = conect.ejecutarComando(sqlC, listParam);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return filasAfectadas;
    }
}
