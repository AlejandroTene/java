package clearminds.cuentas.test;

import clearminds.cuentas.Cuenta;

public class TestCuenta {

	public static void main(String[] args) {
		//Cuenta 1
		Cuenta cuenta1= new Cuenta("03476");
		cuenta1.setSaldo(675);
		
		//Cuenta2
		Cuenta cuenta2= new Cuenta("03476","C",98);
		
		//Cuenta3
		Cuenta cuenta3= new Cuenta("03476");
		cuenta3.setTipo("C");
		
		
		//Imprimir
		System.out.println("------Valores iniciales------");
		cuenta1.ImprimirConMiEstilo();
		cuenta2.ImprimirConMiEstilo();
		cuenta3.ImprimirConMiEstilo();
		
		System.out.println("------Valores modificados------");
		
		//modifiaciones
		cuenta1.setSaldo(444);
		cuenta3.setSaldo(567);
		cuenta2.setTipo("D");
		
		//Imprimir valores modificados
		cuenta1.ImprimirConMiEstilo();
		cuenta2.ImprimirConMiEstilo();
		cuenta3.ImprimirConMiEstilo();
		
		
		//Cuenta 4
		Cuenta cuenta4= new Cuenta("0987");
		cuenta4.setSaldo(10);
		
		//Cuenta 5
		Cuenta cuenta5= new Cuenta("0557","C",10);
		
		//Cuenta 6
		Cuenta cuenta6= new Cuenta("0666");
		
		
		//Imprimir cuentas 4-5-6
		cuenta4.ImprimirConMiEstilo();
		cuenta5.ImprimirConMiEstilo();
		cuenta6.ImprimirConMiEstilo();
		
		

		
		
		
		


	}

}
