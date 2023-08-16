/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MySQLConnections;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Daniel
 */
public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost:3306/empresa";
    private static final String username = "daniel";
    private static final String password = "bender868";
    private static BasicDataSource dataSource;
    
    private static BasicDataSource getDataSource(){
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setInitialSize(3);
            dataSource.setMinIdle(3);
            dataSource.setMaxIdle(8);
            dataSource.setMaxTotal(8);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
}
