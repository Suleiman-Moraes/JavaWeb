package unidade3;

public class UsoGenerico2 {

	public static void main(String[] args) {
		Login<Integer, String> iob = new Login<Integer, String>(88, "Suleiman Moraes");
		
		iob.showType();
	}

}
