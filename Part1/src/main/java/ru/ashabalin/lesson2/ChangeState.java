package ru.ashabalin.lesson2;

//���������� ������ ��� � �������� �� �������.
	public class ChangeState {
	public static class Claim {
	public String name;
	}

	public static void main(String[] args) {
	// ���������� ������ ���� Claim
	Claim claim = new Claim();
	//��������� name  ������������� �������� "bug"
	claim.name = "bug";
	// ����� processClaim �������������� �������� ���������� name �� "task"
	processClaim(claim);
	// � ����� ������ ���������� ���������� �� ��������� "task"
	// �� ������� ��������� "task"
	System.out.println(claim.name);
	}

	private static void processClaim(Claim value) {
	value.name = "task";
	}
	}
	
/*	������� �������� ����� �laim �������?
	
	��� ����� ��������� �� �������?*/

// ������ ����� ���� ������ ������� Claim. ���������� name ������������� �������� "bug", ���������� ��������� ���������
//  ����� processClaim, ������� �������������� ���������� name  ��������� "task".
