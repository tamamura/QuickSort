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
        
        //отрисовка области
        if (sort.bingo != 2) {
        gr.setColor(new Color(0xCCCCCC));
        gr.fillRect(89 + sort.st * 8, 0, (sort.en - sort.st + 1) * 8, 520);
        }
        
        for (int i = 0; i < 100; i++){
            
            //отрисовка столбцов
            gr.setColor(Color.GRAY);
            gr.fillRect(90 + i*8, 520 - 5 * sort.array[i], 6, 5 * sort.array[i]); 
            
            //точечки сверху
            gr.setColor(Color.DARK_GRAY);
            gr.fillRect(90 + i*8, 520 - 5 * sort.array[i], 6, 6); 
            
            if (sort.bingo != 2) {
                //элемент "i"
                if (sort.array[sort.i] > sort.array[sort.m]) gr.setColor(new Color(0xDD2222));
                else  gr.setColor(new Color(0x22DD22));
                gr.fillRect(90 + sort.i*8, 520 - 5 * sort.array[sort.i] + 6, 6, 5 * sort.array[sort.i] - 6); 
            
                //элемент "j"
                if (sort.array[sort.j] < sort.array[sort.m]) gr.setColor(new Color(0xDD2222));
                else gr.setColor(new Color(0x22DD22));
                gr.fillRect(90 + sort.j*8, 520 - 5 * sort.array[sort.j] + 6, 6, 5 * sort.array[sort.j] - 6);
            
                //точка опоры "m"
                gr.setColor(new Color(0x2222DD));
                gr.fillRect(90 + sort.m*8, 520 - 5 * sort.array[sort.m] + 6, 6, 5 * sort.array[sort.m] - 6);
                gr.fillRect(89 + sort.st * 8, 520 - 5 * sort.array[sort.m], (sort.en - sort.st + 1) * 8, 1);
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
