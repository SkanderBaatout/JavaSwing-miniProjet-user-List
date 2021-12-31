import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class MyEvents implements ActionListener {
    MyForm mf;

     MyDatabase mdb=new MyDatabase("jdbc:mysql://localhost:3306/gui", "root", "");



    public MyEvents(MyForm mf) throws SQLException {
        this.mf=mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


       if(e.getSource()== mf.ajouter) {

           mdb.ajouter(new Personne(mf.nomT.getText(),mf.gp.getSelection().getActionCommand()));
           mf.nomT.setText("");

        }

    }
}
