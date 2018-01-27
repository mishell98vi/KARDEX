package kardex.negocio.impl;

import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class ClienteImp implements ClienteI {
    @Override
    public int modificar(Cliente cliente) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE cliente SET cedua=?, nombre=?, apellido=?, direccion=?, telefono=?, email=?, fechaNac=? WHERE cedula=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, cliente.getCedula()));
        listParam.add(new Parametro(2, cliente.getNombre()));
        listParam.add(new Parametro(3, cliente.getApellido()));
        listParam.add(new Parametro(4, cliente.getDireccion()));
        listParam.add(new Parametro(5, cliente.getTelefono()));
        listParam.add(new Parametro(6, cliente.getEmail()));
        if (cliente.getFechaNac() instanceof java.util.Date) {
            listParam.add(new Parametro(7, new java.sql.Date(((java.util.Date) cliente.getFechaNac()).getTime())));
        } else {
            listParam.add(new Parametro(7, cliente.getFechaNac()));
        }
        listParam.add(new Parametro(8, cliente.getCedula()));
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
    public int eliminar(Cliente cliente) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM Cliente WHERE cedula=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, cliente.getCedula()));
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
    public Cliente obtener(String cedula) throws Exception {
        Cliente nCliente = null;
        String sqlC = "SELECT cedula, nombre, apellido, direccion, telefono, email, fechaNac FROM Cliente WHERE cedula=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, cedula));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            while (rst.next()) {
                nCliente = new Cliente();
                nCliente.setCedula(rst.getString(1));
                nCliente.setNombre(rst.getString(2));
                nCliente.setApellido(rst.getString(3));
                nCliente.setDireccion(rst.getString(4));
                nCliente.setTelefono(rst.getString(5));
                nCliente.setEmail(rst.getString(6));
                nCliente.setFechaNac(rst.getDate(7));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return nCliente;
    }
    @Override
    public ArrayList<Cliente> obtener() throws Exception {
        ArrayList<Cliente> listCliente = new ArrayList<>();
        String sqlC = "SELECT cedula, nombre, apellido, direccion, telefono, email, fechaNac FROM Cliente";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                Cliente nCliente = new Cliente();
                nCliente.setCedula(rst.getString(1));
                nCliente.setNombre(rst.getString(2));
                nCliente.setApellido(rst.getString(3));
                nCliente.setDireccion(rst.getString(4));
                nCliente.setTelefono(rst.getString(5));
                nCliente.setEmail(rst.getString(6));
                nCliente.setFechaNac(rst.getDate(7));
                listCliente.add(nCliente);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return listCliente;
    }
    @Override
    public int ingresar(Cliente cliente) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "INSERT INTO Cliente (cedula, nombre,apellido,direccion,telefono, email,fechaNac) VALUES (?,?,?,?,?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, cliente.getCedula()));
        listParam.add(new Parametro(2, cliente.getNombre()));
        listParam.add(new Parametro(3, cliente.getApellido()));
        listParam.add(new Parametro(4, cliente.getDireccion()));
        listParam.add(new Parametro(5, cliente.getTelefono()));
        listParam.add(new Parametro(6, cliente.getEmail()));
        if (cliente.getFechaNac() instanceof java.util.Date) {
            listParam.add(new Parametro(7, new java.sql.Date(((java.util.Date) cliente.getFechaNac()).getTime())));
        } else {
            listParam.add(new Parametro(7, cliente.getFechaNac()));
        }
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
}
