package ru.ashabalin.lesson2;

//���������� ������ ��� � �������� �� �������.
	
	public class RefTask {

	public static void main(String[] args) {
	// ��������� � ���������������� ���������� value ���������� 1
	Integer value = 1;
	// value ���������� � ����� change � ����������� ��������� 
	RefTask.change(value);
	// ���������� value ���������� � ����� ������, �� ������� ��������� 1.
	System.out.println(value);
	
	}
	
	// ����� �������� publib �� public
	public static void change(Integer value) {
	
	value++;
	
	}

	// ��������� ������������� �������� ������
	}
	
	//��� ����� �������� �� ������� � ������?
	// � ������� �� ������� ChangeState ����� ��� ����������� ����������, ������� ����������� ������.
	// ��� ������ ������ processClaim ���������� ������������� �������� "task".
