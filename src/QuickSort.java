public class QuickSort {
    public int partition(int[] array,int low,int high){
        // Choose the pivot
        int pivot = array[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(array, i + 1, high);
        return i + 1;
    }
    public void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void quickSort(int[] array,int low,int high){
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(array, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
}
