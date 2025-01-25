package Fib;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibnew {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the limit");
	int limit = Integer.parseInt(reader.readLine());
	long firstNumber = 0;
	long secondNumber = 1;
	System.out.println(firstNumber);
	System.out.println(secondNumber);
	long sum = 0;
	while(limit > 0) {
	sum = firstNumber + secondNumber;
	System.out.println(sum);
	firstNumber = secondNumber;
	secondNumber = sum;
	limit--;
	}
	reader.close();
	}
	}