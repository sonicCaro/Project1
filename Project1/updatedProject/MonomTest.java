package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonomTest {
 
	@Test
		public void toStringTest() {
			Monom m1 = new Monom(2,2);
			String str = m1.toString();
			String ans = "2.0*x^2";
			if (!str.equals(ans)) {
				fail("the ToString of this monom is WRONG!");
			}
		}
		@Test
		public void  StringConstructorTest() {
			Monom m1 = new Monom("4x^3");
			Monom res = new Monom(4,3);
		if(res.get_coefficient()!=m1.get_coefficient() && res.get_power()!= m1.get_power()){
		fail("there is something wrong with the string constructor!");
		} }
		
		@Test
		public void functionTest () {
			Monom M1 = new Monom(2,1);
			double fxM1 = M1.f(6);
			double res =12;
			if(res!=fxM1){
				fail("there is something wrong with fx!");
			}
		}
		
		@Test
		public void derivativeTest() {
			Monom m1 = new Monom(2,3);
			m1.derivative();
			Monom res = new Monom(6,2);
			if(res.get_coefficient()!= m1.get_coefficient()&&res.get_power()!= m1.get_power()){
				fail("there is something wrong with the derivative function!");	
			}
		}
		
		@Test
		public void AddTest() {
			Monom m1 = new Monom(2,5);
			Monom m2 = new Monom(4,5);
			Monom m3 = new Monom(6,5);
			m1.add(m2);
			if(m3.get_coefficient()!=m1.get_coefficient()&& m3.get_power()!=m1.get_power()){
				fail("there is something wrong with the add function!");
			}
		}
		
		@Test
		public void MultiplyTest() {
			Monom m1 = new Monom(2,4);
			Monom m2 = new Monom(3,1);
			Monom actual = new Monom(6,5);
		    Monom expected = m1.multiply(m2);
			if(actual.get_coefficient()== expected.get_coefficient() && actual.get_power()!= expected.get_power()){
				fail("there is something wrong with the multiply function!");
			}
		}
	
	
		
	}


