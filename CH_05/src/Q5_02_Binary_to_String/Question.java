package Q5_02_Binary_to_String;

import java.util.function.BinaryOperator;

public class Question {
	public static String printBinary(double num) {
		if (num >=1 || num < 0) {
			return "ERROR";
		}
		
		StringBuilder binaryBuilder = new StringBuilder();
		binaryBuilder.append(".");
		while(num > 0) {
			if (binaryBuilder.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binaryBuilder.append("1");
				num = r - 1;
			} else {
				binaryBuilder.append("0");
				num = r;
			}
		}
		return binaryBuilder.toString();
	}
	
	public static String printBinary2(double num) {
		if (num >=1 || num < 0) {
			return "ERROR";
		}
		
		StringBuilder builder = new StringBuilder();
		
		while(num > 0) {
			if(builder.length() > 32) {
				return "ERROR";
			}
			if (num >= 0.5) {
				builder.append("1");
				num -= 0.5;
				num *= 2;
			} else {
				builder.append("0");
				num *= 2;
			}
		}
		return builder.toString();
	}	
	
	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			String binary2 = printBinary2(num);
			if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary + " " + binary2);
			}
		}
	}
}
