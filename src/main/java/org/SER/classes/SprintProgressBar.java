package org.SER.classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SprintProgressBar extends JFrame {

    private final SprintBacklog sprintBacklog;
    private final JProgressBar progressBar;

    public SprintProgressBar(SprintBacklog sprintBacklog) {
        this.sprintBacklog = sprintBacklog;

        // New JFrame is created, if ot required remove the code of new JFrame and integrate remaining code
        // Create a frame
        JFrame frame = new JFrame("Sprint Progress Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Create a progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // Create a button to update progress
        JButton updateButton = new JButton("Update Progress");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProgressBar();
            }
        });

        // Create a panel and add components
        JPanel panel = new JPanel();
        panel.add(progressBar);
        panel.add(updateButton);

        // Add panel to the frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }

    // Method to update the progress bar based on the SprintBacklog progress
    private void updateProgressBar() {
        int progress = sprintBacklog.getProgress();
        progressBar.setValue(progress);
        progressBar.setString("Progress: " + progress + "%");
    }
}
