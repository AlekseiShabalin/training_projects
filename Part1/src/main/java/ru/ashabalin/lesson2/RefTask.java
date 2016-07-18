package ru.ashabalin.lesson2;

//ѕосмотрите данный код и ответьте на вопросы.
	
	public class RefTask {

	public static void main(String[] args) {
	// создаетс€ и инициализируетс€ переменна€ value значеинием 1
	Integer value = 1;
	// value передаетс€ в метод change и выполн€етс€ инкремент 
	RefTask.change(value);
	// переменна€ value передаетс€ в поток вывода, на консоль выводитс€ 1.
	System.out.println(value);
	
	}
	
	// нужно изменить publib на public
	public static void change(Integer value) {
	
	value++;
	
	}

	// добавл€ем закрывающуюс€ фигурную скобку
	}
	
	//„то будет выведено на консоль и почему?
	// ¬ отличие от примера ChangeState здесь нет статической переменной, котора€ пренадлежит классу.
	// ѕри вызове метода processClaim переменной присваиваетс€ значение "task".
