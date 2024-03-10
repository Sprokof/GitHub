package github.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoticeWindow  {
    private static final String imageLocation = System.getProperty("user.dir") + "/src/main/resources/github.jpg/";
    private final String token;

    public NoticeWindow(String token) {
        this.token = token;
    }

    public void open() {
        ImageIcon icon = new ImageIcon(imageLocation);
        UIManager.put("OptionPane.minimumSize", new Dimension(300, 100));
        UIManager.put("OptionPane.okButtonText", "copy token");
        JFrame frame = new JFrame();
        JOptionPane pane = new JOptionPane(token);
        JDialog dialog = pane.createDialog(frame, "New github access token");
        JButton copyBtn = dialog.getRootPane().getDefaultButton();
        copyBtn.setFocusPainted(false);
        copyBtn.setBackground(new Color(219, 215, 210));
        copyBtn.addActionListener(e -> copyText(this.token));
        dialog.setIconImage(icon.getImage());
        dialog.setLocation(1115, 775);
        dialog.setVisible(true);
        dialog.dispose();
    }

    private void copyText(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
