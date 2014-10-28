package core;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Daniel on 10/27/2014.
 */
public class FileAccess {
    public static File choseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(new JFrame());
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }

    public static void loadSaveFile() {

    }

    public static void record(final File location) {
        final SoundRecorder sr = new SoundRecorder(location);
        final JFrame frame = new JFrame("Recording");
        final JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sr.line == null) {
                    sr.start();
                    startButton.setText("Pause");
                } else {
                    if (sr.line.isActive()) {
                        sr.pause();
                        startButton.setText("Resume");
                    } else {
                        sr.unpause();
                        startButton.setText("Pause");
                    }
                }
            }
        });
        final JButton stopButton = new JButton("Finish");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sr.finish();
                frame.setVisible(false);
                frame.dispose();
                FileAccess.saveClip(location);
            }
        });
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(1, 2));
        frame.add(startButton);
        frame.add(stopButton);
        frame.pack();
        frame.setVisible(true);
    }

    public static void createClip()
    {
        File file = new File("temp.wav");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        record(file);
    }

    public static void saveClip(File input)
    {
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Files", "wav");
        fc.addChoosableFileFilter(filter);
        fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
        int result = fc.showSaveDialog(new JFrame());
        while (result == JFileChooser.CANCEL_OPTION)
        {
            Object[] options = {"Save", "Discard"};
            int responce = JOptionPane.showOptionDialog(new JFrame(), "Your clip will not be saved.  are you sure you want to discard the recording?",
                    "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (responce == JOptionPane.YES_OPTION)
            {
                result = fc.showSaveDialog(new JFrame());
            }
            else
            {
                input.delete();
                return;
            }
        }
        if (result == JFileChooser.APPROVE_OPTION);
        {
            File clipFile = fc.getSelectedFile();
        }
    }

    class RecThread extends Thread
    {
        void run()
        {
            
        }
    }
}
