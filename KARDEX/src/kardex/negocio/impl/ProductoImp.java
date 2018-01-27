
package kardex.negocio.impl;
import kardex.negocio.entidades.*;
import kardex.accesoadatos.*;
import java.sql.*;
import java.util.*;
import kardex.negocio.dao.*;

public class ProductoImp implements ProductoI{
    @Override
    public int modificar(Producto producto) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "UPDATE Producto SET codProducto=?, codCategoria=?, nombre=?, precio=? WHERE codProducto=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, producto.getCodigoProducto()));
        listParam.add(new Parametro(2, producto.getCategoria().getCodigoCategoria()));
        listParam.add(new Parametro(3, producto.getNombre()));
        listParam.add(new Parametro(4, producto.getPrecio()));
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
    public int eliminar(Producto producto) throws Exception {
        int filasAfectadas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codDetalleCompra=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, producto.getCodigoProducto()));
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
    public ArrayList<Producto> obtener() throws Exception {
        ArrayList<Producto> lstProducto=new ArrayList<>();
        Producto producto = null;
        String sqlC = "SELECT codProducto, codCategoria, nombre, precio FROM Producto";
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            Categoria categoria = null; 
            CategoriaI categoriaDao=new CategoriaImp();
            ResultSet rst = conect.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                producto = new Producto();
                categoria = new Categoria();
                producto.setCodigoProducto(rst.getInt(1));
                producto.getCategoria();
                categoria = categoriaDao.obtener(rst.getInt(2));
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getDouble(4));
                lstProducto.add(producto);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return lstProducto;
    }
    @Override
    public Producto obtener(int codProducto) throws Exception {
        Producto producto = null;
        String sqlC = "SELECT codProducto, codCategoria, nombre, precio FROM Producto Where codProducto=?";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, codProducto));
        Conexion conect = null;
        try {
            conect = new Conexion();
            conect.conectar();
            Categoria categoria = null; 
            CategoriaI categoriaDao=new CategoriaImp();
            ResultSet rst = conect.ejecutarQuery(sqlC, listParam);
            while (rst.next()) {
                producto = new Producto();
                categoria = new Categoria();
                producto.setCodigoProducto(rst.getInt(1));
                producto.getCategoria();
                categoria = categoriaDao.obtener(rst.getInt(2));
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getDouble(4));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conect != null) {
                conect.desconectar();
            }
        }
        return producto; 
    }
    @Override
    public int ingresar(Producto producto) throws Exception {
      int filasAfectadas = 0;
        String sqlC = "INSERT INTO Producto (codProducto, codCategoria, nombre , precio) VALUES (?,?,?,?)";
        ArrayList<Parametro> listParam = new ArrayList<>();
        listParam.add(new Parametro(1, producto.getCodigoProducto()));
        listParam.add(new Parametro(2, producto.getCategoria().getCodigoCategoria()));
        listParam.add(new Parametro(4, producto.getNombre()));
        listParam.add(new Parametro(5, producto.getPrecio()));
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
