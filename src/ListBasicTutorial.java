
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class ListBasicTutorial extends JFrame {
    private final JList<String> countryList;

    public ListBasicTutorial() {

        DefaultListModel<String> listTutorial = new DefaultListModel<>();
        listTutorial.addElement("Ecuador");
        listTutorial.addElement("Colombia");
        listTutorial.addElement("Peru");
        listTutorial.addElement("Venezuela");
        listTutorial.addElement("Paraguay");
        listTutorial.addElement("Brasil");
        listTutorial.addElement("Chile");
        listTutorial.addElement("Bolivia");
        listTutorial.addElement("Argentina");
        listTutorial.addElement("Uruguay");

        countryList = new JList<>(listTutorial);
        //noinspection Convert2Lambda
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = countryList.getSelectedValuesList();
                    System.out.println(selectedValuesList);
                }
            }
        });
        add(new JScrollPane(countryList));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("listBasicTutorial");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListBasicTutorial::new);
    }
}

