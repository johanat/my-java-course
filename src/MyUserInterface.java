import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyUserInterface extends JFrame {

    private JPanel mainPanel;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel row5;
    private JTextField resultPantalla;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn8;
    private JButton btn5;
    private JButton btn6;
    private JButton btn9;
    private JButton btn7;
    private JButton btnX;
    private JButton btnIgual;
    private JButton btnSuma;
    private JButton btnResta;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JTextField txtInput;
    private JButton btnClick;
    private JLabel myLabel;

    MyUserInterface() {
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(new Dimension(300, 300));

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = resultPantalla.getText();
                String nuevo = actual + "0";
                resultPantalla.setText(nuevo);
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("1"));
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("2"));
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("3"));
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("4"));
            }

        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("5"));
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("6"));
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("7"));
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultPantalla.setText(resultPantalla.getText().concat("8"));
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actual = resultPantalla.getText();
                String nuevo = actual + "9";

                resultPantalla.setText(nuevo);
            }
        });
        btnX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wordLenght;
                wordLenght = resultPantalla.getText().length();
                resultPantalla.setText(resultPantalla.getText().substring(0, wordLenght - 1));
            }
        });
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String screen = resultPantalla.getText();


                if (screen.contains("+") == true) {
                    String[] suma = screen.split("\\+");
                    String suma1 = suma[0];
                    String suma2 = suma[1];
                    int number1 = Integer.parseInt(suma1);
                    int number2 = Integer.parseInt(suma2);
                    int result = number1 + number2;
                    String finaly = String.valueOf(result);
                    resultPantalla.setText(finaly);

                } else if (screen.contains("-") == true) {
                    String[] resta = screen.split("-");
                    String resta1 = resta[0];
                    String resta2 = resta[1];
                    int number1 = Integer.parseInt(resta1);
                    int number2 = Integer.parseInt(resta2);
                    int result = number1 - number2;
                    String finaly = String.valueOf(result);
                    resultPantalla.setText(finaly);

                } else if (screen.contains("*") == true) {
                    String[] multiplicacion = screen.split("\\*");
                    String multipli0 = multiplicacion[0];
                    String multiplic1 = multiplicacion[1];
                    int number1 = Integer.parseInt(multipli0);
                    int number2 = Integer.parseInt(multiplic1);
                    int result = number1 * number2;
                    String finaly = String.valueOf(result);
                    resultPantalla.setText(finaly);

                } else if (screen.contains("/") == true) {
                    String[] division = screen.split("/");
                    String division0 = division[0];
                    String division1 = division[1];
                    int number1 = Integer.parseInt(division0);
                    int number2 = Integer.parseInt(division1);
                    float result = number1*1f / number2;
                    String finaly = String.valueOf(result);
                    resultPantalla.setText(finaly);

                }

            }
        });
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actual = resultPantalla.getText();

                if (actual.endsWith("+") == false) {
                    resultPantalla.setText(actual + "+");
                    if (actual.contains("+") == true) {
                        resultPantalla.setText(actual);

                    }
                }
            }

            ;
        });

        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = resultPantalla.getText();
                if (actual.endsWith("-") == false) {
                    resultPantalla.setText(actual + "-");
                    if (actual.contains("-") == true) {
                        resultPantalla.setText(actual);
                    }
                }
            }
        });
        btnMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = resultPantalla.getText();
                if (actual.endsWith("*") == false) {
                    resultPantalla.setText(actual + "*");
                    if (actual.contains("*") == true) {
                        resultPantalla.setText(actual);
                    }
                }
            }
        });
        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevo = resultPantalla.getText();
                if (nuevo.endsWith("/") == false) {
                    resultPantalla.setText(nuevo + "/");
                    if (nuevo.contains("+") == true) {
                        resultPantalla.setText(nuevo);
                    }
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new MyUserInterface();
        frame.setVisible(true);
    }
}
