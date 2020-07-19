import java.util.Scanner;
import java.util.Arrays;

public class mthlargest {
    static int[] delete(int[] arr, int target) {
        int n = arr.length;
        int[] newArr = new int[n-1];
        int targetIndex = -1;
        for (int i=0;i<n;i++){
            if (arr[i]==target) {
                targetIndex=i;
            }
        }
        if (targetIndex!=-1) {
            for (int i=0;i<targetIndex;i++){
                newArr[i]=arr[i];
            }
            for (int i=targetIndex;i<newArr.length;i++){
                newArr[i]=arr[i+1];
            }
            return delete(newArr, target);   
        }
        else return arr;
    }
    static int[] removeDupes(int[] arr){
        int[] temp = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            if (present(temp, arr[i])){
                continue;
            } else {
                temp[i]=arr[i];
            }
        }
        temp = delete(temp, 0);

        return temp;
    }
    static boolean present(int [] arr, int x){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==x){
                return true;
            }
        }
        return false;
    }
    static int findMth(int[] arr, int m){
        Arrays.sort(arr);
        return arr[arr.length-m];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("n>> ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array>> ");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("m>> ");
        int m = sc.nextInt();
        int[] newArr = removeDupes(arr);
        int num = findMth(newArr, m);
        System.out.println(m + "th largest number in array is: " + num);
    }
}
