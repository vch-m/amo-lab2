package com.example.lab2_last;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BinaryInsertionSort {
    public static void main(String[] args)
    {
        new BinaryInsertionSort();
        List<Integer> nanoseconds = new ArrayList<Integer>();
    }
    public static String generation(int length){
        new BinaryInsertionSort();
        int[] arr = new int[length];randomFill(arr);
        String formattedString = Arrays.toString(arr)
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
        return (formattedString);

    }

    public static void randomFill(int[] array){
        Random rd = new Random(); // creating Random object
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(((999 - 0) + 1));
        }return;
    }


    public static int[] sort(int[] array,List<Integer> nanoseconds)
    {   long start = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            // Find location to insert using binary search
            int j = Math.abs (Arrays.binarySearch (array, 0, i, x) + 1);
            //Shifting array to one location right
            System.arraycopy (array, j, array, j + 1, i - j);
            //Placing element at its correct location
            array[j] = x;
        }
        long end = System.nanoTime();
        long traceTime = end-start;
        nanoseconds.add ((int) traceTime);
        System.out.printf("%d nanoseconds\n ", traceTime);
        return array;
    }
}

