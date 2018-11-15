package myMath;
import java.util.Iterator;

public interface Polynom_able extends cont_function {
		/**
		 * Add p1 to this Polynom
		 * @param p1 
		 */
		public void add(Polynom_able p1);
		/**
		 * Add m1 to this Polynom
		 * @param m1 Monom 
		 */
		public void add(Monom m1);
		/**
		 * Subtract p1 from this Polynom
		 * @param p1 
		 */
		public void substract(Polynom_able p1);
		/**
		 * Multiply this Polynom by p1
		 * @param p1 
		 */
		public void multiply(Polynom_able p1);
		/**
		 * Test if this Polynom is logically equals to p1.
		 * @param p1 
		 */
		public boolean equals (Polynom_able p1);
		/**
		 * Test if this is the Zero Polynom
		 * @return true/false
		 */
		public boolean isZero();
		/**
		 * @param x0 starting point = the min x
		 * @param x1 end point = the max x
		 * @param eps step (positive) value = how close y will be to zero.
		 * @return = the x closet to 0+-eps
		 */
		public double root(double x0, double x1, double eps);
		/**
		 * create a deep copy of this Polynom
		 * @return a copy.
		 */
		public Polynom_able copy();
		/**
		 * Compute a new Polynom which is the derivative of this Polynom
		 * @return the result
		 */
		public Polynom_able derivative();
		/**
		 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
		 * see: https://en.wikipedia.org/wiki/Riemann_integral
		 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
		 */
		public double area(double x0,double x1, double eps);
		/**
		 * @return an Iterator (of Monoms) over this Polynom
		 */
		public Iterator<Monom> iteretor();
	
	}


