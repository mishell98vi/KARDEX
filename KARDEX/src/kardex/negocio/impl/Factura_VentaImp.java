
package kardex.negocio.impl;
import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class Factura_VentaImp implements Factura_VentaI {
    @Override
    public int modificar(Factura_Venta facturaventa) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "update FacturaVenta set codFacturaVenta=?, fecha=?, cliente where codFacturaVenta =?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturaventa.getCodFVenta()));
        if (facturaventa.getFecha() instanceof java.util.Date) {
            listParam.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaventa.getFecha()).getTime())));
        } else {
            listParam.add(new Parametro(2, facturaventa.getFecha()));
        }
        listParam.add(new Parametro(3, facturaventa.getCliente()));
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
    public int eliminar(Factura_Venta facturaVenta) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM FacturaVenta VALUES WHERE codFacturaVenta=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturaVenta.getCodFVenta()));
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
    public Factura_Venta obtener(int codFVenta) throws Exception {
        Factura_Venta fv = null;
        String sqlC = "SELECT codFacturaVenta, fecha, cliente from FacturaVenta ";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, codFVenta));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ClienteI clienteDao = new ClienteImp();
            Cliente cl = null;
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
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
            if (conect != null) {
                conect.desconectar();
            }
        }
        return fv;
    }
    @Override
    public ArrayList<Factura_Venta> obtener() throws Exception {
        Factura_Venta fventa = null;
        String sqlC = "select codFacturaVenta, fecha, cliente from FacturaVenta";
        ArrayList<Factura_Venta> lstfv = new ArrayList<>();
        Conexion conect = null;
        try{
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
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
            if (conect != null) {
                conect.desconectar();
            }
        }
        return  lstfv;
    }
    @Override
    public int ingresar(Factura_Venta facturaVenta) throws Exception {
       int filasAfectadas = 0;
        String sqlC = "INSERT INTO FacturaVenta (codFacturaVentas, fecha, cliente) VALUES (?,?,?) ";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, facturaVenta.getCodFVenta()));
        if (facturaVenta.getFecha() instanceof java.util.Date) {
            listParam.add(new Parametro(2, new java.sql.Date(((java.util.Date) facturaVenta.getFecha()).getTime())));
        } else {
            listParam.add(new Parametro(2, facturaVenta.getFecha()));
        }
        listParam.add(new Parametro(3, facturaVenta.getCliente()));
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
}
