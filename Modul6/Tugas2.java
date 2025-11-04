package Modul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tugas2 {
    public static void main(String[] args) {
   
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());


        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel labelHasil = new JLabel("");


        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(labelHasil);


        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(inputCelcius.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    labelHasil.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Input tidak valid! Masukkan angka yang benar.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
