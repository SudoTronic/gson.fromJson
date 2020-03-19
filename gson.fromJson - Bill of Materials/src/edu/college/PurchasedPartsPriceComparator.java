package edu.college;
import java.util.Comparator;

public class PurchasedPartsPriceComparator implements Comparator<Float> {
	
	@Override
	public int compare(Float priceOne , Float priceTwo) {

		if(priceOne > priceTwo){
			return -1;
		}
		else if(priceOne == priceTwo) {
			
			return 0;
		}
		else if(priceOne < priceTwo) {
			
			return 1;
		}
		else {
			
			return -2;
			
		}
		
	}

	
}
