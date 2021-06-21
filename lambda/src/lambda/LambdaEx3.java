package lambda;

public class LambdaEx3 {
	public static void main(String[] args) {
		// Lambda3 ¶÷´Ù½Ä?
		Lambda3 lambda = (int a,int b) -> a > b ? a : b;
		System.out.println(lambda.max(10, 20));
	}

}
