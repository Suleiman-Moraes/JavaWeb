package vetor;

public class Exercicio03 {
	static int cont = 0;
	static int[] v2 = new int[15];
	public static void main(String[] args) {
		
		int[] v1 = new int[50];
		for (int i = 0; i < v1.length; i++) {
			v1[i] = (i + 1);
			int cont = 0;
			boolean vdd = false;
			for (int j = 2; j < Math.sqrt(i+1)+1; j++) {
				vdd = true;
				if((i+1) % j == 0) {
					j = i + 2;
					vdd = false;
				}
			}
			if(i == 1) arrayList(v1[i]);
			else if(vdd) arrayList(v1[i]);
			System.out.println("V1["+i+"] == " + v1[i]);
		}
		for(int x:v2) System.out.println("V2 == " + x);
	}
	public static void arrayList(int x) {
		v2[cont] = x;
		cont ++;
	}
}
