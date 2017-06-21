package dell.lead.aula2;

import java.util.Scanner;

public class Class {

	public static void main(String[] args) {
		digitaValor();
	}

	public static void digitaValor() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite um valor: ");

		try {
			double valor = scanner.nextDouble();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Valor nao permitido, digite novamente por favor.");
			digitaValor();
		}
	}

}