package lambda;

public class LambdaEx2 {
	public static void main(String[] args) {
		//���ٽ�
		Lambda2 lambda = x -> System.out.println(x);
		lambda.method(10);
		
		//���ٽ�
		lambda = x -> {
			int y = 20;
			System.out.println(x*y);
		};
		lambda.method(100);
	}

}
