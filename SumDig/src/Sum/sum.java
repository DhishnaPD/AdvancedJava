package Sum;
import java.util.Scanner;
public class sum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = scanner.nextInt();
		int digit =0, sum =0;
		while(number > 0) {
		digit = number % 10;
		number = number / 10;
		sum = sum + digit;

System.out.println("The sum of digits is : "+sum);
scanner.close();
}
}

}
