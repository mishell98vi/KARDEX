
package kadex.negocios.impl;


import kardex.accesoadatos.Conexion;
import kardex.accesoadatos.Parametro;
import kadex.negocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import kardex.negocio.dao.*;

public class CategoriaImp implements CategoriaI{
 
    @Override
    public int insertar(Categoria categoria) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Categoria (codCategoria, nombre,descripcion) VALUES (?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, categoria.getCodigoCategoria()));
        lisParametros.add(new Parametro(2, categoria.getNombre()));
        lisParametros.add(new Parametro(4, categoria.getDescripcion()));
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
    public int modificar(Categoria categoria) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Categoria SET cosCategoria=?, nombre=?, descripcion=? WHERE codCategoria=?";
        
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, categoria.getCodigoCategoria()));
        lisParametros.add(new Parametro(2, categoria.getNombre()));
        lisParametros.add(new Parametro(4, categoria.getDescripcion()));
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
    public int eliminar(Categoria categoria) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Categoria WHERE codCategoria=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, categoria.getCodigoCategoria()));
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

    public Categoria obtener(String codCategoria) throws Exception {
        Categoria nCategoria = null;
        String sqlC = "SELECT codCategoria, nombre, descripcion FROM Categoria WHERE codCategoria=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codCategoria));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            
            while (rst.next()) {
               
                nCategoria = new Categoria();
                nCategoria.setCodigoCategoria(rst.getInt(1));
                nCategoria.setNombre(rst.getString(2));
                nCategoria.setDescripcion(rst.getString(3));
                
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nCategoria;
    }

    @Override
    public ArrayList<Categoria> obtener() throws Exception {
        ArrayList<Categoria> listCategoria = new ArrayList<>();
        String sqlC = "SELECT codCategoria, nombre, descripcion FROM Categoria";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
           
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
            if (con != null) {
                con.desconectar();
            }
        }
        return listCategoria;
    }
  
}
