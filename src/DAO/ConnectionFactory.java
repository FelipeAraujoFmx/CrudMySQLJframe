package DAO;
/**
 *
 * @author Felipe.Araujo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/cyber";

    public static Connection createConnectionToMySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = createConnectionToMySQL();

        if (con != null) {
            System.out.println("Conexão criada com sucesso!");
            con.close();
        } else {
            System.out.println("Moiado");

        }

    }
}
