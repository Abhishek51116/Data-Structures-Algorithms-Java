import java.util.Scanner;

public class frequencysort {
    static int maxIndex(int[] a){
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
    static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.print("]");    
    }
    static void fsort(int[] arr){
        int[] freqp = new int[10];
        int[] freqn = new int[10];
        int[] temp = new int[arr.length];
        int mpi,mni,mi,m,index;
        int x=0;
        for (int i=0;i<10;i++){
            freqn[i]=0;
            freqp[i]=0;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]<0){
                freqn[0-arr[i]]+=1;
            } else {
                freqp[arr[i]]+=1;
            }
        }
        
        
        for (int i=20;i>=0;i--){
            mpi = maxIndex(freqp);
            mni = maxIndex(freqn);
            if (freqp[mpi]>freqn[mni]){
                mi = mpi;
                m = 1;
                index = freqp[mi];
            } else {
                mi = mni;
                m = -1;
                index = freqn[mi];
            }
            if (freqn[mni]==0&&freqp[mpi]==0){
                break;
            }
            
            for (int j=0;j<index;j++){
                temp[x]=m*mi;
                x++;
            }


            if (m==1){
                freqp[maxIndex(freqp)]=0;
            } else {
                freqn[maxIndex(freqn)]=0;
            }
            
        }
            for (int i=0;i<arr.length;i++){
                arr[i]=temp[i];
            }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        fsort(arr);
        printArray(arr);
    }
}
