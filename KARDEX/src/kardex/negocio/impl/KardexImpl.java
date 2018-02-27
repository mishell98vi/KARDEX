
package kardex.negocio.impl;
import kardex.accesoadatos.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
public class KardexImpl implements KardexI{
     @Override
    public int insertar(Kardex kardex) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Kardex (codigoKardex, codigoProducto, fechaEmision, tipoTransaccion, existecias, valorTotal, cantidadEdicion) VALUES (?,?,?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, kardex.getCodKardex()));
        lisParametros.add(new Parametro(2, kardex.getProducto().getCodigoProducto()));
        if (kardex.getFechaEmision() instanceof java.util.Date) {
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) kardex.getFechaEmision()).getTime())));

        } else {
            lisParametros.add(new Parametro(3, kardex.getFechaEmision()));
        }
        lisParametros.add(new Parametro(4, kardex.getTipoTransaccion()));
        lisParametros.add(new Parametro(5, kardex.getExistencias()));
        lisParametros.add(new Parametro(6, kardex.getValorTotal()));
        lisParametros.add(new Parametro(7, kardex.getCantEditable()));
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
    public int modificar(Kardex kardex) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE kardex SET codigoKardex=?, codigoProducto=?, fechaEmision=?, tipoTransaccion=?, existecias=?, valorTotal=?, cantidadEdicion=? WHERE codigoKardex=? and codigoProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, kardex.getCodKardex()));
        lisParametros.add(new Parametro(2, kardex.getProducto().getCodigoProducto()));
        if (kardex.getFechaEmision() instanceof java.util.Date) {
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) kardex.getFechaEmision()).getTime())));

        } else {
            lisParametros.add(new Parametro(3, kardex.getFechaEmision()));
        }
        lisParametros.add(new Parametro(4, kardex.getTipoTransaccion()));
        lisParametros.add(new Parametro(5, kardex.getExistencias()));
        lisParametros.add(new Parametro(6, kardex.getValorTotal()));
        lisParametros.add(new Parametro(7, kardex.getCantEditable()));
        lisParametros.add(new Parametro(8, kardex.getCodKardex()));
        lisParametros.add(new Parametro(9, kardex.getProducto().getCodigoProducto()));
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
    public int eliminar(Kardex kardex) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM Kardex WHERE codigoKardex=? and codigoProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, kardex.getCodKardex()));
        lisParametros.add(new Parametro(2, kardex.getProducto().getCodigoProducto()));
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
    public Kardex obtener(int codKardex, int codProducto) throws Exception {
        Kardex nKardex = null;
        String sqlC = "SELECT codigoKardex, codigoProducto, fechaEmision, tipoTransaccion, existecias, valorTotal, cantidadEdicion FROM Kardex WHERE codigoKardex=? and codigoProducto=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, codKardex));
        lisParametros.add(new Parametro(2, codProducto));
        Conexion con = null;
        ProductoI prodDao = new ProductoImp();
        Producto nProd = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);

            while (rst.next()) {
                nProd = new Producto();
                nKardex = new Kardex();
                nKardex.setCodKardex(rst.getInt(1));
                nProd=prodDao.obtener(rst.getInt(2));
                nKardex.setFechaEmision(rst.getDate(3));
                nKardex.setTipoTransaccion(rst.getString(4));
                nKardex.setExistencias(rst.getInt(5));
                nKardex.setValorTotal(rst.getDouble(6));
                nKardex.setCantEditable(rst.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nKardex;
    }

    @Override
    public ArrayList<Kardex> obtener() throws Exception {
        ArrayList<Kardex> listKardex = new ArrayList<>();
        String sqlC = "SELECT codigoKardex, codigoProducto, fechaEmision, tipoTransaccion, existecias, valorTotal, cantidadEdicion FROM Kardex";
        Conexion con = null;
        ProductoI prodDao = new ProductoImp();
        Producto nProd = null;
        Kardex nKardex=null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);

            while (rst.next()) {
                nProd = new Producto();
                nKardex = new Kardex();
                nKardex.setCodKardex(rst.getInt(1));
                nProd=prodDao.obtener(rst.getInt(2));
                nKardex.setFechaEmision(rst.getDate(3));
                nKardex.setTipoTransaccion(rst.getString(4));
                nKardex.setExistencias(rst.getInt(5));
                nKardex.setValorTotal(rst.getDouble(6));
                nKardex.setCantEditable(rst.getInt(7));
                listKardex.add(nKardex);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listKardex;
    }

    @Override
    public ArrayList<Kardex> obtenerkardexProducto(int producto) throws Exception {
        ArrayList<Kardex> listKardex = new ArrayList<>();
        String sqlC = "SELECT codKardex, codProducto, fechaEmision, tipoTransaccion, existencia, valorTotal, cantEditable FROM Kardex Where codProducto=?";
        ArrayList<Parametro> listParametros=new ArrayList<>();
        listParametros.add(new Parametro(1, producto));
        Conexion con = null;
        ProductoI prodDao = new ProductoImp();
        Producto nProd = null;
        Kardex nKardex=null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, listParametros);
            while (rst.next()) {
                nProd = new Producto();
                nKardex = new Kardex();
                nKardex.setCodKardex(rst.getInt(1));
                nProd=prodDao.obtener(rst.getInt(2));
                nKardex.setFechaEmision(rst.getDate(3));
                nKardex.setTipoTransaccion(rst.getString(4));
                nKardex.setExistencias(rst.getInt(5));
                nKardex.setValorTotal(rst.getDouble(6));
                nKardex.setCantEditable(rst.getInt(7));
                listKardex.add(nKardex);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listKardex;
    }
}
