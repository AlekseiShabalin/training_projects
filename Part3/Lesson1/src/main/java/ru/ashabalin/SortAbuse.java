package ru.ashabalin;

import java.io.*;

/**
 * @author Aleksei Shabalin on 10.10.2016.
 */
public class SortAbuse {
//	private char[] tempInChar = new char[10];
	private char inChar;
	private int counter = 0;

	public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
		InputStreamReader inReader = new InputStreamReader(in);
		OutputStreamWriter outWriter = new OutputStreamWriter(out);
		boolean matchWord = false;
		int symbol = inReader.read();
		while (symbol != -1){
			inChar = (char) symbol;
			symbol = inReader.read();
		}
		inReader.close();

		String tempString = String.valueOf(inChar);

		for (int i = 0; i < abuse.length; i++) {
			if (abuse[i].equals(tempString)) {
				matchWord = true;
				break;
			}
		}

		if(matchWord == true){
			System.out.println("You entered an invalid word!");
		}else {
			System.out.println(tempString);
		}


//		Scanner inReader = new Scanner(in);
//		PrintStream outWriter = new PrintStream(out);
//		boolean matchWord = false;
//		String inWord = inReader.next();
//
//		for (int i = 0; i < abuse.length; i++) {
//				if (abuse[i].equals(inWord)) {
//					matchWord = true;
//					break;
//				}
//			}
//
//		if(matchWord == true){
//			outWriter.println("You entered an invalid word!");
//		}else {
//			outWriter.println(inWord);
//		}
//
//		inReader.close();
//		outWriter.close();
	}


	public static void main(String[] args) throws IOException {

		DataInputStream inReader = new DataInputStream(System.in);
		DataOutputStream outWriter = new DataOutputStream(System.out);
		String[] testAbuse = {"One", "Two", "Three"};

		SortAbuse abuse = new SortAbuse();
		abuse.dropAbuses(inReader, outWriter, testAbuse);
	}
}
