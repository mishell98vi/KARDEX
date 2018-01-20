/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadex.negocios.impl;
import kardex.accesoadatos.Conexion;
import kardex.accesoadatos.Parametro;
import kardex.negocio.dao.CategoriaI;
import kardex.negocio.dao.ProductoI;
import kadex.negocio.entidades.Categoria;
import kadex.negocio.entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoImp implements ProductoI{
    @Override
    public int modificar(Producto producto) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE Producto SET codProducto=?, codCategoria=?, nombre=?, precio=? WHERE codProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, producto.getCodigoProducto()));
        lisParametros.add(new Parametro(2, producto.getCategoria().getCodigoCategoria()));
        lisParametros.add(new Parametro(3, producto.getNombre()));
        lisParametros.add(new Parametro(4, producto.getPrecio()));
    
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
    public int eliminar(Producto producto) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM DetalleCompra WHERE codDetalleCompra=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, producto.getCodigoProducto()));
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
    public ArrayList<Producto> obtener() throws Exception {
        ArrayList<Producto> lstProducto=new ArrayList<>();
        Producto producto = null;
        String sqlC = "SELECT codProducto, codCategoria, nombre, precio FROM Producto";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Categoria categoria = null; 
            CategoriaI categoriaDao=new CategoriaImp();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
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
            if (con != null) {
                con.desconectar();
            }
        }
        return lstProducto;
    }

   

    @Override
    public Producto obtener(int codProducto) throws Exception {
        Producto producto = null;
        String sqlC = "SELECT codProducto, codCategoria, nombre, precio FROM Producto Where codProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codProducto));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Categoria categoria = null; 
            CategoriaI categoriaDao=new CategoriaImp();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
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
            if (con != null) {
                con.desconectar();
            }
        }
        return producto; }

    @Override
    public int ingresar(Producto producto) throws Exception {
      int numFilas = 0;
        String sqlC = "INSERT INTO Producto (codProducto, codCategoria, nombre , precio) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, producto.getCodigoProducto()));
        lisParametros.add(new Parametro(2, producto.getCategoria().getCodigoCategoria()));
        lisParametros.add(new Parametro(4, producto.getNombre()));
        lisParametros.add(new Parametro(5, producto.getPrecio()));
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
