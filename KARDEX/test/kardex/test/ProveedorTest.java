
package kardex.test;
import kardex.negocio.dao.*;
import kardex.accesoadatos.*;
import kardex.negocio.entidades.*;
import kardex.negocio.impl.*;
import java.util.*;
import java.sql.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProveedorTest {
    
    public ProveedorTest() {
    }
     @Test
    public void testGeneral() {
        ProveedorI proveedorDao=new ProveedorImp();
       
//TEST INSERTAR

        int filas=0;
       
        Proveedor nuevoProveedor=new Proveedor("101","Maria","San antonio","123","agmailcom");
        try {
            filas=proveedorDao.ingresar(nuevoProveedor);
            System.out.println("Filas Insertadas:"+filas);
        } catch (Exception e) {
        }
        assertTrue(filas>0);
        
//TEST OBTENER POR CODIGO

        Proveedor prove=new Proveedor();
        try {
            prove=proveedorDao.obtener("10");
            System.out.println(prove.getRuc()+"    "+prove.getNombre()+"    "+prove.getDireccion()+"    "+prove.getTelefono()+"     "+prove.getEmail());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(prove!=null, true);
            
//TEST LISTADO

        ArrayList<Proveedor> proveedor=new ArrayList<>();
        try {
            proveedor=proveedorDao.obtener();
           System.out.println("RUC \t" + " \tNombre\t" + " \tDireccion\t" + "\tTelefono\t "+ "\t Email" );
            for(Proveedor pro:proveedor){
                System.out.println(pro.getRuc()+"\t\t"+pro.getNombre()+"\t\t"+pro.getDireccion()+"\t"+pro.getTelefono()+"\t"+pro.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        assertTrue(proveedor.size()>0);
    }
}
