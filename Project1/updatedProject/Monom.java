package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^p, where a is a real number and p is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author 318696150
 *
 **/

/**this creates a new MONOM of shape a*x^p where is a -> real number and p-> is a non negative integer 
 * examples:{ x , ax , ax^p , a , -x}
 **/

public class Monom implements function {
	private double _coefficient; 
	private int _power; 
	
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}
	
	 /**Default constructor
	 */
	public Monom() {

		this._coefficient = 2;
		this._power = 3 ; 
	}
	
	/**
	 * Creates a new MONOM by getting its coefficient and the power of x.
	 * @param a = represents the coefficient of this Monom.
	 * @param p= represents the power of this Monom.
	 */
	public Monom(double a, int p){
		if(a != 0) {
			if(p>-1){
			this.set_coefficient(a);
			this.set_power(p);
		}}
	}

	/**
	 *first it calls to Monom(a,p).
	 * @param ot is the monom we'd like to copy into our monom
	 */
	
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * it gets a String , we split it into small strings and check if our monom is valid
	 * @param str is a String type monom 
	 **/
	public Monom(String str) {
		this(Monom_string(str));
	}
	private static Monom Monom_string(String str) {
		str = str.toLowerCase();
		double a = 0;
		int p = 0;
		int indexOfX = str.indexOf("x");
		int indexOfP = str.indexOf("^");
		if(indexOfX == -1) {
			
			a = Double.parseDouble(str);
			p= 0;
		}
		if(indexOfX == 0) {
			a = 1;
			if (indexOfP == -1) {
				p = 1;
			}	
			else {
				p = Integer.parseInt(str.substring(indexOfP + 1, str.length() ) );
			}
		}
		if(indexOfX == 1) {
			if(str.charAt(0) == '-') {
				a = -1;
				if (indexOfP == -1) {
					p = 1;
				}	
				else {
					p = Integer.parseInt(str.substring(indexOfP + 1, str.length() ) );
				}
			}
			else if(str.charAt(0) == '+') {
				a = 1;
				if (indexOfP == -1) {
					p = 1;
				}	
				else {
					p = Integer.parseInt(str.substring(indexOfP + 1, str.length() ) );
				}
			}
			else {
				a = Double.parseDouble(str.charAt(0) + "");
				if (indexOfP == -1) {
					p = 1;
				}	
				else {
					p= Integer.parseInt(str.substring(indexOfP + 1, str.length() ) );
				}
			}
		}
		if (indexOfX > 1) {
			a = Double.parseDouble(str.substring(0, indexOfX));
			if (indexOfP == -1) {
				p = 1;
			}	
			else {
				p = Integer.parseInt(str.substring(indexOfP + 1, str.length() ) );
			}
		}
		return new Monom(a,p);
		
	}	
	
	/**
	 * @return true/false - if the coefficient is equal to Zero 
	 */
	public boolean isZero() {
		boolean res = false;
		if(this.get_coefficient() == 0) {
			res = true;
		}
		return res;
	}

	/**
	 * @return the current coefficient of the Monom.
	 */
	public double get_coefficient() {
		// TODO Auto-generated method stub
		return this._coefficient;
	}

	/**
	 * 
	 * @return the current power of the Monom.
	 */
	public int get_power() {
		// TODO Auto-generated method stub
		return this._power;
	}

	/**
	 * @return the number we got that is a result of x to the power of p 
	 */
	@Override
	public double f(double x) {
		if(x == 0)
			return 0;
		double y = this.get_coefficient()*Math.pow(x, this._power);
		return y;
	} 
	
	/**
	 * @param n is a new monom
	 * we get the same power of our current monom and add it to a 
	 * then we add to this monom
	 */
	public void add(Monom n) {
		if(n.get_power() == this.get_power()) {
			double coef = this._coefficient*10+n._coefficient*10;
			coef/=10;
			this.set_coefficient(coef);
		}
	}
	
	/**
	 * we multiply this Monom by Monom m
	 * @param m the monom we mult by the current monom.
	 * @return the new monom we got.
	 */
	public Monom multiply(Monom m) {

		this.set_coefficient(this.get_coefficient() * m.get_coefficient());
		this.set_power( this.get_power() + m.get_power() );
		return m;
	}

	/**
	 *compute the derivative of our current monom
	 * @return the result 
	 */
	public Monom derivative() {
		double coef = (10*this._coefficient)*(10*this._power)/100;
		int p = this._power-1;
		this._coefficient = coef;
		this._power = p;
		Monom d= new Monom (coef ,p) ;
		return d;
	}
	
	/**
	 * @param e- Monom 
	 * @return true/false - if the monom's are equal 
	 */
	public boolean equals(Monom e) {
		return e != null && this.get_coefficient() == e.get_coefficient() 
				&& this.get_power() == e.get_power();
	}

	/**
	 *print monom.
	 */
	public String toString()
	{
		int p = this.get_power();
		double coef= this.get_coefficient();
		String res= ""+coef+"*x^"+p;
		return res;
	}


}


