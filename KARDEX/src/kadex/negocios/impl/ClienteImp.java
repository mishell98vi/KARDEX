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

public class ClienteImp implements ClienteI {

    @Override
    public int modificar(Cliente cliente) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE cliente SET cedua=?, nombre=?, apellido=?, direccion=?, telefono=?, email=?, fechaNac=? WHERE cedula=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, cliente.getCedula()));
        lisParametros.add(new Parametro(2, cliente.getNombre()));
        lisParametros.add(new Parametro(3, cliente.getApellido()));
        lisParametros.add(new Parametro(4, cliente.getDireccion()));
        lisParametros.add(new Parametro(5, cliente.getTelefono()));
        lisParametros.add(new Parametro(6, cliente.getEmail()));
        if (cliente.getFechaNac() instanceof java.util.Date) {
            lisParametros.add(new Parametro(7, new java.sql.Date(((java.util.Date) cliente.getFechaNac()).getTime())));
        } else {
            lisParametros.add(new Parametro(7, cliente.getFechaNac()));
        }
        lisParametros.add(new Parametro(8, cliente.getCedula()));
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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Cliente WHERE cedula=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, cliente.getCedula()));
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
    public Cliente obtener(String cedula) throws Exception {
        Cliente nCliente = null;
        String sqlC = "SELECT cedula, nombre, apellido, direccion, telefono, email, fechaNac FROM Cliente WHERE cedula=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, cedula));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
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
            if (con != null) {
                con.desconectar();
            }
        }
        return nCliente;
    }

    @Override
    public ArrayList<Cliente> obtener() throws Exception {
        ArrayList<Cliente> listCliente = new ArrayList<>();
        String sqlC = "SELECT cedula, nombre, apellido, direccion, telefono, email, fechaNac FROM Cliente";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
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
            if (con != null) {
                con.desconectar();
            }
        }
        return listCliente;
    }

    @Override
    public int ingresar(Cliente cliente) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Cliente (cedula, nombre,apellido,direccion,telefono, email,fechaNac) VALUES (?,?,?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, cliente.getCedula()));
        lisParametros.add(new Parametro(2, cliente.getNombre()));
        lisParametros.add(new Parametro(3, cliente.getApellido()));
        lisParametros.add(new Parametro(4, cliente.getDireccion()));
        lisParametros.add(new Parametro(5, cliente.getTelefono()));
        lisParametros.add(new Parametro(6, cliente.getEmail()));
        if (cliente.getFechaNac() instanceof java.util.Date) {
            lisParametros.add(new Parametro(7, new java.sql.Date(((java.util.Date) cliente.getFechaNac()).getTime())));
        } else {
            lisParametros.add(new Parametro(7, cliente.getFechaNac()));
        }
        
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

}
