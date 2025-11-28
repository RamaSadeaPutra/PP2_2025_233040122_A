package Modul7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tugas extends JFrame {  

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabPane;

    public Tugas() {
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabPane = new JTabbedPane();

        tabPane.addTab("Input Data", createInputPanel());
        tabPane.addTab("Daftar Nilai", createTablePanel());

        add(tabPane);
        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNama = new JLabel("Nama Siswa:");
        JLabel lblNilai = new JLabel("Nilai:");
        JLabel lblMatkul = new JLabel("Mata Kuliah:");

        txtNama = new JTextField();
        txtNilai = new JTextField();

        cmbMatkul = new JComboBox<>(new String[]{
                "Pemrograman II",
                "Struktur Data",
                "Basis Data",
                "Matematika Diskrit"
        });

        JButton btnSimpan = new JButton("Simpan Data");
        JButton btnReset = new JButton("Reset");

        btnSimpan.addActionListener(e -> prosesSimpan());
        btnReset.addActionListener(e -> resetInput());

        panel.add(lblNama);
        panel.add(txtNama);

        panel.add(lblNilai);
        panel.add(txtNilai);

        panel.add(lblMatkul);
        panel.add(cmbMatkul);

        panel.add(btnSimpan);
        panel.add(btnReset);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama", "Mata Kuliah", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);

        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnHapus = new JButton("Hapus Data");
        btnHapus.addActionListener(e -> hapusData());
        panel.add(btnHapus, BorderLayout.SOUTH);

        return panel;
    }

    private void prosesSimpan() {
        String nama = txtNama.getText().trim();
        String strNilai = txtNilai.getText().trim();
        String matkul = (String) cmbMatkul.getSelectedItem();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal 3 karakter!");
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!");
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this, "Nilai harus 0-100!");
            return;
        }

        String grade;
        switch (nilai / 10) {
            case 10:
            case 9: grade = "A"; break;
            case 8: grade = "B"; break;
            case 7: grade = "C"; break;
            case 6: grade = "D"; break;
            default: grade = "E";
        }

        tableModel.addRow(new Object[]{
                nama, matkul, nilai, grade
        });

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        resetInput();
    }

    private void hapusData() {
        int row = tableData.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
        } else {
            tableModel.removeRow(row);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        }
    }

    private void resetInput() {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tugas::new);  // ← benar
    }
}
