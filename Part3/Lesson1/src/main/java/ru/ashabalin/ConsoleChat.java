package ru.ashabalin;

/**
 * @author Aleksei Shabalin on 01.11.2016.
 */

import java.io.*;

/**
 * Консольный чат. Пользователь вводит слово-фразу, программа берет случайную фразу
 * из текстового файла и выводит в ответ. Программа замолкает если пользователь вводит
 * слово «стоп» при этом он может продолжать отправлять сообщения в чат. Если пользователь
 * вводит слово «продолжить» , программа снова начинает отвечать. При вводе слова «закончить»
 * программа прекращает работу. Запись диалога включая, слова-команды стоп/продолжить/закончить
 * записывается в текстовый лог.
 */
public class ConsoleChat {
	private final String fileAnswer = "src\\main\\resources\\phrases.txt";
	private String nameLogChat = "nameLogChat.txt";
	private long[] phrase = new long[10];
	private int counter = 0;
	private boolean isComputerAnswer = true;
	private BufferedReader inReader;
	private BufferedWriter outWriter;
	private RandomAccessFile raf;
	private FileWriter fileWriter;

	public ConsoleChat(InputStream in, OutputStream out) throws UnsupportedEncodingException {
		this.inReader = new BufferedReader(new InputStreamReader(in));
		this.outWriter = new BufferedWriter(new OutputStreamWriter(out));

	}

	/**
	 * This method start Console Chat
	 * @throws IOException
	 */
	public void runChat() throws IOException {
		this.logWriter();
		String userMessage = "";

		while (!userMessage.toLowerCase().equals("закончить")) {
			userMessage = this.inReader.readLine();
			this.validatorWord(userMessage);
			if(this.isComputerAnswer == true && !userMessage.toLowerCase().equals("закончить")) {
				sendMessage("User", userMessage);
				this.answerBot();
			}else{
				sendMessage("User", userMessage);
			}
		}
		this.inReader.close();
		this.outWriter.flush();
		this.outWriter.close();
		this.raf.close();
		this.fileWriter.flush();
		this.fileWriter.close();
	}

	/**
	 * This method send message of computer for user
	 * @throws IOException
	 */
	private void answerBot() throws IOException {
		String answerMessage = "";

		try {
			this.raf = new RandomAccessFile(new File(fileAnswer).getAbsolutePath(), "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		phrase[counter++] = 0;
		while (this.raf.readLine() != null){
			phrase[counter++] = this.raf.getFilePointer();
		}
		if(counter > 0){
			raf.seek(this.phrase[(int) (Math.random() * (counter - 1))]);
			answerMessage = raf.readLine();
		}else{
			answerMessage = "I don`t know what tell";
		}
		this.sendMessage("Bot", answerMessage);
	}

	/**
	 * This method write log of Console Chat in
	 * user`s current working directory
	 * @throws IOException
	 */
	private void logWriter() throws IOException {
		File logFile= new File(String.format("%s%s%s", System.getProperty("user.dir"),
												File.separator, this.nameLogChat));
		if(!logFile.exists()){
			logFile.createNewFile();
		}
		this.fileWriter = new FileWriter(logFile);
	}

	/**
	 * This method send message
	 * @param name
	 * @param message
	 * @throws IOException
	 */
	private void sendMessage(String name, String message) throws IOException {
		outWriter.write(String.format("%s: %s%s", name, message,"\n"));
		outWriter.flush();
		fileWriter.write(String.format("%s: %s%s", name, message, "\n"));
		fileWriter.flush();
	}

	/**
	 * This method checks the words on a computer the ability to answer
	 */
	private boolean validatorWord(String inWord) {
		if(inWord.equals("стоп")) {
			isComputerAnswer = false;
		}
		if(inWord.equals("продолжить")) {
			isComputerAnswer = true;
		}
		return this.isComputerAnswer;
	}

}