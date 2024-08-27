package com.dansam0;

import com.dansam0.Classes.Window;

public class Main {
    public static void main(String[] args) {

        Window window = new Window();
        window.setVisible(true);
        /*int[] pizzdec = new int[10000000];
        for (int i = 0; i < pizzdec.length; i++){
            pizzdec[i] = i;
        }

        binarySearch(1, pizzdec);*/
        
    }

    public static int binarySearch(int searchValue, int[] array){
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while(lowIndex <= highIndex){
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            int value = array[middleIndex];

            System.out.println("Middle: " + value);

            if(value < searchValue) lowIndex = middleIndex + 1;
            else if (value > searchValue) highIndex = middleIndex - 1;
            else return middleIndex;
        }
        return -1;
    }
}