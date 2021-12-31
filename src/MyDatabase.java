import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class MyDatabase {
    String url;
    String source;
    String mp;
    String drivername ="com.mysql.jdbc.Driver";
    public Connection con;
    public Statement stm;
    public MyDatabase(String url, String source, String mp) throws SQLException {

        this.url=url;
        this.source=source;
        this.mp=mp;
        con= Connection();

            stm=con.createStatement();



    }
    public Connection Connection() {
        try {
            Class.forName(drivername);
            return DriverManager.getConnection(url,source,mp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }}


    public int ajouter (Personne P){

        {
            try
            {
                int resUpd = stm.executeUpdate("INSERT INTO utilisateurs (nom, genre) VALUES ('"+P.getNom()+"','"+P.getGenre()+"')");
                System.out.println("ajouter db");
                return resUpd;
            }
            catch(Exception e){
                e.printStackTrace();
                return -1;
            }
        }
    }

    public void remplirTab(DefaultTableModel model) {
        try {
            ResultSet selectQuery=stm.executeQuery("select * from utilisateurs");
            while(selectQuery.next()) {
                model.addRow(new Object[]{selectQuery.getInt(1), selectQuery.getString(2), selectQuery.getString(3)});
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
