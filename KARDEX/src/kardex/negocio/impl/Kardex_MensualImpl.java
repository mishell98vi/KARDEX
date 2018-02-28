
package kardex.negocio.impl;
import kardex.accesoadatos.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import java.util.*;
import java.sql.*;
import java.text.*;
public class Kardex_MensualImpl implements kardexMensualI{
    @Override
    public ArrayList<Kardex> listadoKardexFecha(int codigoProducto, String mes, String anio) throws Exception {
        ArrayList<Kardex> lista = new ArrayList<>();
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://192.16.10.5:1433;databaseName=EMPRESA";
        String usuario = "integrador";
        String conraseña = "123";
        Connection conexion = null;
        ResultSet res = null;
        Kardex nKardex = null;
        String comandoSQL = "select * from Kardex where codigoProducto="+codigoProducto+" and (MONTH(fechaEmision)="+mes+" and YEAR(fechaEmision)="+anio+")";
        Producto prod = null;
        ProductoI prodDao = new ProductoImp();
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, conraseña);
            System.out.println("Conexion Establecida");
            Statement prstd = conexion.createStatement();
            res = prstd.executeQuery(comandoSQL);
            while (res.next()) {
                nKardex = new Kardex();
                prod = new Producto();
                nKardex.setCodKardex(res.getInt(1));
                prod = prodDao.obtener(res.getInt(2));
                nKardex.setProducto(prod);
                nKardex.setFechaEmision(res.getDate(3));
                nKardex.setTipoTransaccion(res.getString(4));
                nKardex.setExistencias(res.getInt(5));
                nKardex.setValorTotal(res.getDouble(6));
                nKardex.setCantEditable(res.getInt(7));
                lista.add(nKardex);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
