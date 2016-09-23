
package QuickSort;

import java.util.Random;

public class QuickSort {
    
    static int arrLenght = 100;
    static int i, j, m, a = 0, delay = 0;
    static int[] array = new int[arrLenght];
    static Random generator = new Random();

    static void initArray() {
        for (int k = 0; k < arrLenght; k++)
            array[k] = generator.nextInt(90)+10;
    }

    static void printArray() {
        for (int k = 0; k < arrLenght; k++)
            System.out.print(array[k] + " ");
        System.out.println();
    }

    static void quickSort() throws InterruptedException {
        int startIndex = 0;
        int endIndex = arrLenght - 1;
        doSort(startIndex, endIndex);
    }

    static void doSort(int start, int end) throws InterruptedException {
        if (start >= end) return;
        
        i = start;
        j = end;
        m = (i + j) / 2;
        while (i < j) {
            while ((array[i] <= array[m]) && i < m) {i++; a++; Thread.sleep(delay);}
            while ((array[m] <= array[j]) && j > m) {j--; a++; Thread.sleep(delay);}
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                Thread.sleep(delay);
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
    
    static void checkArray() {
        int bingo = 0;
        for (int k = 0; k < arrLenght - 1; k++) 
            if (array[k] > array[k+1]) {
                System.out.println("Ошибка в " + (k+1) + " элементе");
                bingo = 1;
            }
        if (bingo == 0) {
            System.out.println("Сортировка выполнена успешно.");
            System.out.println("Было совершено " + a + " перестановок.");
        }
    }
}
