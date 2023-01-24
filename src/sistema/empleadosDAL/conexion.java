/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Victor hugo
 */
public class conexion {

    String strconexionDB = "jdbc:sqlite:C:/Users/Victo/Documents/sistema.s3db";
    Connection conn = null;

    public conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strconexionDB);

            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }
    }

    public int ejecutarSentenciaSQL(String strSentenciaSQL) {

        try {

            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }
// este metodo devuelve informacion y se verifica si existe o no .
    
    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {

            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
