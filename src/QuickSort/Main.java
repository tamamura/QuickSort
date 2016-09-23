package QuickSort;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    
    static JFrame frame;
    static QuickSort sort;
    static int oldDelay;

    public static void main(String[] args) {
        
        // play/pause не меняется без "final"
        final String play = "Play";
        final String pause = "Pause";
        final JButton buttonStart = new JButton("Start sorting");
        buttonStart.setVisible(true);
        
        sort = new QuickSort();
        sort.initArray();
        sort.printArray();
        oldDelay = sort.delay;
        
        //создание окна
        frame = new JFrame("QuickSort"); 
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        //создание панели (background)
        MyPanel panel = new MyPanel(sort);
        frame.add(panel);
        
        //button generate
        JButton button = new JButton("Generate");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sort.initArray();
                sort.printArray();
                setDefaultValue();
                buttonStart.setVisible(true);
                repaint();
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
        buttonPlay.setText("Pause");
        play();
        buttonPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (buttonPlay.getText().equals(play)){
                    buttonPlay.setText(pause);
                    play();
                } else {
                    buttonPlay.setText(play);
                    pause();
                }
            }
        });
        buttonPlay.setSize(70, 30);
        buttonPlay.setLocation(415, 545);
        panel.add(buttonPlay);
        
        //button x0.5
        button = new JButton("x0.5");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sort.delay = sort.delay * 2;
            }
        });
        button.setSize(60, 30);
        button.setLocation(340, 545);
        panel.add(button);
        
        //button x2.0
        button = new JButton("x2.0");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sort.delay = sort.delay / 2;
            }
        });
        button.setSize(60, 30);
        button.setLocation(500, 545);
        panel.add(button);
        
        //button start
        button = new JButton("Start");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                start();
                setDefaultValue();
                repaint();
            }
        });
        button.setSize(70, 30);
        button.setLocation(255, 545);
        panel.add(button);
        
        //button finish
        button = new JButton("Finish");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                start();
                setDefaultValue();
                sort.delay = 0;
                buttonStart.setVisible(false);
                try {
                    sort.quickSort();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                sort.printArray();
                sort.checkArray();
                repaint();
            }
        });
        button.setSize(70, 30);
        button.setLocation(575, 545);
        panel.add(button);
        
        //button start sorting
        buttonStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonStart.setVisible(false);
                try {
                    sort.quickSort();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                sort.printArray();
                sort.checkArray();
                repaint();
            }
        });
        buttonStart.setSize(200, 50);
        buttonStart.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonStart.setLocation(350, 235);
        panel.add(buttonStart);
        
        frame.setVisible(true);
    }
    static void repaint(){
        frame.repaint();
    }
    static void pause(){
        oldDelay = sort.delay;
        sort.delay = 1000000;
    }
    static void play(){
        sort.delay = oldDelay;
    }
    static void start(){
        System.arraycopy(sort.saveArray, 0, sort.array, 0, 100);
    }
    static void setDefaultValue(){
        sort.i = 0;
        sort.j = 99;
        sort.m = 49;
        sort.a = 0;
        sort.bingo = 0;
    }
}