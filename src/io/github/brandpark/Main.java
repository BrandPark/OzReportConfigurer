package io.github.brandpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public Main() {
        JFrame frame = new JFrame("OZ Report Configurer for 4.0ver");
        MainPanel panel = new MainPanel(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    private static class MainPanel extends JPanel {
        public MainPanel(JFrame frame) {
            setPreferredSize(new Dimension(400, 400));
            JLabel basePathLabel = new JLabel("OZ 설치경로 : ");
            JTextField basePathField = new JTextField("C:\\Program Files (x86)\\FORCS\\OZ...");
            JButton fileChooseBtn = new JButton("열기");
            JFileChooser basePathFileChooser = new JFileChooser();

            fileChooseBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    basePathFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int ret = basePathFileChooser.showOpenDialog(null);
                    if (ret != JFileChooser.APPROVE_OPTION) {
                        JOptionPane.showMessageDialog(
                                null
                                , "경로를 선택해주세요"
                                , "경고", JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }
                    String basePath = basePathFileChooser.getSelectedFile().getPath();
                    basePathField.setText(basePath);
                }
            });
            add(basePathLabel);
            add(basePathField);
            add(fileChooseBtn);
        }

    }
}

