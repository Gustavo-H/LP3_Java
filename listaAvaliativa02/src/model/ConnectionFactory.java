/*

--Query para criar tabela produto
CREATE TABLE IF NOT EXISTS produto (
  codigo int NOT NULL AUTO_INCREMENT,
  descricao varchar(100) NOT NULL,
  marca varchar(50) NOT NULL,
  preco double NOT NULL,
  PRIMARY KEY (codigo)
)


--Craga de Dados para tabela produto
INSERT INTO produto (descricao, marca, preco) VALUES
('Agua sem Gas', 'Iguarapé', 2.5),
('Agua com Gas', 'Iguarapé', 3.5),
('Sabonete', 'Dove', 2.5),
('Sabao Liquido', 'Ype', 4.5),
('Pao de Forma', 'Seven Boys', 6.85);
 

*/
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GustavoHenriquePinhe
 */
public class ConnectionFactory {

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
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stm) {
        closeConnection(con);
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
        closeConnection(con, stm);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
