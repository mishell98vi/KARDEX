
package kardex.negocio.impl;
import kardex.accesoadatos.*;
import kardex.negocio.dao.*;
import kardex.negocio.entidades.*;
import java.util.*;
import java.sql.*;
public class KardexProductoImpl implements KardexProductoI{
    @Override
    public ArrayList<Kardex> listadoKardexProducto(int codProducto) throws Exception {
        ArrayList<Kardex> lista = new ArrayList<>();
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Proyecto";
        String usuario = "kardex2018";
        String conraseña = "kardex2018";
        Connection conexion = null;
        ResultSet res = null;
        Kardex nKardex=null;
        String comandoSQL = "Select codigoKardex, codigoProducto, fechaEmision, tipoTransaccion, existencia, valorTotal, cantEditable From Kardex Where codigoProducto="+String.valueOf(codProducto);
        ArrayList<Parametro> listaParametro = new ArrayList<>();
        Producto prod=null;
        ProductoI prodDao=new ProductoImp();
        listaParametro.add(new Parametro(1, codProducto));
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, conraseña);
            System.out.println("Conexion Establecida");
            Statement prstd=conexion.createStatement();
            res=prstd.executeQuery(comandoSQL);
            while(res.next()){
                nKardex= new Kardex();
                prod=new Producto();
                nKardex.setCodKardex(res.getInt(1));
                prod=prodDao.obtener(res.getInt(2));
                nKardex.setProducto(prod);
                nKardex.setFechaEmision(res.getDate(3));
                nKardex.setTipoTransaccion(res.getString(4));
                nKardex.setExistencias(res.getInt(5));
                nKardex.setValorTotal(res.getDouble(6));
                nKardex.setCantEditable(res.getInt(7));
                lista.add(nKardex);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return lista;
    }
}
