import java.text.DecimalFormat; //It kepy printing out more than two decimal places, this prevents it from doing so 
import java.util.*;

public class Bobcar {

	public static void main(String[] args) {
		DecimalFormat f = new DecimalFormat("##.00");
		Scanner s = new Scanner(System.in);
		int cNum, days, total, cDis = 0;
		double pPack = 0;
		boolean club, plat = false;

		System.out.println("Available cars: 1 for Economy, 2 for Compact, 3 for Standard");
		System.out.print("Please choose the rental car: ");
		cNum = s.nextInt();

		System.out.print("Please enter the number of rental days: ");
		days = s.nextInt();
		total = days * getBase(cNum);

		System.out.print("Club member?: 1 for yes, 0 for no: ");
		club = (s.nextInt() == 1);
		
		if (club) {
			System.out.print("Platinum Executive Package?: 1 for yes, 0 for no: ");
			plat = (s.nextInt() == 1);
			if (plat) pPack = total * 0.15;
			cDis = (days/7) * getBase(cNum);
			total -= cDis;
		}

		System.out.println("\nBase: " + days + " days for a " + getType(cNum) + " @ $" + getBase(cNum) +" per day:	 $" + (days*getBase(cNum)));

		if (club) System.out.println("Club Member Discount:				-$" + cDis);
		if (plat) System.out.println("Platinum Executive Package: 			+$" + f.format(pPack));
		
		System.out.print("\nTotal Estimate for Rental:			 $" + f.format(total + pPack));

		s.close();
	}

	public static int getBase(int cNum) {
		if (cNum == 1) return 35;
		else if (cNum == 2) return 45;
		else if (cNum == 3)  return 95;
		else return 0;
	}

	public static String getType(int cNum) {
		if (cNum == 1) return "Economy";
		else if (cNum == 2) return "Compact";
		else if (cNum == 3)  return "Standard";
		else return "";
	}

}