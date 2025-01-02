package com.exercise.programs.leetCodePrograms;

import java.util.Arrays;

public class LeetCodeProgram {
    public static void main(String[] args) {
        int[] array1 = {12, 32, 43, 6, 78, 46, 34, 778, 97, 57, 6, 9, 54, 33, 54, 97};
        System.out.println("1. Rotate the array from given index number");
        rotateArrayFromGivenIndex(array1, 6);

    }

    private static void rotateArrayFromGivenIndex(int[] array, int index) {
        int[] newRotatedArray = new int[array.length];
        int rotateIndex = 0;

        for (int i = index; i < array.length; i++) {
            newRotatedArray[rotateIndex++] = array[i];
        }
        for (int i = 0; i < index; i++) {
            newRotatedArray[rotateIndex++] = array[i];
        }
        System.out.println("Before Rotating array : \n" + Arrays.toString(array));
        System.out.println("After rotating from index : " + index + "\n" + Arrays.toString(newRotatedArray));
    }
}
