
public class Main {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 1, 2, 6, 4};
        int n=array.length;


        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(array, n);
        bs.printArray(array, n);

    }
}