package github.gui;

import github.util.GitHubJobUtil;

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
    private final String accessLink;

    public NoticeWindow(String token) {
        this.accessLink = GitHubJobUtil.getAccessLink(token);
    }

    public void open() {
        ImageIcon icon = new ImageIcon(imageLocation);
        UIManager.put("OptionPane.minimumSize", new Dimension(300, 130));
        UIManager.put("OptionPane.okButtonText", "copy link");
        JFrame frame = new JFrame();
        JOptionPane pane = new JOptionPane(this.accessLink);
        JDialog dialog = pane.createDialog(frame, "New github access link");
        JButton copyBtn = dialog.getRootPane().getDefaultButton();
        copyBtn.setFocusPainted(false);
        copyBtn.setBackground(new Color(219, 215, 210));
        copyBtn.addActionListener(e -> copyAccessLink());
        dialog.setIconImage(icon.getImage());
        dialog.setLocation(930, 745);
        dialog.setVisible(true);
        dialog.dispose();
    }

    private void copyAccessLink() {
        StringSelection selection = new StringSelection(this.accessLink);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
