package edu.neu.csye6200.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * File Util
 * @author Kaushik Gnanasekar
 *
 */
public class FileUtil {
	
	String inputFilename;
	
	/** 
	 *  Read file utility
	 * **/
	public static List<String> readFile(String inputFilename) {
		System.out.println("Reading from file: " + inputFilename);
		String thisLine = null;
		List<String> fileList = new ArrayList<String>();
		try (  // open input stream from input file for reading purpose.
			FileReader fr = new FileReader(inputFilename);
			BufferedReader in = new BufferedReader(fr);   )  {
			System.out.println("BufferedReader: '" + inputFilename + "");
			while ((thisLine = in.readLine()) != null) {
				fileList.add(thisLine);
			}
			in.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return fileList;
	}
	
	/** 
	 *  Write file utility
	 * **/
	public static void writeToFile(String fileName, List<String> list) {
		try (
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter out= new BufferedWriter(fw);  
		) {
			for (int i = 0; i<list.size(); i++) {
				out.write(list.get(i));
				out.newLine();
			}
			System.out.println("Successfully written to file: " + fileName);
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}