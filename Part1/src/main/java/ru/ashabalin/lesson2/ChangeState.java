package ru.ashabalin.lesson2;

//Посмотрите данный код и ответьте на вопросы.
	public class ChangeState {
	public static class Claim {
	public String name;
	}

	public static void main(String[] args) {
	// создаемтся объект типа Claim
	Claim claim = new Claim();
	//пременной name  присваивается значение "bug"
	claim.name = "bug";
	// метод processClaim переопределяет значение переменной name на "task"
	processClaim(claim);
	// в поток вывода передается переменная со значением "task"
	// на консоле выводится "task"
	System.out.println(claim.name);
	}

	private static void processClaim(Claim value) {
	value.name = "task";
	}
	}
	
/*	Сколько объектов класс Сlaim создано?
	
	Что будет выведенно на консоль?*/

// Создан будет один объект классаа Claim. Переменной name присваивается значение "bug", вызывается приватный статичный
//  метод processClaim, который инициализирует переменную name  значением "task".
