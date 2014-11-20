package core;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by Daniel on 10/27/2014.
 */
public class FileAccess {

    public static File choseFile() {
        JFileChooser fileChooser = null;
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            fileChooser = new JFileChooser();
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {}
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
        final Thread recThread = new Thread(sr);
        final JTextPane text = new JTextPane();
        text.setText("Ready to record.");
        text.setEditable(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sr.line == null) {
//                    text.setText("Recording in 4...");
//                    waitOneSec();
//                    text.setText("Recording in 3...");
//                    waitOneSec();
//                    text.setText("Recording in 2...");
//                    waitOneSec();
//                    text.setText("Recording in 1...");
//                    waitOneSec();
//                    text.setText("Recording...");
                    recThread.start();
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
        container.setLayout(new GridLayout(2, 1));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(startButton);
        panel.add(stopButton);
        frame.add(text);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void waitOneSec()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public static File saveClip(File input)
    {
        JFileChooser fc = null;
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            fc = new JFileChooser();
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {}
        FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Files", "wav");
        fc.addChoosableFileFilter(filter);
        fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
        int result = fc.showSaveDialog(new JFrame());
        while (result == JFileChooser.CANCEL_OPTION)
        {
            Object[] options = {"Save", "Discard"};
            int response = JOptionPane.showOptionDialog(new JFrame(), "Your clip will not be saved.  are you sure you want to discard the recording?",
                    "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (response == JOptionPane.YES_OPTION)
            {
                result = fc.showSaveDialog(new JFrame());
            }
            else
            {
                input.delete();
                return null;
            }
        }
        if (result == JFileChooser.APPROVE_OPTION);
        {
            File clipFile = fc.getSelectedFile();
            CopyOption[] moveOptions = {/*StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.COPY_ATTRIBUTES, */StandardCopyOption.REPLACE_EXISTING};
            if (!clipFile.getAbsolutePath().endsWith(".wav"))
                clipFile = new File(clipFile.getAbsolutePath() + ".wav");
            try {
                Files.move(input.toPath(), clipFile.toPath(), moveOptions);
            } catch (IOException e) {
                e.printStackTrace();
            }
            input.delete();
            return clipFile;
        }
    }


}
