import java.util.Scanner;

public class arrayOperations {
    static Scanner sc = new Scanner(System.in);
    static int[] createArray() {
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n +  "numbers: ");
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    static int[] insertAt(int[] arr, int index, int value){
        int n = arr.length;
        int[] newArr = new int[n+1];
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

    static int[] insertBefore(int[] arr, int target, int value) {
        int n = arr.length;
        int[] newArr = new int[n+1];
        int targetIndex = -1;
        for (int i=0;i<n;i++){
            if (arr[i]==target) {
                targetIndex=i;
            }
        }
        for (int i=0;i<targetIndex;i++){
            newArr[i]=arr[i];
        }
        newArr[targetIndex]=value;
        for (int i=targetIndex+1;i<newArr.length;i++){
            newArr[i]=arr[i-1];
        }
        return newArr;
    }
    
    static int[] insertAfter(int[] arr, int target, int value) {
        int n = arr.length;
        int[] newArr = new int[n+1];
        int targetIndex = -1;
        for (int i=0;i<n;i++){
            if (arr[i]==target) {
                targetIndex=i;
            }
        }
        for (int i=0;i<=targetIndex;i++){
            newArr[i]=arr[i];
        }
        newArr[targetIndex+1]=value;
        for (int i=targetIndex+2;i<newArr.length;i++){
            newArr[i]=arr[i-1];
        }
        return newArr;
    }
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
    
    static int[] deleteAt(int[] arr, int index) {
        int n = arr.length;
        int[] newArr = new int[n-1];
        for (int i=0;i<index;i++){
            newArr[i]=arr[i];
        }
        for (int i=index;i<newArr.length;i++){
            newArr[i]=arr[i+1];
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
        int index, target, value;
        System.out.println("Choose an operation: \n1. Insert At\n2. Insert Before\n3. Insert After\n4. Delete\n5. Delete At");
        int option = sc.nextInt();
        if (option>5&&option<1){
            System.out.print("Invalid Option!");
            return;
        }
        switch (option) {
            case 1:
                index = sc.nextInt();
                value = sc.nextInt();
                arr = insertAt(arr, index, value);
                break;
            case 2:
                target = sc.nextInt();
                value = sc.nextInt();
                arr = insertBefore(arr, target, value);
                break;
            case 3:
                target = sc.nextInt();
                value = sc.nextInt();
                arr = insertAfter(arr, target, value);
                break;
            case 4:
                target = sc.nextInt();
                arr = delete(arr, target);
                break;
            case 5:
                index = sc.nextInt();
                arr = deleteAt(arr, index);
                break;    
        }
        printArray(arr);
    }
}
