package javajdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTIONSTRING = "jdbc:mysql://localhost/lp3_jdbc?user=root&password=senha&useSSL=false";
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(CONNECTIONSTRING);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stm) {
        closeConnection(con);
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
        closeConnection(con, stm);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
