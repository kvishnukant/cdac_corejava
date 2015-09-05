package enums;

import java.util.Scanner;

enum Categories1 {
	BRKS, GEARS, LINES;
	}

public class EnumSwitch1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter category");
		Categories1 c = Categories1.valueOf(sc.next().toUpperCase());
		switch (c) {
		case BRKS:
			System.out.println("1");
			break;
		case GEARS:
			System.out.println("2");
			break;
		case LINES:
			System.out.println("3");
			break;
		}

	}

}
