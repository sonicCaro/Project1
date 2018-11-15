package myMath;
import java.util.Comparator;
public class Monom_Comperator implements Comparator<Monom>{
/** Check if the power of the two monom's are equal
 * @return -1 = less than the second monom  / 0=equal / 1=greater than the second monom
 */
 
		@Override
		public int compare(Monom monom1, Monom monom2) {
			 if(monom1.get_power() < monom2.get_power())
				return -1;
			 else if(monom1.get_power() > monom2.get_power())
				return 1;
			
			return 0;
		}
	}



