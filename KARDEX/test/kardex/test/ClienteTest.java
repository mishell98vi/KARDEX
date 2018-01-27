
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {
    
    public ClienteTest() {
    
    }
     @Test
    public void testGeneral() {
        ClienteI clDao = new ClienteImp();

        ///////TEST INSERTAR
        
        int filas = 0;

        Cliente cln = new Cliente("0603437047", "Mishell", "Viteri", "Puyo", "0973140672", "mishell9vi@gmail.com", new java.util.Date());
        try {
            filas = clDao.ingresar(cln);
            System.out.println("Filas Insertadas: " + filas + "\n");
        } catch (Exception e) {
        }
        assertTrue(filas > 0);
        
        ////TEST OBTENER CODIGO
        Cliente cli = new Cliente();

        try {
            cli = clDao.obtener("1600712770");
            System.out.println(cli.getCedula() + " " + cli.getNombre() + " " + cli.getApellido() + " " + cli.getDireccion() + " " + cli.getTelefono() + " " + cli.getEmail() + " " + cli.getFechaNac());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(cli!=null, true);
        
        //////// TEST LISTADO 
        
        ArrayList<Cliente> clientess = new ArrayList<>();
        try {
            clientess = clDao.obtener();
            for (Cliente clientes : clientess) {
                System.out.println("Cedula     " + "  Nombre "+ "   Apellido "+"Direccion"+"Telefono"+"Email"+"Fecha_nacimiento");
                System.out.println(clientes.getCedula() + "" + clientes.getNombre() + "" + clientes.getApellido() + "" + clientes.getDireccion() + "" + clientes.getTelefono() + "" + clientes.getEmail() + " "+ clientes.getFechaNac());
            }
        } catch (Exception e) {
        }
       assertTrue(clientess.size() > 0);
    }

}
