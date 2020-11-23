package club.notrighteous.manjaro.ui;

import javax.swing.*;

/**
 * www.github.com/MigoToLearn
 *
 * @author Migo
 */
public class InfoUI {

    public static void displayDebug(String message) {
        JOptionPane.showMessageDialog(null, message, "JManjaroJDK Debug", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void displayInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "JManjaroJDK", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void displayError(String message) {
        JOptionPane.showMessageDialog(null, message, "JManjaroJDK Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void displayError(Exception message) {
        JOptionPane.showMessageDialog(null, message.getMessage(), "JManjaroJDK Error", JOptionPane.ERROR_MESSAGE);
    }
}
