package myMath;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, 
 *it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author 318696150
 *
 */
/**
 * this is the Polynom. we will create a set of Monoms (which is the Polynom)
 * and test it with the functions below.
 */

public class Polynom implements Polynom_able{

	private ArrayList<Monom>polynom;
	private final Monom_Comperator com = new Monom_Comperator();

	/**
	 *Create our Polynom.
	 * @param pol = is the Polynom we got and transfer into our current Polynom.
	 */
	public  Polynom(Polynom pol) {
		polynom = new ArrayList<Monom>();
		Iterator<Monom>monom = pol.iteretor();
		while(monom.hasNext()) {
			Monom n = new Monom(monom.next());
			polynom.add(n);
		}

	}

	/**
	 * this is a String Polynom 
	 * @param s 
	 */
	public Polynom(String s) {
		polynom = new ArrayList<Monom>();

		String[] arr = s.split(" ");
		for (int j = 0; j < arr.length; j++) {
			if (j == 0) {
				Monom n = new Monom(arr[j]);
				this.add(n); //add the first monom 
			}
			else { // we have a plus or  minus sign so we move on to the next char and add the next monom 
				if(arr[j].charAt(0) == '-') {
					j++;
					Monom m = new Monom(arr[j]);
					m.set_coefficient(-1 * m.get_coefficient());
					this.add(m);
				}	
				else if (arr[j].charAt(0) == '+') { 
					j++;
					Monom m = new Monom(arr[j]);
					this.add(m);
				}
			}
		}


	}

	/**
	 *Create a new Polynom.
	 */
	public Polynom() {
		polynom = new ArrayList<Monom>();

	}

	/**
	 * we put a value inside of x and return the sum of the monoms that 
	 * create the polynom
	 */
	@Override
	public double f(double x) {
		double sum = 0;
		Iterator<Monom>iterator = this.polynom.iterator();
		while(iterator.hasNext()) {
			sum+= iterator.next().f(x);
		}
		return sum;
	}

	/**
	 * adding a parameter m to our polynom
	 */

	@Override
	public void add(Monom m) {
		if(m != null){
			if(m.get_coefficient() != 0) {
				Monom add = new Monom(m);
				boolean newadd = false;

				for (int j = 0; j < polynom.size(); j++) {
					if(polynom.get(j).get_power() == add.get_power()) {
						polynom.get(j).add(add);
						newadd = true;
					}
				}
				for (int j = 0; j < polynom.size(); j++) {
					if(polynom.get(j).isZero()) {
						polynom.remove(j);
					}
				}
				if(!newadd) {
					polynom.add(add);
				}		
			}
		}
		polynom.sort(com);
	}
	/**
	 * adding a polynom to our current polynom 
	 */
	@Override
	public void add(Polynom_able newPol) {
		int length = this.polynom.size();
		int j = 0;
		boolean b;
		Iterator<Monom>m1 = newPol.iteretor();
		Iterator<Monom>m2 = this.polynom.iterator();
		while(m1.hasNext()) {
			b = false;
			Monom firstM = new Monom(m1.next());
			while(j < length && b == false) {
				Monom secondM = m2.next();
				if(com.compare(firstM, secondM) == 0) {
					if (firstM.get_coefficient() == -1 * secondM.get_coefficient()) {
						m2.remove(); //we delete it
						b = true;
					}
					else {
						secondM.add(firstM); 
						b = true;
					}
				}
				j++;
			}

			j = 0;
			if(b == false)
				polynom.add(firstM);

			m2 = this.polynom.iterator();
		}
		polynom.sort(com);//sort again
	}
	/**
	 * substract between this polynom to Polynom_able p1
	 */
	@Override
	public void substract(Polynom_able p1) {

		Iterator<Monom> itrp1 =p1.iteretor();

		while (itrp1.hasNext()) {

			Monom m2=itrp1.next();

			double a = ((m2.get_coefficient())* (-1));

			int b = m2.get_power();

			Monom n1 = new Monom (a,b);

			add(n1);

		}}


	/**
	 *we subtract the polynom poly
	 *@return the result


		@Override
		public void substract(Polynom_able poly) {
			Polynom poo =new Polynom((Polynom)poly);
			Polynom m = new Polynom();
			m.add(new Monom(-1,0));
			poo.multiply(m);
			this.add(poo);
			}
	 */
	/**
	 *this function multiplies two polynom's and
	 *@return the result 
	 **/ 
	@Override
	public void multiply(Polynom_able poly) {
		Polynom p1 =new Polynom((Polynom)poly);
		Polynom newp =new Polynom();
		for (int k = 0; k < this.size(); k++) {
			for (int l = 0; l < p1.size(); l++) {
				Monom t = new Monom(this.polynom.get(k));
				t.multiply(p1.polynom.get(l));
				newp.add(t);
			}
		}
		this.polynom = newp.polynom;
	}
	private int size() {
		return polynom.size();
	}

	/**
	 * @return true if all the coefficients are zero 
	 * if not , return false 
	 */
	@Override
	public boolean isZero() {
		Iterator<Monom> m = this.polynom.iterator();
		while (m.hasNext()) {
			Monom n= new Monom(m.next());
			if (n.get_coefficient() != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return root
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		if (f(x0)*f(x1) > 0) {
		}
		if (x1 < x0) {
			double t = x0;
			x0 = x1;
			x1 = t;
		}
		double a = (x0+x1)/2;
		while (x1-x0 > eps) {
			a = (x0+x1)/2;
			if ((f(x0) * f(a)) > 0) {
				x0=a;
			}
			else x1=a;
		}
		return a;
	}
	/**
	 * @return true/false - if the polynoms are equal 
	 */
	@Override
	public boolean equals(Polynom_able poly) {
		Iterator<Monom>p1 = poly.iteretor();
		Iterator<Monom>p2 = this.polynom.iterator();
		while(p1.hasNext()) {
			Monom monom1 = new Monom(p1.next());
			Monom monom2 = new Monom(p2.next());
			if(com.compare(monom1, monom2) != 0 || monom1.get_coefficient() != monom2.get_coefficient())
				return false;
		}
		return true;
	}

	/**
	 * @return a copy of the current polynom 
	 */
	@Override
	public Polynom_able copy() {
		Polynom_able poly = new Polynom();
		Iterator<Monom> I = this.iteretor();
		while(I.hasNext()) {
			poly.add(new Monom(I.next()));
		}	
		return poly;
	}

	/**
	 * calculates the area as close as epsilon 
	 * @return the area.
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		double k;
		double area = 0;
		for(double j = x0; j<x1; j=j+eps) {
			for(int t = 0; t<polynom.size(); t++) {
				double y = j+(eps/2);
				k = polynom.get(t).f(y); 
				area = area + (k*eps); 
			}
		}
		return area; 
	}


	/**
	 *Prints the Polynom.
	 * @return the polynom.
	 */
	public String toString()
	{
		boolean bFirst= true;
		String res = "";
		Iterator<Monom> part= polynom.iterator();

		while(part.hasNext())
		{
			Monom s = part.next();
			if(s.get_coefficient() >= 0 )
				if(bFirst == false)
					res += "+";


			res += s.toString()+"";
			bFirst = false;
		}

		return res;
	}

	/**
	 * @return iterator
	 */
	public Iterator<Monom> iteretor() {
		Iterator<Monom> part = new Iterator<Monom>() {

			private int currentIndex = -1;

			@Override
			public boolean hasNext() {
				if (currentIndex+1 >= polynom.size()) {
					return false;
				}
				return true;
			}

			@Override
			public Monom next() {
				currentIndex++;
				Monom n= new Monom(polynom.get(currentIndex));
				return n; 
			}
		};
		return part;
	}	

	/**
	 * @return all derivative's
	 */
	@Override
	public Polynom_able derivative() {
		Polynom_able poly = new Polynom();
		Iterator<Monom> I = this.iteretor();
		while(I.hasNext()) {
			poly.add(I.next().derivative());
		}	
		return poly;
	}


	}






