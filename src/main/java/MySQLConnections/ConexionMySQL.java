/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MySQLConnections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConexionMySQL {
    public static void main(String[] args) {  
        try (
                Connection connection = ConnectionDB.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("SELECT * FROM `paises`");
                ) {
            
            System.out.println("DATABASE CONNECTED!!!");
            
            System.out.println("ID\t | \tNOMBRE");
            while (resultset.next()) {                
                System.out.println(resultset.getString("id") + "\t | \t" + resultset.getString("nombre"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
        }
    }
}
