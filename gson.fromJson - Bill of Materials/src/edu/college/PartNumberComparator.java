package edu.college;

import java.util.Comparator;

public class PartNumberComparator implements Comparator<String> {

	@Override
	public int compare(String partNumOne, String partNumTwo) {

		return partNumOne.compareTo(partNumTwo);
		
	}
}
