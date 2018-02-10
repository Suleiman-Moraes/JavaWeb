package unidade5;

import java.util.Arrays;
import java.util.List;

public class LambdaApp {
	int soma;
	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3, 4);
		int num = 10;
		LambdaApp ap = new LambdaApp();
		/*System.out.println(ints);
		for(Integer i:ints) {
			i = i + 10;
			System.out.println(i);
		}*/
		ints.forEach(x->{
			x = x + num;
			ap.soma = ap.soma + x;
			System.out.println(x);
			System.out.println(ap.soma);
		});
	}

}
