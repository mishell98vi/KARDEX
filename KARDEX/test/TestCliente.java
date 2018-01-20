/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;



import kardex.negocio.dao.*;
import kadex.negocio.entidades.*;
import kadex.negocios.impl.*;
import kardex.accesoadatos.*;
import java.util.*;
import java.sql.*;

public class TestCliente {
    
    public TestCliente() {
     ClienteI clDao = new ClienteImp();

        ///////TEST INSERTAR
//        int filas = 0;
//
//        Cliente cln = new Cliente("0603437047", "Daniel", "Bastian", "10 de agosto", "0973140672", "ao@gmail.com", new java.util.Date());
//        try {
//            filas = clDao.insertar(cln);
//            System.out.println("filas Inseertadas: " + filas + "\n");
//        } catch (Exception e) {
//        }
//        assertEquals(filas > 0, true);
        ////TEST OBTENER CODIGO
//        Cliente cli = new Cliente();
//
//        try {
//            cli = clDao.obtener("0603437047");
//            System.out.println(cli.getCedula()+" "+cli.getNombre() +" "+ cli.getApellido()+" "+cli.getDireccion()+" "+cli.getTelefono()+" "+cli.getEmail()+" "+cli.getFechaNac());
//        } catch (Exception e) {
//        }

        //////// TEST LISTADO 
        ArrayList<Cliente> clientess = new ArrayList<>();
        try {
            clientess = clDao.obtener();
            for (Cliente clientes : clientess) {
                System.out.println("CEDULA      " + "  NOMBRE "+ "   APELLIDO"+"DIRECCION"+"TELEFONO"+"EMAIL"+"FECHA NACIEMIENTO");
                System.out.println(clientes.getCedula() + "    " + clientes.getNombre() + "    " + clientes.getApellido() + "      " + clientes.getDireccion() + " " + clientes.getTelefono() + "" + clientes.getEmail() + " "+ clientes.getFechaNac());
            }

        } catch (Exception e) {
        }
        assertTrue(clientess.size() > 0);

    }


    }
    

