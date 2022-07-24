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

    // print(arr);
    // selectionSort(arr, arr.length);
    // bubbleSort(arr, arr.length);
    // insertionSort(arr, arr.length);
    // mergeSort(arr, 0, arr.length-1);
    quickSort(arr, 0, arr.length - 1);
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
    if(l<r) {
      int mid = l+(r-l)/2;
      mergeSort(arr, l, mid);
      mergeSort(arr, mid+1, r);
      merge(arr, l, mid, r);
    }
  }

  static void merge(int[] arr, int l, int m, int r) {

    int n1 = m-l+1, n2 = r-m;

    int[] p = new int[n1];
    int[] q = new int[n2];

    for(int i=0;i<n1;i++) {
      p[i] = arr[l+i];
    }

    for(int i=0;i<n2;i++) {
      q[i] = arr[m+1+i];
    }

    int i=0,j=0,k=l;

    while(i < n1 && j < n2) {
      if(p[i] <= q[j]) {
        arr[k++] =  p[i++];
      } else {
        arr[k++] =  q[j++];
      }
    }

    while(i<n1) {
      arr[k++] =  p[i++];
    }

    while(j<n2) {
      arr[k++] =  q[j++];
    }
  }
  
  static void quickSort(int[] arr, int l, int r) {
    if(l<r) {
      int p = partition3(arr, l, r);

      quickSort(arr, l, p-1);
      quickSort(arr, p+1, r);
    }
  }

  static int partition1(int[] arr, int l, int r) {
    int pivot = arr[r];
    int i = l, j = l;

    while(j < r) {
      if(arr[j] <= pivot) {
        swap(arr, i, j);
        i++;
        print(arr);
      }
      j++;
    }
    swap(arr, i, r);
    return i;
  }

  static int partition2(int[] arr, int l, int r) {
    int pivot = arr[l];
    int i = l + 1, j = l + 1;

    while(j <= r) {
      if(arr[j] <= pivot) {
        swap(arr, i++, j);
        print(arr);
      }
      j++;
    }
    swap(arr, i-1, l);
    return i-1;
  }

  static int partition3(int[] arr, int l, int r) {
    int pivot = arr[l];
    int i = l, j = r;

    while(i < j) {
      while(i<r && arr[i] <= pivot) {
        i++;
      }
      while(j>=l && arr[j] > pivot) {
        j--;
      }
      if(i<j) swap(arr, i, j);
    }
    swap(arr, l, j);
    return j;
  }
}