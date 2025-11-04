/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ramaa
 */
public class Latihan4 {
    public static void main(String[] args) {
              JFrame frame = new JFrame("contoh Border layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,150);
        
        JLabel label = new JLabel("Halo, Klik tombol dibawah");
        JButton button = new JButton("Klik saya");
        ActionListener listener =  new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      label.setText("Tombol Setelah diilkiilk");
                  }
        
        };
        
        button.addActionListener(listener);
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
