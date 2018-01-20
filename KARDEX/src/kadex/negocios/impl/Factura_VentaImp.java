/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadex.negocios.impl;

import kardex.negocio.dao.*;
import kadex.negocio.entidades.*;
import kadex.negocios.impl.*;
import kardex.accesoadatos.*;

import java.sql.*;
import java.util.*;

public class Factura_VentaImp implements Factura_VentaI {
   
    @Override
    public int modificar(Factura_Venta facturaventa) throws Exception {
        int numFilas = 0;
        String sqlC = "update FacturaVenta set codFacturaVenta=?, fecha=?, cliente where codFacturaVenta =?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturaventa.getCodFVenta()));
        if (facturaventa.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaventa.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturaventa.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturaventa.getCliente()));

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
    public int eliminar(Factura_Venta facturaVenta) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM FacturaVenta VALUES WHERE codFacturaVenta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturaVenta.getCodFVenta()));
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
    public Factura_Venta obtener(int codFVenta) throws Exception {
        Factura_Venta fv = null;
        String sqlC = "SELECT codFacturaVenta, fecha, cliente from FacturaVenta ";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codFVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ClienteI clienteDao = new ClienteImp();
            Cliente cl = null;
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                fv = new Factura_Venta();
                cl = new Cliente();
                fv.setCodFVenta(rst.getInt(1));
                fv.setFecha(rst.getDate(2));
                cl = clienteDao.obtener(rst.getString(3));
                fv.setCliente(cl);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return fv;

    }

    @Override

    public ArrayList<Factura_Venta> obtener() throws Exception {
        Factura_Venta fventa = null;
        String sqlC = "select codFacturaVenta, fecha, cliente from FacturaVenta";
        ArrayList<Factura_Venta> lstfv = new ArrayList<>();
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while(rst.next()){
                ClienteI clienteDao = new ClienteImp();
                Cliente cliente = null;
                fventa = new Factura_Venta();
                fventa.setCodFVenta(rst.getInt(1));
                fventa.setFecha(rst.getDate(2));
                cliente = clienteDao.obtener(rst.getString(3));
                fventa.setCliente(cliente);
                lstfv.add(fventa);
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally {
            
            if (con != null) {
                con.desconectar();
            }
        }
        return  lstfv;
    }

    @Override
    public int ingresar(Factura_Venta facturaVenta) throws Exception {
       int numFilas = 0;
        String sqlC = "INSERT INTO FacturaVenta (codFacturaVentas, fecha, cliente) VALUES (?,?,?) ";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, facturaVenta.getCodFVenta()));
        if (facturaVenta.getFecha() instanceof java.util.Date) {
            lisParametros.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaVenta.getFecha()).getTime())));
        } else {
            lisParametros.add(new Parametro(2, facturaVenta.getFecha()));
        }
        lisParametros.add(new Parametro(3, facturaVenta.getCliente()));

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

}
