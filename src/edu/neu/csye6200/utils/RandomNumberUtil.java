package edu.neu.csye6200.utils;

/**
 * Generate random numbers
 * @author Kaushik Gnanasekar
 *
 */
public class RandomNumberUtil {
	
	public static int generate(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}
