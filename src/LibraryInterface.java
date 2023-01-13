import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryInterface extends JFrame {
    JPanel panelPrincipal;
    private JTextField ingresarTitulo;
    private JTextField ingresarAutor;
    private JTextField publicacionLibro;
    private JTextField ingresarPag;
    private JButton addLibro;
    static ArrayList<Book> books= new ArrayList<>();

    LibraryInterface() {
        panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.setSize(new Dimension(670, 600));
        this.setVisible(true);

        addLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ingresarTitulo.getText().isEmpty() ||  ingresarAutor.getText().isEmpty() || publicacionLibro.getText().isEmpty()|| ingresarPag.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null,"Falta campos por llenar");
                }
                else{
                    String data = "";
                    try {
                        File file = new File("saveLibrary");
                        Scanner myReader = new Scanner(file);
                        while (myReader.hasNextLine()) {
                            //noinspection StringConcatenationInLoop
                            data += myReader.nextLine();
                        }
                        //LibraryInterface.books = LibraryInterface(data);

                    } catch (FileNotFoundException e2) {
                        throw new RuntimeException(e2);
                    }

                }


            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new LibraryInterface();
        frame.setVisible(true);

        //frame.getContentPane().
    }

}
