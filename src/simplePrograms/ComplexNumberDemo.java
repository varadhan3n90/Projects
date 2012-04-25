/*
 * Program to add, subtract, multiply and divide complex numbers.
 * Created on : 25/4/12
 */
package simplePrograms;

class ComplexNumber{
	double real;
	double imaginary;
	
	ComplexNumber(double real,double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public ComplexNumber add(ComplexNumber n){
		ComplexNumber result = new ComplexNumber(0, 0);
		result.real = real + n.real;
		result.imaginary = imaginary + n.imaginary;
		return result;
	}
	
	public ComplexNumber subtract(ComplexNumber n){
		ComplexNumber result = new ComplexNumber(0, 0);
		result.real = real - n.real;
		result.imaginary = imaginary - n.imaginary;
		return result;
	}
	
	public ComplexNumber multiply(ComplexNumber n){
		ComplexNumber result = new ComplexNumber(0, 0);
		result.real = real * n.real - imaginary * n.imaginary;
		result.imaginary = real * n.imaginary + imaginary * n.real;
		return result;
	}
	
	public ComplexNumber divide(ComplexNumber n){
		ComplexNumber result = null;
		ComplexNumber denominatorConjugate = new ComplexNumber(n.real,-n.imaginary);
		ComplexNumber denominator = n.multiply(denominatorConjugate);
		result = new ComplexNumber((this.real/denominator.real),(this.imaginary/denominator.real));
		result = result.multiply(denominatorConjugate);		
		return result;
	}
}

/**
 * The Class ComplexNumberDemo.
 */
public class ComplexNumberDemo {	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ComplexNumber cn1 = new ComplexNumber(4, 5);
		ComplexNumber cn2 = new ComplexNumber(3, -2);
		ComplexNumber cn4, cn5, cn6, cn7;
		System.out.println("First ComplexNumber number: " + cn1.real + " + "+cn1.imaginary+"i");
		System.out.println("Second ComplexNumber number: " + cn2.real + " + "+cn2.imaginary+"i");
		if (cn1.equals(cn2))
			System.out.println("cn1 and cn2 are equal.");
		else
			System.out.println("cn1 and cn2 are NOT equal.");
		cn4 = cn1.add(cn2);
		cn5 = cn1.subtract(cn2);
		cn6 = cn1.multiply(cn2);
		cn7 = cn1.divide(cn2);
		System.out.println("cn1 + cn2: " + cn4.real + " + "+cn4.imaginary+"i");
		System.out.println("cn1 - cn2: " + cn5.real+ " + "+cn5.imaginary+"i");
		System.out.println("cn1 * cn2: " + cn6.real+" + "+cn6.imaginary+"i");
		System.out.println("cn1 / cn2: " + cn7.real+" + "+cn7.imaginary+"i");
	}
}
