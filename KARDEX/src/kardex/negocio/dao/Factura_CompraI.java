package kardex.negocio.dao;

import kardex.negocio.entidades.Factura_Compra;
import java.util.*;

public interface Factura_CompraI {

    public int ingresar(Factura_Compra facturaCompra) throws Exception;

    public int modificar(Factura_Compra facturaCompra) throws Exception;

    public int eliminar(Factura_Compra facturaCompra) throws Exception;

    public Factura_Compra obtener(int codigoCompra) throws Exception;

    public ArrayList<Factura_Compra> obtener() throws Exception;

}
