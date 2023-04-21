package it.aulab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {

    static final String connection_string = "jdbc:mariadb://localhost:3306/aulab?user=aulab&password=aulab";
    // static final String connection_string_mysql = "jdbc:mysql://localhost:3306/aulab?user=aulab&password=aulab";


    public static void main(String[] args) throws Exception {

            try {
                
            Class.forName("org.mariadb.jdbc.Driver");
            // "com.mysql.cj.jdbs"
            Connection connection = DriverManager.getConnection(connection_string);
            Statement statement = connection.createStatement();
            String query = "FROM prodotti p join varianti v ON p.id = v.prodotto_id";

            ResultSet count = statement.executeQuery("SELECT count(*) " + query);
            count.first();
            System.out.println("Le righe sono " + count.getInt(1));
            System.out.println();

            ResultSet resultSet = statement.executeQuery("SELECT p.nome, v.attributo, v.valore " + query);
            while (resultSet.next()) {
                // System.out.println("id: " + resultSet.getLong("id"));
                // System.out.println("nome: " + resultSet.getString("nome"));
                // System.out.println("descrizione: " + resultSet.getString("descrizione"));
                // System.out.println("prezzo: " + resultSet.getFloat("prezzo"));
                // System.out.println("attributo: " + resultSet.getString("attributo"));
                // System.out.println("valore: " + resultSet.getFloat("valore"));
                
                System.out.println("nome: " + resultSet.getString(1));
                System.out.println("attributo: " + resultSet.getString(2));
                System.out.println("valore: " + resultSet.getString(3));
                System.out.println();
            
            }

      } catch (SQLException e) {
        System.err.println("C'è stata una eccezione SQL.");
        // System.err.println(e.getMessage());
        // e.printStackTrace();
      }

}
}
