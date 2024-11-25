import java.io.*;
import java.util.*;
public class RadixSort {
    public int getMax(int array[],int size){
        int max = array[0];
        for (int i = 1; i < size; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
    public void countSort(int array[],int exp,int size){
        int output[] = new int[size]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < size; i++)
            count[(array[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = size - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < size; i++)
            array[i] = output[i];
    }

    public void radixSort(int array[],int size){
        int m = getMax(array, size);


        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(array, size, exp);
    }
    public void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }


}
