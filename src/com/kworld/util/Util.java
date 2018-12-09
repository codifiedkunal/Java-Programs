package com.kworld.util;

import java.util.Scanner;
import java.util.logging.Logger;

public class Util {
	private Util() { }
	
    public static final Scanner scanner = new Scanner(System.in);

    public static final Logger log = Logger.getLogger("Util");
    
    public static void swapValues(Comparable [] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
