package QuickSort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        
        // play/pause не меняется без "final"
        final String play = "Play";
        final String pause = "Pause";
        
        //инициализация массива
        QuickSort.initArray();
        
        //создание окна
        JFrame frame = new JFrame("QuickSort"); 
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        //создание панели (background)
        MyPanel panel = new MyPanel();
        panel.setLayout(null);
        /*JButton but = new JButton("5");
        but.setSize(50, 30);
        but.setLocation(475, 235);
        panel.add(but);*/
        frame.add(panel);
        
        //button generate
        JButton button = new JButton("Generate");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                QuickSort.initArray();
                QuickSort.printArray();
                frame.repaint();
            }
        });
        button.setSize(90, 30);
        button.setLocation(50, 545);
        panel.add(button);
        
        //button exit
        button = new JButton("Exit");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        button.setSize(90, 30);
        button.setLocation(760, 545);
        panel.add(button);
        
        //button play/pause
        final JButton buttonPlay = new JButton();
        buttonPlay.setText("Play");
        buttonPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (buttonPlay.getText().equals(play))
                    buttonPlay.setText(pause);
                else buttonPlay.setText(play);
            }
        });
        buttonPlay.setSize(70, 30);
        buttonPlay.setLocation(415, 545);
        panel.add(buttonPlay);
        
        //button x0.5
        button = new JButton("x0.5");
        button.setSize(60, 30);
        button.setLocation(340, 545);
        panel.add(button);
        
        //button x2.0
        button = new JButton("x2.0");
        button.setSize(60, 30);
        button.setLocation(500, 545);
        panel.add(button);
        
        //button start
        button = new JButton("Start");
        button.setSize(70, 30);
        button.setLocation(255, 545);
        panel.add(button);
        
        //button finish
        button = new JButton("Finish");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    QuickSort.quickSort();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                QuickSort.printArray();
                QuickSort.checkArray();
                frame.repaint();
            }
        });
        button.setSize(70, 30);
        button.setLocation(575, 545);
        panel.add(button);
        
        frame.setVisible(true);
    }
}