package ru.ashabalin.start;

/**
 * Created by Aleksei Shabalin.
 */
 
public class StubInput implements IO {
	private String[] answers;
	private int position = 0;
	private StringBuilder out = new StringBuilder();
	
	public StubInput(String[] answers) {
		this.answers = answers;
	}
	
	public String ask(String question) {
		return answers[position++];
	}
	
	public void println(Object value) {
	this.out.append(value).append("\n");
	}
	
	public String getOut() {
		return this.out.toString();
	}
	
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if(exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range.");
		}
	}
}