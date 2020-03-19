package edu.college;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
@SuppressWarnings("unused")
public interface PartManager {
	
	

	
	int importPartStore(String filePath);
	
		
		/*
		 	a) Imports the part store from an external file.
			b) Accepts the file path to the file which contains the parts to import.
			c) Returns the number of parts imported.
		 */
		

		
	
	
	Part costPart(String partNumber);
	/*
	 	a) Computes the cost to manufacture the part associated with the supplied part number.
		b) Accepts a part number which identifies the part to compute the cost for.
	 */
	
	
	
	Part retrievePart (String partNumber);
	
	/*
		a) Retrieves the part associated with the supplied part number from the part store.
		b) Accepts a part number which identifies the part to retrieve.
		c) Returns the Part instance associated with the supplied part number or null if not found
	 */
	
	List<Part> getFinalAssemblies();
	
	/*
	 	a) Returns all final assembly parts sorted alphabetically by their part number.
		b) Final assemblies have a part type of “ASSEMBLY”. 
	 */
	
	
	
	List<Part> getPurchasePartsByPrice();
	/*
	 	a) Returns all purchased parts sorted by their price, highest price to lowest.
		b) Purchase parts have a part type of “PURCHASE”.
	 */
	 
	
	
}
