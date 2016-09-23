package QuickSort;

import java.util.Random;

public class QuickSort {
    
    public int i = 0, j = 99, m = 49, a = 0, delay = 1, bingo = 0;
    public int[] array = new int[100];
    public int[] saveArray = new int[100];
    Random generator = new Random();
    
    MyPanel panel = new MyPanel();

    void initArray() {
        for (int k = 0; k < 100; k++){
            array[k] = generator.nextInt(90)+10;
            saveArray[k] = array[k];
        }
    }

    void printArray() {
        for (int k = 0; k < 100; k++)
            System.out.print(array[k] + " ");
        System.out.println();
    }

    void quickSort() throws InterruptedException {
        int startIndex = 0;
        int endIndex = 99;
        doSort(startIndex, endIndex);
    }

    void doSort(int start, int end) throws InterruptedException {
        if (start >= end) return;
        
        i = start;
        j = end;
        m = (i + j) / 2;
        while (i < j) {
            while ((array[i] <= array[m]) && i < m) {i++; a++; Thread.sleep(delay); Main.repaint();}
            while ((array[m] <= array[j]) && j > m) {j--; a++; Thread.sleep(delay); Main.repaint();}
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                Thread.sleep(delay);
                Main.repaint(); 
                a++;
                if (i == m) 
                    m = j;
                else if (j == m) 
                    m = i;
            }
        }
        doSort(start, m - 1);
        doSort(m + 1, end);
    }
    
    void checkArray() {
        for (int k = 0; k < 99; k++) 
            if (array[k] > array[k+1]) {
                System.out.println("Ошибка в " + (k+1) + " элементе");
                bingo = 1;
            }
        if (bingo == 0) {
            System.out.println("Сортировка выполнена успешно.");
            System.out.println("Было совершено " + a + " перестановок.");
            bingo = 2;
            Main.repaint();
        }
    }
}
