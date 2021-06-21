package lambda;

public class LambdaEx5 {
	public static void main(String[] args) {
		
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				for(int i=1;i<11;i++) {
//					System.out.println(i);
//				}
//			}
//		};
//		
//		Thread thread = new Thread(r);
//		thread.start();
//		
//		for(int i=100;i<200;i++) {
//			System.out.println(i+" ");
//		}
		
		Runnable r = () -> {
			for(int i=1;i<11;i++) {
				System.out.println(i+" ");
			}
		};
		Thread thread = new Thread(r);
		thread.start();
	}

}
