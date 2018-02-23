package unidade5;

public class Calculadora {
	
	public static void main(String[] args) {
		IMatematica obj = new IMatematica() {
			
			@Override
			public int subtrair(int a, int b) {return a - b;}
			
			@Override
			public int somar(int a, int b) {return a + b;}
			
			@Override
			public int multiplicar(int a, int b) {return a * b;}
			
			@Override
			public int dividir(int a, int b) {return a / b;}

			@Override
			public double expoenciacao(double a, double b) {return Math.pow(a, b);}

			@Override
			public double radiciacao(double a, double b) {return Math.pow(a, 1/b);}
		};
		System.out.println(obj.getClass());
		System.out.println(obj.somar(5, 5));
		System.out.println(obj.subtrair(5, 5));
		System.out.println(obj.multiplicar(5, 5));
		System.out.println(obj.dividir(5, 5));
	}
}
