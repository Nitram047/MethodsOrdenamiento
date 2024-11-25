import java.util.ArrayList;
import java.util.List;
public class BucketSort {
    public void insertionSort(List<Float>bucket){
        for(int i=1;i<bucket.size();i++){
            float key=bucket.get(i);
            int j=i-1;
            while(j>=0 && bucket.get(j)>key){
                bucket.set(j+1,bucket.get(j));
                j--;
            }
            bucket.set(j+1,key);
        }
    }
    public void bucketSort(float arr[]){
        int n = arr.length;

        // 1) Create n empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        // 3) Sort individual buckets using insertion sort
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
