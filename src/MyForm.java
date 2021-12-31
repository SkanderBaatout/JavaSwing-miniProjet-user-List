

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MyForm extends JFrame {
    public JLabel nomL = new JLabel("Nom");
    public JTextField nomT = new JTextField();
    public JLabel genreL = new JLabel("Genre");
    public JRadioButton HommeB = new JRadioButton();
    public JRadioButton FemmeB = new JRadioButton();
    public JButton ajouter = new JButton("Ajouter");
    public JButton Liste = new JButton("Liste");
    public ButtonGroup gp = new ButtonGroup();

    public MyForm() throws SQLException {
        super("Examen");
        this.setSize(450, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel Examen = new JLabel("Examen");
        JPanel Pinfos = new JPanel(new GridLayout(2, 2));


        Examen.setHorizontalAlignment(SwingConstants.CENTER);
        Examen.setFont(new Font("Time New Roman", Font.BOLD, 20));
        this.HommeB.setText("Homme");
        this.FemmeB.setText("Femme");
        HommeB.setActionCommand("Homme");
        FemmeB.setActionCommand("Femme");
        Pinfos.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), "Informations"));


        JPanel Pradio = new JPanel(new GridLayout(1, 2));
        Pradio.add(this.HommeB);
        Pradio.add(this.FemmeB);

        this.gp.add(this.HommeB);
        this.gp.add(this.FemmeB);
        JPanel Pbtn = new JPanel();
        Pbtn.add(this.Liste);
        Pbtn.add(this.ajouter);

        Pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JPanel Psouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel Pnorth = new JPanel();
        JPanel PLabel = new JPanel(new GridLayout(2, 2));
        Pinfos.add(this.nomL);
        Pinfos.add(this.nomT);
        Pinfos.add(this.genreL);
        Pinfos.add(Pradio);
        Pnorth.add(PLabel);


        Psouth.add(Pbtn);


        Container C = getContentPane();
        C.setLayout(new BorderLayout());
        C.add("North", Examen);
        C.add("Center", Pinfos);
        C.add("South", Psouth);


        this.setVisible(true);

        this.ajouter.addActionListener(new MyEvents(this));
        this.Liste.addActionListener(
                e ->
                {

                    try {
                        new MyList().setVisible(true);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                }

        );

    }

    public static void main(String[] args) throws SQLException {
        new MyForm();
    }
}
