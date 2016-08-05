package ru.ashabalin.start;

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
}