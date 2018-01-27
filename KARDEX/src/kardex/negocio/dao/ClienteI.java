package kardex.negocio.dao;

import kardex.negocio.entidades.Cliente;
import java.util.*;

public interface ClienteI {

    public int ingresar(Cliente cliente) throws Exception;

    public int modificar(Cliente cliente) throws Exception;

    public int eliminar(Cliente cliente) throws Exception;

    public Cliente obtener(String codigoCliente) throws Exception;

    public ArrayList<Cliente> obtener() throws Exception;

}
