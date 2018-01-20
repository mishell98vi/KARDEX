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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Factura_CompraImp implements Factura_CompraI {
    
    @Override
    public int modificar(Factura_Compra facturacompra) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE FacturaCompra SET codFacturaCompra=?, fecha=?, codProveedor=? WHERE codFacturaCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturacompra.getCodFCompra()));
        
        if (facturacompra.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturacompra.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturacompra.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturacompra.getProveedor()));
        
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int eliminar(Factura_Compra facturacompra) throws Exception {
        int filas = 0;
        String sqlC = "DELETE FROM FacturaCompra  WHERE codFacturaCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturacompra.getCodFCompra()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            filas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return filas;
    }

    @Override
    
       public Factura_Compra obtener(int facturacompra) throws Exception {
        Factura_Compra nFC = null;
        String sqlC = "SELECT codFacturaCompra, fecha, codProveedor FROM FacturaCompra WHERE codFacturaCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturacompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
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
            if (con != null) {
                con.desconectar();
            }
        }
        return nFC;
    }

    @Override
    public ArrayList<Factura_Compra> obtener() throws Exception {
        ArrayList<Factura_Compra> listFacturaCompra = new ArrayList<>();
        String sqlC = "SELECT codFacturaCompra, fecha, codProveedor FROM FacturaCompra";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           Proveedor nProveedor = null;
           ProveedorI obFC = new ProveedorImp();
            while (rst.next()) {
                Factura_Compra nFCompra = new Factura_Compra();
                nProveedor = new Proveedor();
                nFCompra.setCodFCompra(rst.getInt(1));
                nFCompra.setFecha(rst.getDate(2));
                nProveedor = obFC.obtener(rst.getString(3));
             //   nFC.setProveedor(nProveedor);
                listFacturaCompra.add(nFCompra);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listFacturaCompra;
    }

    @Override
    public int ingresar(Factura_Compra facturaCompra) throws Exception {
    int numFilas = 0;
        String sqlC = "INSERT INTO FacturaCompra (codFacturaCompra,fecha, codProveedor) VALUES (?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
       
        lisParametros.add(new Parametro(1, facturaCompra.getCodFCompra()));
        
        if (facturaCompra.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaCompra.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturaCompra.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturaCompra.getProveedor()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;    
    }
}
