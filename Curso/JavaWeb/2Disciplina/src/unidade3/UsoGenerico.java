package unidade3;

import javax.net.ssl.ExtendedSSLSession;

public class UsoGenerico {

	public static void main(String[] args) {
		ExemploGeneric<Integer> iob = new ExemploGeneric<>(88);
		iob.showType();
		
		ExemploGeneric<String> sob = new ExemploGeneric<String>("Suleiman");
		sob.showType();
		System.out.println(iob.equals(sob));
		
	}

}
