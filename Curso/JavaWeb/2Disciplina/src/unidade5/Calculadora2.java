package unidade5;

public class Calculadora2 {
	
	public static void main(String[] args) {
		
		Calculadora2 calc = new Calculadora2();
		IMath somar = (a, b) -> a + b;
		IMath subtrair = (a, b) -> a - b;
		IMath multiplicar = (a, b) -> a * b;
		IMath dividir = (a, b) -> a / b;
		IMath expoenciacao = (a, b) -> Math.pow(a, b);
		IMath radiciacao = (a, b) -> Math.pow(a, 1/b);
		
		System.out.println(calc.execSuleiman(5, 3, somar));
	}
	
	public double execSuleiman(double a, double b, IMath op) {return op.suleiman(a, b);}
}
