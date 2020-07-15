import java.util.Scanner;
public class fragments {
    static int[] ksum(int[] arr, int k){
        int[] sumarray = new int[arr.length-k+1];
        for (int i=0;i<sumarray.length;i++){
            sumarray[i] = 0;
        }
        for (int i=0;i<=(arr.length-k);i++){
            for (int j=i;j<(i+k);j++){
                sumarray[i] += arr[j];
            }
        }
        System.out.println("Sum of fragments having " + k + " elements each:");
        for (int i=0;i<sumarray.length;i++)
            System.out.print(sumarray[i]+" ");
        System.out.println();
        return sumarray;
    }
    static int max(int[] a){
        int max=-1;
        int maxIndex=0;
        for (int i=0;i<a.length;i++){
            if (a[i]>max){
                max=a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] sarr = ksum(arr,k);
        int msi = max(sarr);
        int[] karr = new int[k];
        int j = 0;
        for (int i=msi;i<msi+k;i++){
            karr[j]=arr[i];
            j++;
        }
        System.out.println(k + " elements with max sum are:");
        for (int i=0;i<k;i++){
            System.out.print(karr[i] + " ");
        }
        sc.close();
    }
}
