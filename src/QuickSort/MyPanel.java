package QuickSort;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
    
    QuickSort sort;
            
    MyPanel(){
    }
    
    MyPanel(QuickSort sort){
        this.sort = sort;
    }
    
    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setLayout(LayoutManager lm) {
        super.setLayout(null); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paintComponent(Graphics gr) {
        
        
        for (int i = 0; i < 100; i++){
            
            //отрисовка столбцов
            gr.setColor(Color.GRAY);
            gr.fillRect(90 + i*8, 520 - 5 * sort.array[i], 6, 5 * sort.array[i]); 
            
            //точечки сверху
            gr.setColor(Color.DARK_GRAY);
            gr.fillRect(90 + i*8, 520 - 5 * sort.array[i], 6, 6); 
            
            if (sort.bingo != 2) {
                //элемент "i"
                if (sort.array[sort.i] > sort.array[sort.m]) gr.setColor(Color.RED);
                else  gr.setColor(Color.GREEN);
                gr.fillRect(90 + sort.i*8, 520 - 5 * sort.array[sort.i] + 6, 6, 5 * sort.array[sort.i] - 6); 
            
                //элемент "j"
                if (sort.array[sort.j] < sort.array[sort.m]) gr.setColor(Color.RED);
                else gr.setColor(Color.GREEN);
                gr.fillRect(90 + sort.j*8, 520 - 5 * sort.array[sort.j] + 6, 6, 5 * sort.array[sort.j] - 6);
            
                //точка опоры "m"
                gr.setColor(Color.BLUE);
                gr.fillRect(90 + sort.m*8, 520 - 5 * sort.array[sort.m] + 6, 6, 5 * sort.array[sort.m] - 6);
                gr.fillRect(80, 520 - 5 * sort.array[sort.m], 820, 1);
            }
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
