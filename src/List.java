import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class List extends JFrame {

    private JPanel myPanelPrincipal;
    private JButton button1;
    private JScrollPane scroll;
    private JList jList;
    ArrayList<String> countries = new ArrayList<>();



    List() {
        //DefaultListModel<String> listCountry = new DefaultListModel<>();
        //ArrayList<String> countries = new ArrayList<>();
        countries.add("Ecuador");
        countries.add("Colombia");
        countries.add("Peru");
        countries.add("Venezuela");
        countries.add("Brasil");
        countries.add("Chile");
        countries.add("Bolivia");
        countries.add("Argentina");
        countries.add("Uruguay");
        countries.add("panama");
        countries.add("mexico");
        countries.add("España");
        countries.add("Alemania");

        jList.setListData(countries.toArray());
        jList.addListSelectionListener(new ListSelectionListener() {
            //I take  name of the  component  JList  that call jlist
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(myPanelPrincipal);
        this.setSize(new Dimension(250, 250));
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long timeStamp= System.currentTimeMillis();
                countries.add(String.valueOf(timeStamp));
                jList.setListData(countries.toArray());
            }
        });
    }


    public static void main(String[] args) {{SwingUtilities.invokeLater(List::new);

        }
    }
}

