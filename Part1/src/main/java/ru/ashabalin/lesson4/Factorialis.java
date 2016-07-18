package ru.ashabalin.lesson4;

public class Factorialis{
	
	public int x;
	//int factorial;
	
	public double calc(int x){
		this.x = x;
		int count = 0;
		double factorial = 1;
		if(x < 0){
			System.out.printf("%s%n", "You entered a negative number");
		}else{if(x == 0){
				//System.out.printf("%s%n", "0! = 1");
				
				}else{
					while(count < x){
						count++;
						factorial = count * factorial;
						}
					}
			}
		return factorial;
	}

	public static void main(String[] args){
		
		int a = Integer.valueOf(args[0]);

		Factorialis fact = new Factorialis();
		System.out.printf("Factorial %d is %.0f", a, fact.calc(a));

	}

}