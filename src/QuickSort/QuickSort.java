package QuickSort;

import java.util.Random;

public class QuickSort {
    
    public int i = 0, j = 99, m = 49, bingo = 0, delay = 128, st = 0, en = 99;
    static int breakSortToggle = 0;
    public int[] array = new int[100];
    public int[] saveArray = new int[100];
    Random generator = new Random();

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

    void quickSort() throws InterruptedException{
        int startIndex = 0;
        int endIndex = 99;
        doSort(startIndex, endIndex);
        checkArray();
    }

    void doSort(int start, int end) throws InterruptedException {
        if (start >= end) return;
        if (breakSortToggle == 1) return;
        
        st = start;
        en = end;
        i = start;
        j = end;
        m = (i + j) / 2;
        while (i < j) {
            while ((array[i] <= array[m]) && i < m) {i++; Main.delay(); Main.pause(); if (breakSortToggle == 1) return;}
            while ((array[m] <= array[j]) && j > m) {j--; Main.delay(); Main.pause(); if (breakSortToggle == 1) return;}
            if (i < j) {
                if (breakSortToggle == 1) return;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                Main.delay();
                Main.pause();
                if (i == m) 
                    m = j;
                else if (j == m) 
                    m = i;
            } if (breakSortToggle == 1) return;
        }
        if (breakSortToggle == 1) return;
        doSort(start, m - 1);
        doSort(m + 1, end);
        breakSortToggle = 0;
        Main.checkSort = 0;
    }
    
    void checkArray() {
        for (int k = 0; k < 99; k++) {
            if (array[k] > array[k + 1]) {
                bingo = 1;
                break;
            }
        }
        if (bingo == 0) {
            System.out.println("Сортировка выполнена успешно.");
            bingo = 2;
            Main.repaint();
        } else if (bingo == 1) {
            System.out.println("Сортировка выполнена не корректно");
        } else {
            System.out.println("Исключительная ситуация. Надо проверить код.");
        }
    }
    
    void breakSort(){
        breakSortToggle = 1;
    }
}
