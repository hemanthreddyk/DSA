import java.io.*;
import java.util.*;

class Sort {
  static BufferedReader br;

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the array to sort: ");
    String[] input = br.readLine().split("\\s");

    int[] arr = new int[input.length];

    for(int i=0;i<input.length;i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    print(arr);
    // selectionSort(arr, arr.length);
    // bubbleSort(arr, arr.length);
    insertionSort(arr, arr.length);
    print(arr);
    
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void print(int[] arr) {
    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  static void selectionSort(int[] arr, int n) {
    for(int i=0;i<n-1;i++) {
      int low_idx = i;
      for(int j=i+1;j<n;j++) {
        if(arr[j] < arr[low_idx]) {
          low_idx = j;
        }
      }
      if(low_idx != i)swap(arr, i, low_idx);
    }
  }

  static void bubbleSort(int[] arr, int n) {
    for(int i=0;i<n-1;i++) {
      boolean isSwapped = false;
      for(int j=i;j<n;j++) {
        if(arr[j] < arr[i]) {
          isSwapped = true;
          swap(arr, i, j);
        }
      }
      if(!isSwapped) {
        System.out.println("Already Sorted");
        return;
      }
    }
  }

  static void insertionSort(int[] arr, int n) {
    for(int i=1;i<n;i++) {
      int curEle = arr[i];
      int j = i-1;
      for(; j>=0; j--) {
        if(arr[j] > curEle) {
          arr[j+1] = arr[j];
        } else {
          break;
        }
      }
      arr[j+1] = curEle;
    }
  }

  static void mergeSort(int[] arr, int l, int r) {
    
  }
  
}