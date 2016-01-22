package oa.codegen.sql;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by handong on 15/12/30.
 */
public class MysqlConnTool {

    public static Connection getTestConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://soeasyoadb:3306/soeasy_business";
            String user = "soeasy";
            String pass = "soeasy";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void colseConnection(Connection connection) {
        if(null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String transferDbFieldNameToJavaFieldName(String key) {
        String[] names = key.split("_");
        int index = 0 ;
        String newName = "";
        for(String name : names) {
            if(index++ >=1) {
                name = StringUtils.capitalize(name);
            }
            newName += name;
        }
        return newName;
    }

    public static void colseConnection(Connection connection, PreparedStatement preparedStatement) {
        try {
            if(preparedStatement != null && !preparedStatement.isClosed())preparedStatement.close();
            colseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(String dbIP, String dbPort, String dbInstanceName, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+dbIP+":"+dbPort+"/"+dbInstanceName;
            String user = userName;
            String pass = password;
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
