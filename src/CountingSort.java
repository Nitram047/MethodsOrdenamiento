public class CountingSort {
    public int[] countSort(int[] input){
        int n=input.length;
        int m=0;
        for(int i=0;i<n;i++){
            m=Math.max(m,input[i]);
        }

        int[] count=new int[m+1];

        for(int i=0; i<n; i++){
            count[input[i]]++;
        }
        for(int i=1;i<m;i++){
            count[i]+=count[i-1];
        }
        int[] output=new int[n];
        for(int i=n-1;i>=0;i--){
            output[count[input[i]]-1]=input[i];
            count[input[i]]--;
        }
        return output;
    }
}
