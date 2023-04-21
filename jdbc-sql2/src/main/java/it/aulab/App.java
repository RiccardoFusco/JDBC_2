package it.aulab;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.aulab.model.Prodotto;
import it.aulab.model.ProdottoDao;  

public class App {    

    // private static String descrizione;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        ProdottoDao dao = context.getBean(ProdottoDao.class);

        System.out.println("I prodotti sono " + dao.count());

        Prodotto p = dao.getOne(1L);

        System.out.println("id: " + p.getId());
        System.out.println("nome: " + p.getNome());
        System.out.println("descrizione: " + p.getDescrizione());
        System.out.println("prezzo: " + p.getPrezzo());
        System.out.println();

        List<Prodotto> all = dao.getData();

        for (Prodotto prodotto: all) {
            System.out.println("id: " + prodotto.getId());
            System.out.println("nome: " + prodotto.getNome());
            System.out.println("descrizione: " + prodotto.getDescrizione());
            System.out.println("prezzo: " + prodotto.getPrezzo());
            System.out.println();

        }


        // Prodotto newProdotto = new Prodotto();

        // newProdotto.setNome("Nuovo");
        // newProdotto.setDescrizione("Nuovo");
        // newProdotto.setPrezzo(30F);

        // dao.insert(new Prodotto());

        // dao.delete(5L);
        // dao.delete(6L);

        // p.setDescrizione(descrizione:"Questa è una nuova descrizione");
        
        // dao.update(p.getId(), p);

        // List<Prodotto> all = dao.getData();

        // for (Prodotto prodotto: all) {

        // System.out.println("id: " + prodotto.getId());
        // System.out.println("nome: " + prodotto.getNome());
        // System.out.println("descrizione: " + prodotto.getDescrizione());
        // System.out.println("prezzo: " + prodotto.getPrezzo());
        // System.out.println();

        List<Prodotto> productGreaterThan100 = dao.getGreatherThanPrezzo(100F);

        for (Prodotto prodotto: productGreaterThan100) {

        System.out.println("id: " + prodotto.getId());
        System.out.println("nome: " + prodotto.getNome());
        System.out.println("descrizione: " + prodotto.getDescrizione());
        System.out.println("prezzo: " + prodotto.getPrezzo());
        System.out.println();


        }
        

        // System.out.println("I prodotti sono " + dao.count());


    }


    // static final String connection_string = "jdbc:mariadb://localhost:3306/aulab?user=aulab&password=aulab";
    // // static final String connection_string_mysql = "jdbc:mysql://localhost:3306/aulab?user=aulab&password=aulab";


    // public static void main(String[] args) throws Exception {

    //         try {
                
    //         Class.forName("org.mariadb.jdbc.Driver");
    //         // "com.mysql.cj.jdbs"
    //         Connection connection = DriverManager.getConnection(connection_string);
    //         Statement statement = connection.createStatement();
    //         String query = "FROM prodotti p join varianti v ON p.id = v.prodotto_id";

    //         ResultSet count = statement.executeQuery("SELECT count(*) " + query);
    //         count.first();
    //         System.out.println("Le righe sono " + count.getInt(1));
    //         System.out.println();

    //         ResultSet resultSet = statement.executeQuery("SELECT p.nome, v.attributo, v.valore " + query);
    //         while (resultSet.next()) {
    //             // System.out.println("id: " + resultSet.getLong("id"));
    //             // System.out.println("nome: " + resultSet.getString("nome"));
    //             // System.out.println("descrizione: " + resultSet.getString("descrizione"));
    //             // System.out.println("prezzo: " + resultSet.getFloat("prezzo"));
    //             // System.out.println("attributo: " + resultSet.getString("attributo"));
    //             // System.out.println("valore: " + resultSet.getFloat("valore"));
                
    //             System.out.println("nome: " + resultSet.getString(1));
    //             System.out.println("attributo: " + resultSet.getString(2));
    //             System.out.println("valore: " + resultSet.getString(3));
    //             System.out.println();
            
    //         }

    //   } catch (SQLException e) {
    //     System.err.println("C'è stata una eccezione SQL.");
    //     // System.err.println(e.getMessage());
    //     // e.printStackTrace();
    //   }


}