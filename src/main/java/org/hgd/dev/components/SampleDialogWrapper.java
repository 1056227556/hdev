package org.hgd.dev.components;

import com.intellij.openapi.ui.DialogWrapper;

import javax.swing.*;
import java.awt.*;

/**
 * 测试模态框
 */
public class SampleDialogWrapper extends DialogWrapper {

    public SampleDialogWrapper() {
        super(true); // use current window as parent
        setTitle("Test DialogWrapper");
        init();
    }

    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("testing");
        label.setPreferredSize(new Dimension(100, 100));
        dialogPanel.add(label, BorderLayout.CENTER);

        return dialogPanel;
    }

    public static void main(String[] args) {
        new SampleDialogWrapper().showAndGet();
    }
}