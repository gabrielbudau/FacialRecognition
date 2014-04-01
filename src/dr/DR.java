package dr;

import java.awt.Color;
import java.awt.color.ColorSpace;
import javax.swing.UIManager;
//import com.seaglasslookandfeel.SeaGlassLookAndFeel;
/**
 *
 * @author Gabriel Budau
 */
public class DR {

    public static void setLookAndFeel() {
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DR.setLookAndFeel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

}
