

package Modul10.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MahasiswaView extends JFrame {

    public JTextField txtNama, txtNIM, txtJurusan, txtCari;
    public JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    public JTable tableMahasiswa;
    public DefaultTableModel model;

    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== PANEL FORM =====
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtNama = new JTextField();
        txtNIM = new JTextField();
        txtJurusan = new JTextField();

        panelForm.add(new JLabel("Nama:"));
        panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM:"));
        panelForm.add(txtNIM);
        panelForm.add(new JLabel("Jurusan:"));
        panelForm.add(txtJurusan);

        // ===== PANEL BUTTON =====
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        add(panelAtas, BorderLayout.NORTH);

        // ===== TABLE =====
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");

        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);

        // ===== PANEL CARI =====
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCari.setBorder(BorderFactory.createTitledBorder("Cari Data"));

        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");

        panelCari.add(new JLabel("Cari Nama:"));
        panelCari.add(txtCari);
        panelCari.add(btnCari);

        JPanel panelTengah = new JPanel(new BorderLayout());
        panelTengah.add(scrollPane, BorderLayout.CENTER);
        panelTengah.add(panelCari, BorderLayout.SOUTH);

        add(panelTengah, BorderLayout.CENTER);
    }

    // ===== LISTENER =====
    public void addSimpanListener(ActionListener listener) {
        btnSimpan.addActionListener(listener);
    }
    public void addEditListener(ActionListener listener) {
        btnEdit.addActionListener(listener);
    }
    public void addHapusListener(ActionListener listener) {
        btnHapus.addActionListener(listener);
    }
    public void addClearListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }
    public void addCariListener(ActionListener listener) {
        btnCari.addActionListener(listener);
    }
    public void addTableMouseListener(MouseAdapter listener) {
        tableMahasiswa.addMouseListener(listener);
    }

    // ===== FORM =====
    public void kosongkanForm() {
        txtNama.setText("");
        txtNIM.setText("");
        txtJurusan.setText("");
    }

    // ===== GETTER =====
    public String getTxtNama() {
        return txtNama.getText();
    }

    public String getTxtNIM() {
        return txtNIM.getText();
    }

    public String getTxtJurusan() {
        return txtJurusan.getText();
    }

    public String getTxtCari() {
        return txtCari.getText();
    }

    public JTable getTable() {
        return tableMahasiswa;
    }

    public DefaultTableModel getTableModel() {
        return model;
    }

    // ===== SETTER =====
    public void setTxtNama(String nama) {
        txtNama.setText(nama);
    }

    public void setTxtNIM(String nim) {
        txtNIM.setText(nim);
    }

    public void setTxtJurusan(String jurusan) {
        txtJurusan.setText(jurusan);
    }
}
