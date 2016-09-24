package QuickSort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    
    static JFrame frame;
    static MyPanel panel;
    static int checkSort = 0;
    static int checkPause = 0;
    static QuickSort sort = new QuickSort();
    static JButton buttonPlay = new JButton();

    public static void main(String[] args) {
       
        sort.initArray();
        
        //создание окна
        frame = new JFrame("QuickSort"); 
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        //создание панели (background)
        panel = new MyPanel(sort);
        frame.add(panel);
        frame.setVisible(true);
        
        //button generate
        JButton button = new JButton("Generate");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sort.breakSort();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                sort.breakSortToggle = 0;
                checkSort = 0;
                sort.initArray();
                setDefaultValue();
                buttonPlay.setText("Sort");
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
        buttonPlay.setText("Sort");
        buttonPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (buttonPlay.getText().equals("Sort")) {
                    buttonPlay.setText("Pause");
                    checkSort = 1;
                    
                } else if (buttonPlay.getText().equals("Play")){
                    buttonPlay.setText("Pause");
                    checkPause = 0;
                } else {
                    buttonPlay.setText("Play");
                    checkPause = 1;
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
                sort.breakSort();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                sort.breakSortToggle = 0;
                checkSort = 0;
                System.arraycopy(sort.saveArray, 0, sort.array, 0, 100);
                setDefaultValue();
                buttonPlay.setText("Sort");
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
                sort.breakSort();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                sort.breakSortToggle = 0;
                checkSort = 0;
                setDefaultValue();
                int temp = sort.delay;
                sort.delay = 0;
                try {
                    sort.quickSort();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                sort.delay = temp;
            }
        });
        button.setSize(70, 30);
        button.setLocation(575, 545);
        panel.add(button);
        
        waiting();
    }
    
    static void repaint(){
        frame.repaint();
    }
    
    static void setDefaultValue(){
        sort.i = 0;
        sort.j = 99;
        sort.m = 49;
        sort.bingo = 0;
        sort.st = 0; 
        sort.en = 99;
        sort.delay = 512;
        checkPause = 0;
    }
    
    static void delay() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(sort.delay); 
        frame.repaint();
    }
    
    static void waiting() {
        try {
            if (checkSort == 1) {
                sort.quickSort();
                checkSort = 0;
            } else {
                TimeUnit.SECONDS.sleep(1);
                waiting();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        waiting();
    }
    
    static void pause() {
        try {
            if (checkPause == 1) {
                TimeUnit.SECONDS.sleep(1);
                pause();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}