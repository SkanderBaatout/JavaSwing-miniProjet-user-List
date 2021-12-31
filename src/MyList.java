import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MyList extends JFrame {

        MyDatabase mdb=new MyDatabase("jdbc:mysql://localhost:3306/gui", "root", "");


     MyThread mt;

    JPanel PListe = new JPanel();
    public DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nom","Genre"}, 0);
    public JTable tab;
    public JScrollPane sp;
    Canvas cv = new Canvas();
    public MyList() throws SQLException {
        super("Examen");
        setSize(500,1000);
        setLocationRelativeTo(null);
        this.tab = new JTable(this.model);

        this.sp = new JScrollPane(this.tab);
        PListe.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1,true),"Liste des utilisateurs"));
        PListe.add(sp);
        cv.setBackground(Color.black);
       Container C=getContentPane();
        C.setLayout(new BorderLayout());
        C.add("North",PListe);
        C.add("Center",cv);
        this.setVisible(true);

        MyThread mt=new MyThread(this);
        mt.run();


    }
    public static void main(String[] args) throws SQLException {
        new MyList();
    }

}
