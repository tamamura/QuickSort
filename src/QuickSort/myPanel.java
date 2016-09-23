package QuickSort;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class myPanel extends JPanel {

    @Override
    public void paintComponent(Graphics gr) {
        
        
        for (int i = 0; i < 100; i++){
            gr.setColor(Color.GRAY);
            gr.fillRect(90 + i*8, 520 - 5 * QuickSort.array[i], 6, 5 * QuickSort.array[i]); 
            gr.setColor(Color.DARK_GRAY);
            gr.fillRect(90 + i*8, 520 - 5 * QuickSort.array[i], 6, 6); 
        }
        
        gr.setColor(Color.BLACK);
        gr.drawRect(0, 520, 899, 2);   //horizontal
        gr.drawRect(78, 0, 1, 519);    //vertical
        gr.drawRect(55, 20, 22, 1);    //100
        gr.drawString("100", 55, 33);
        gr.drawString("100", 56, 33);
        gr.drawRect(55, 145, 22, 1);   //75
        gr.drawString("75", 55, 158);
        gr.drawString("75", 56, 158);
        gr.drawRect(55, 270, 22, 1);   //50
        gr.drawString("50", 55, 283);
        gr.drawString("50", 56, 283);
        gr.drawRect(55, 395, 22, 1);   //25
        gr.drawString("25", 55, 408);
        gr.drawString("25", 56, 408);
    }
}
