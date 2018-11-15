package myMath;

import java.io.IOException;

/**this is a test class 
 * 
 * @author 318696150
 *
 */
public class test {
	public static void main(String[] args) throws IOException {
		
		//Polynom p0= new Polynom("-5 + -x + 3.0x^2 + -1.5x^3 + 0.2x^4");
		//p0.graph(-2,6, 0.01,p0);
		
		/**MONOM TEST*/
		System.out.println("\nMONOM TEST\n");
		
		/**constructor*/
		Monom m1 = new Monom(5, 10);
		System.out.println(m1);
		
		/**Copy Constructor*/
		Monom m2 = new Monom (m1);	
		System.out.println("Monom m2:"+m2);

	    /**Default constructor*/
		Monom m3 = new Monom ();
		System.out.println("Monom m63:"+m3);

		/**string constructor*/
		String str="2x^2";
		Monom m4= new Monom(str);
		System.out.println("Momon m4:"+m4);


		/**Add*/ 
		Monom sm1= new Monom(2,2);
		Monom sm2 = new Monom(5,2);
		Monom sm3= new Monom (sm1); 
		sm1.add(sm2); //  sm1+sm2=sm3
		System.out.println("\nSum of two monoms: " + sm3+ " + "+ sm2+" = "+sm1);	

		/**Multiply*/			
		Monom mm1 = new Monom(1, 1);
		Monom mm2 = new Monom(2, 1);
		Monom mm3= new Monom (mm1);
		mm1.multiply(mm2);
		System.out.println("\nMultiplication between two Monoms : "+ mm3 +" * "+ mm2 +" = "+ mm1);


		/**Derivative */
		Monom dm = new Monom(4,0);
		System.out.println("\nMonom before derivative: "+dm);
		System.out.println("derivative Monom: "+ dm.derivative());
		
		/**Value to x*/
		double val = 2;
		System.out.println("\nMonom after value to x : " +sm3.f(val));


        /**POLYNOM Test*/
		System.out.println("\nPOLYNOM TEST\n");
		
		// TODO Auto-generated method stub
		Polynom_able p1 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
		Polynom_able p2 = new Polynom("-4 + -20x + -3x^2 + 1x^3");
		Polynom p3 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
		Polynom p4 = new Polynom(" "); 

		//isZero
		System.out.println("\nisZero\n");
		boolean c = p3.isZero(); 
		System.out.println("isZero? = get false");
		System.out.println(c);
		System.out.println("isZero? = get true");
		c = p4.isZero(); 
		System.out.println(c); 
		
		//equals
		System.out.println("\nequals\n");
		boolean f = p1.equals(p2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1 equals p2 ? ");
		System.out.println(f);
		
		f = p1.equals(p3);
		System.out.println(p3);
		System.out.println("p1 equals p3 ? :");
		System.out.println(f);
		
		//add
		System.out.println("\nadd\n");
		p1.add(p2);
		System.out.println("p1 + p2 =");
		System.out.println(p1);

		//multiply
		System.out.println("\nmultiply\n");
		Polynom_able mul = p2.copy();
		Polynom_able p90= new Polynom("0");
		System.out.println("mul:"+p1);
		System.out.println("p90:"+p90);
		mul.multiply(p90);
		System.out.println("multiply a polynom_able: p90 * p4 = "+mul);

	
	//f(x)
		System.out.println("\nf(x)\n");
		
		System.out.println("f(p1) = get 2:" + p1.f(2));
		System.out.println("f(p2) = get -6:" + p2.f(2));

		//derivative 
		System.out.println("\nderivative\n");
		Polynom p12=new Polynom("-4x^3 + 1");
		System.out.println("p12:"+p12);
		System.out.println("derivative of p12="+p12.derivative());


		//area
		System.out.println("\narea\n");
		System.out.println("get something close to 2.333333320...:" + p1.area(0, 1,0.0001));
		System.out.println("get something close to -2.583870851...:" + p2.area(0.5, 1.5, 0.0001));
		System.out.println("get something close to 6.235175..:" + p3.area(0.5, 2, 0.0001));
		
	

		//root p1
		System.out.println("\nroot\n");
		
		
		System.out.println("root 1 = get something close to 7:" + p1.root(0,0.5, 0.0001));
		System.out.println("root 2 = get something close to 2:" + p1.root(1.5, 2.5, 0.0001));
		System.out.println("root 3 = get something close to 3:" + p1.root(2.5, 3.5, 0.0001));

		//root p2
		System.out.println("root 1 = get something close to 1:" + p2.root(-1, 2, 0.0001));
		System.out.println("root 2 = get something close to 4:" + p2.root(3.5, 4.5, 0.0001));
		System.out.println("root 3 = get something close to 5:" + p2.root(4.5, 5.5, 0.0001));
	
		
	//substract a Polynom_able
	System.out.println("\n p3:"+p3);
	System.out.println("p2:"+p2);
	p3.substract(p2);
	System.out.println("substract: p3-p2 = "+p3);


	
	}
	

	}


