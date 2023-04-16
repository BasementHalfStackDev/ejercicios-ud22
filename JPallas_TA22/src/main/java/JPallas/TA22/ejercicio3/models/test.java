package JPallas.TA22.ejercicio3.models;

public class test {

	public static void main(String[] args) {
		Scientist s1 = new Scientist();
		
		test(s1);
		
	

	}

	public static void test(Scientist s1) {
		System.out.println("it starts here");
		String DNI = "77791527F";
		if (s1.dniValidator(DNI)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		
		
	}
}
