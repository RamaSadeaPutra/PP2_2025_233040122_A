package modul10;

import javax.swing.SwingUtilities;

import modul10.controller.MahasiswaController;
import modul10.model.MahasiswaModel;
import Modul10.View.MahasiswaView;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaView view = new MahasiswaView();
            MahasiswaModel model = new MahasiswaModel(view.model);
            new MahasiswaController(model, view);
            view.setVisible(true);
        });
    }
}
