import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		System.out.println(factorial(n));
		
	}
	
	public static int factorial(int n) {
		if(n <= 1)
			return 1;
		else
			return n * factorial(n-1);
	}
}