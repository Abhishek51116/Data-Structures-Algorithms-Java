import java.util.Scanner;

public class insert {
    static Scanner sc = new Scanner(System.in);
    static int[] createArray() {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    static int[] insertAt(int[] arr, int index, int value){
        int n = arr.length;
        int[] newArr = new int[arr.length+1];
        for (int i=n-1;i>=index;i--){
            newArr[i+1] = arr[i];
        }
        n = n+1;
        newArr[index] = value;
        for (int i=index-1;i>=0;i--){
            newArr[i] = arr[i];
        }
        return newArr;
    }
    static void printArray(int[] arr){
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int [] arr = createArray();
        int index = sc.nextInt();
        int value = sc.nextInt();
        arr = insertAt(arr, index, value);
        printArray(arr);
    }
}
