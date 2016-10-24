package ru.ashabalin;

import java.io.*;

/**
 * @author Aleksei Shabalin on 10.10.2016.
 */

/**
 * Delete abuse word
 */
public class SortAbuse {

	public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
		InputStreamReader inReader = new InputStreamReader(in);
		OutputStreamWriter outWriter = new OutputStreamWriter(out);
		StringBuilder inString = new StringBuilder();
		int tempChar;
		int counter = 0;

		while((tempChar = inReader.read()) != -1){
			inString.append((char) tempChar);

			for(String abuseWord : abuse) {
				for (String s : inString.toString().split(" ")) {
					if(abuseWord.toUpperCase().equals(s.toUpperCase())){
						inString.delete(0, inString.length());
					}else if(abuseWord.toUpperCase().startsWith(s.toUpperCase())){
						counter++;
					}
				}
			}

			if(counter == 0){
				outWriter.write(inString.toString());
				inString.delete(0, inString.length());
			}
			counter = 0;
			outWriter.flush();
		}

		inReader.close();
		outWriter.close();
	}
}
