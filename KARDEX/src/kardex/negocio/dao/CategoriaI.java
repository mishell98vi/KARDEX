/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.negocio.dao;
import kadex.negocio.entidades.Categoria;
import java.util.ArrayList;
public interface CategoriaI {
    public int insertar (Categoria categoria) throws Exception;
    public int modificar (Categoria categoria) throws Exception; 
    public int eliminar (Categoria categoria) throws Exception;
    public Categoria obtener(int codCategoria) throws Exception;
    public ArrayList<Categoria> obtener() throws Exception;
}
