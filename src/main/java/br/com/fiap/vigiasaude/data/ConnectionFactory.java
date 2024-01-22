package br.com.fiap.vigiasaude.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        /* Obtém o driver de conexão com o banco de dados */
        Class.forName("oracle.jdbc.driver.OracleDriver");

        /* Configura os parâmetros da conexão */
        final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        final String USER = "rm99627";
        final String PASS = "051298";

        /* Tenta se conectar */
        return DriverManager.getConnection(URL, USER, PASS);
    }
}