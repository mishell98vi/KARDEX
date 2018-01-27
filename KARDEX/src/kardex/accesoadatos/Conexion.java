/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.accesoadatos;

import java.sql.*;
import java.util.*;
import java.util.Date;
public class Conexion {
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=Proyecto";
    String user = "sebas";
    String pass = "sebas2";
    Connection con = null;

    public void conectar() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion Establecida!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en con: " + e.getMessage());
        }
    }

    public ResultSet ejecutarQuery(String comandoSQL, List<Parametro> lstParam) {
        ResultSet rest = null;
        try {
            PreparedStatement state = con.prepareStatement(comandoSQL);
            if (lstParam != null) {
                for (Parametro valorP : lstParam) {
                    
                    if (valorP.getValor() instanceof java.util.Date) {
                        state.setObject(valorP.getPosicion(), new java.sql.Date(((java.util.Date) valorP.getValor()).getTime()));
                    } else {
                        state.setObject(valorP.getPosicion(), valorP.getValor());
                    }

                }
            }
            rest = state.executeQuery();
        }catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return rest;
    }

    public int ejecutarComando(String sql, ArrayList<Parametro> ValoresParametro) {
        int nFilasAfect=0;
        ResultSet rest = null;
        try {
            PreparedStatement state = con.prepareStatement(sql);
            if (ValoresParametro != null) {
                for (Parametro valorP : ValoresParametro) {
                    if (valorP.getValor() instanceof java.util.Date) {
                        state.setObject(valorP.getPosicion(), new java.sql.Date(((java.util.Date) valorP.getValor()).getTime()));
                    } else {
                        state.setObject(valorP.getPosicion(), valorP.getValor());
                    }
                }
            }
            nFilasAfect=state.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return nFilasAfect;
    }

    public void desconectar() {

        try {
            if (con != null) {
                if (!con.isClosed()) {
                    con.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Error de descon: " + e.getMessage());
        }

    }
}
