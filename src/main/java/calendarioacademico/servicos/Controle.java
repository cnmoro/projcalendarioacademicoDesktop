package calendarioacademico.servicos;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controle {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    new InterfaceLogin().setVisible(true);
                });  

	}
}
