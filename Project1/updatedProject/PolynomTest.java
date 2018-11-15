package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

		public class PolynomTest {

			@Test
		public	void ConstTest() {
				Polynom_able p1 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				String str = p1.toString();
				String res = "-4.0*x^0+10.0*x^1-4.0*x^2+1.0*x^3";
				if (!str.equals(res)) {
					fail("the polynom doesn't match its ToString");
				}
			}
			
			@Test
			public void substractTest() {
				Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
				Polynom_able p2 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				p1.substract(p2);
				String str = p1.toString(), res = "-2.0*x^0+1.0*x^1-2.0*x^2";
				if (!str.equals(res)) {
					fail("there is something wrong with the SUBSTRACT function");
				}
			}
			
			@Test
			public void multiplyTest() {
				Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
				Polynom_able p2 = new Polynom("20 + -29x + 10x^2 + -1x^3");
				p1.multiply(p2);
				String str = p1.toString(), res= "-120.0*x^0+394.0*x^1-499.0*x^2+310.0*x^3-100.0*x^4+16.0*x^5-1.0*x^6";
				if (!str.equals(res)) {
					fail("there is something wrong with the Multiply function");
				}
			}
				
			@Test
			public void MonomAddTest() {
				Polynom_able p1 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				Monom m1 = new Monom(4,3);
				p1.add(m1);
				String str = p1.toString() , res = "-4.0*x^0+10.0*x^1-4.0*x^2+5.0*x^3";
				if (!str.equals(res)){
					fail("there is something wrong with the AddMonom function!");
				}
			}
			
			@Test
			public void AddTest(){
				Polynom_able p1=new Polynom("-4 + 10x + -4x^2 + 1x^3");
				Polynom_able p2=new Polynom("-6 + 11x + -6x^2 + 1x^3");
				p1.add(p2);
				String str=p1.toString() ;
				String res="-10.0*x^0+21.0*x^1-10.0*x^2+2.0*x^3";
				if(!str.equals(res)){
					fail("there is something not right about the add function!");
					
				}
			}
			
			@Test
		public void functionTest() {
				Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
				double num = p1.f(2);
				double res = 0; 
				if(num!=res)
					fail("there is something not right about the function!");
			}
			
			
			@Test
		public void equalsTest() {
				Polynom_able p1 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				Polynom_able p2 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				boolean flag = p1.equals(p2);
				if(flag==false)
				fail("there is something wrong about the equals function!");	
			}
			
			@Test
		public void IsZeroTest() {
				Polynom_able p1 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				boolean flag= p1.isZero();
				if(flag==true)
				fail("there is something wrong about isZero function!");
			}
	
			@Test
	public void derivativeTest() {
				Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
				Polynom_able i = p1.derivative();
				Polynom_able derp1 = new Polynom("11 + -12x + 3x^2");
				assertTrue(derp1.equals(i));
			}
			
			@Test
		public	void RootTest() {
				Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
				double num = Math.round(p1.root(1.5,2.5, 0.0001));
				if(2.0!=num){
					fail("there is something wrong with the root function!");
			}
			}
			
			
				@Test
			public void AreaTest() {
				Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
				assertEquals(-2,Math.round(p1.area(0, 1, 0.0001)));
			}
				
				
			@Test
			public void CopyTest() {
				Polynom_able p1 = new Polynom("-4 + 10x + -4x^2 + 1x^3");
				Polynom_able i= new Polynom();
				i = p1.copy();
				assertTrue(p1.equals(i));
			}
			
		
		
			
			
			
		}
			
		
