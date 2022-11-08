import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class List extends JFrame {

    private JPanel myPanelPrincipal;
    private JButton button1;
    private JScrollPane scroll;
    private  JList jList;
    ArrayList<String> countries = new ArrayList<>();



    List() {
        DefaultListModel<String> listCountry = new DefaultListModel<>();
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
                countries.remove(e.getFirstIndex()); // como eliminar  con un click de un elemento de la lista es [jList.setListData] // ( tomando en cuenta que esa "e" es lo que me pasa cuando se llaman el metodo
                jList.setListData(countries.toArray());
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

                //Scroll to the last item
                int lastIndex = jList.getModel().getSize() - 1;
                if (lastIndex >= 0) {
                    jList.ensureIndexIsVisible(lastIndex);
                }

            }
        });
    }

    public static void main(String[] args) {{SwingUtilities.invokeLater(List::new);

        }
    }
}

