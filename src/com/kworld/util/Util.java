package com.kworld.util;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Util {
	private Util() { }
	
	public static final Logger logger = Logger.getLogger("apps");

	static {
		logger.setLevel(Level.ALL);
		ConsoleHandler handler = new java.util.logging.ConsoleHandler();
		handler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record) {
				return record.getMessage();
			}
		});
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
	}
	
    public static final Scanner scanner = new Scanner(System.in);

    public static void swapValues(Comparable [] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
