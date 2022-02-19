import integerlist.IntegerList;
import integerlist.IntegerListImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        IntegerList integerList = new IntegerListImpl();
        integerList.add(15);
        integerList.add(5);
        integerList.add(86);
        integerList.add(1);
        integerList.add(19);
        integerList.add(34);
        System.out.println(Arrays.toString(integerList.toArray()));
        System.out.println(integerList.contains(5));
        System.out.println(Arrays.toString(integerList.toArray()));

        Integer[] arr = generateRandomArray();
        Integer[] arr2 = arr.clone();
        Integer[] arr3 = arr.clone();


        long start = System.currentTimeMillis();
        sortBubble(arr);
        System.out.println("Bubble sort time " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.println("Selection sort time " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println("Insertion sort time " + (System.currentTimeMillis() - start3));
    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }



}
