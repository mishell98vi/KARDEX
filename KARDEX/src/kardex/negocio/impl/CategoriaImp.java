package kardex.negocio.impl;

import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class CategoriaImp implements CategoriaI {
    @Override
    public int insertar(Categoria categoria) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "INSERT INTO Categoria (codCategoria, nombre,descripcion) VALUES (?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, categoria.getCodigoCategoria()));
        listParam.add(new Parametro(2, categoria.getNombre()));
        listParam.add(new Parametro(4, categoria.getDescripcion()));
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
    public int modificar(Categoria categoria) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE Categoria SET cosCategoria=?, nombre=?, descripcion=? WHERE codCategoria=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, categoria.getCodigoCategoria()));
        listParam.add(new Parametro(2, categoria.getNombre()));
        listParam.add(new Parametro(4, categoria.getDescripcion()));
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
    public int eliminar(Categoria categoria) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM Categoria WHERE codCategoria=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, categoria.getCodigoCategoria()));
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
    public ArrayList<Categoria> obtener() throws Exception {
        ArrayList<Categoria> listCategoria = new ArrayList<>();
        String sqlC = "SELECT codCategoria, nombre, descripcion FROM Categoria";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                Categoria nCategoria = new Categoria();
                nCategoria.setCodigoCategoria(rst.getInt(1));
                nCategoria.setNombre(rst.getString(2));
                nCategoria.setDescripcion(rst.getString(3));
                listCategoria.add(nCategoria);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return listCategoria;
    }
    @Override
    public Categoria obtener(int codCategoria) throws Exception {
        Categoria nCategoria = null;
        String sqlC = "SELECT codCategoria, nombre, descripcion FROM Categoria WHERE codCategoria=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, codCategoria));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            while (rst.next()) {
                nCategoria = new Categoria();
                nCategoria.setCodigoCategoria(rst.getInt(1));
                nCategoria.setNombre(rst.getString(2));
                nCategoria.setDescripcion(rst.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return nCategoria;
    }
}
