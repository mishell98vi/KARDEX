
package kardex.negocio.impl;
import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class ProveedorImp implements ProveedorI {
     @Override
    public int ingresar(Proveedor proveedor) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "INSERT INTO Proveedor (ruc, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, proveedor.getRuc()));
        listParam.add(new Parametro(2, proveedor.getNombre()));
        listParam.add(new Parametro(3, proveedor.getDireccion()));
        listParam.add(new Parametro(4, proveedor.getTelefono()));
        listParam.add(new Parametro(5, proveedor.getEmail()));
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
    public int modificar(Proveedor proveedor) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE Proveedor SET ruc=?, nombre=?, direccion=?, telefono=?, eMail=? WHERE ruc=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, proveedor.getRuc()));
        listParam.add(new Parametro(2, proveedor.getNombre()));
        listParam.add(new Parametro(3, proveedor.getDireccion()));
        listParam.add(new Parametro(4, proveedor.getTelefono()));
        listParam.add(new Parametro(5, proveedor.getEmail()));
        listParam.add(new Parametro(6, proveedor.getRuc()));
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
    public int eliminar(Proveedor proveedor) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM Proveedor WHERE ruc=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, proveedor.getRuc()));
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
    public Proveedor obtener(String ruc) throws Exception {
        Proveedor elProveedor = null;
        String sqlC = "SELECT ruc, nombre, direccion, telefono, email FROM Proveedor Where ruc=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, ruc));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            while (rst.next()) {
                elProveedor = new Proveedor();
                elProveedor.setRuc(rst.getString(1));
                elProveedor.setNombre(rst.getString(2));
                elProveedor.setDireccion(rst.getString(3));
                elProveedor.setTelefono(rst.getString(4));
                elProveedor.setEmail(rst.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return elProveedor;
    }
    @Override
    public ArrayList<Proveedor> obtener() throws Exception {
        ArrayList<Proveedor> listProveedor = new ArrayList<>();
        Proveedor nProveedor = null;
        String sqlC = "Select ruc, nombre, direccion, telefono, email from Proveedor";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                nProveedor = new Proveedor();
                nProveedor.setRuc(rst.getString(1));
                nProveedor.setNombre(rst.getString(2));
                nProveedor.setDireccion(rst.getString(3));
                nProveedor.setTelefono(rst.getString(4));
                nProveedor.setEmail(rst.getString(5));
                listProveedor.add(nProveedor);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return listProveedor;
    }
}
