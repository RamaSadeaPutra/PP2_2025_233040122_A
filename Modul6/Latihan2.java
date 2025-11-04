/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul6;

import java.awt.BorderLayout;
import java.util.concurrent.FutureTask;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ramaa
 */
public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("contoh Border layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
                
                frame.add(new JButton("NORTH"), BorderLayout.NORTH);
                frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
                frame.add(new JButton("EAST"), BorderLayout.EAST);
                frame.add(new JButton("WEST"), BorderLayout.WEST);
                frame.add(new JButton("CENTER"), BorderLayout.CENTER);
                    frame.setVisible(true);
    }
}
