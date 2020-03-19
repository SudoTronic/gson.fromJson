package edu.college;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


/**
 * 
 * 
 * float extendedPrice = roundForMoney(Part.getPrice() *
  BomEntry.getQuantity());
 * 
 * Returns the supplied value rounded for money.
 * 
 * @param value:  the value to round.
 * @return the rounded value.
 * 
 * 
         private float roundForMoney(final float value) { return new
         BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
         }
 * 
 * 
 */

public class PartManagerimpl implements PartManager {

	private List<Part> partsMasterList = new ArrayList<Part>();
	
	private void addToMaster(Part part) {
		this.partsMasterList.add(part);
	}
	
	public List<Part> getMasterPartList() {
		List<Part> partsMasterListEncapClone = new ArrayList<Part>();
		partsMasterListEncapClone.addAll(partsMasterList);
		return partsMasterListEncapClone;
	}
	
	//				<part# , Part>
	private HashMap<String, Object> hashedParts = new HashMap<>();

	private void addToHash(String Key, Part part) {

		this.hashedParts.put(Key, part);
	}
	
	public Part getFromHash(String Key) {
			Part returnedPart = (Part) hashedParts.get(Key);
			return returnedPart;
	}
	
	//			<PARTPRICE, Part>
	private HashMap<String, Object> hashedPartsByPrice = new HashMap<>();
	
	private void addToPriceHash(Float Key, Part part) {
		
		String keyToString = Key.toString();
		
		this.hashedParts.put(keyToString, part);
		
	}
	
	public Part getFromPriceHash(Float Key) {

		
			String keyToString = Key.toString();
			
			Part returnedPart = (Part) hashedParts.get(keyToString);
			
			return returnedPart;
	}
	
	
	
	
	
	
 
	public int importPartStore(String filePath) {
		
		System.out.println("Part Store is being imported");

		String jasonPath = filePath;

		String result = null;

		Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

		JsonElement json;

		try {
			json = gsonPretty.fromJson(new FileReader(jasonPath), JsonElement.class);
			result = gsonPretty.toJson(json);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {

			e.printStackTrace();
		}

		// System.out.println(result);

		Part[] parts = gsonPretty.fromJson(result, Part[].class);
		
		BomEntry[] entry = gsonPretty.fromJson(result, BomEntry[].class);

		
		
		
		List<Part> partsRefined = new ArrayList<Part>();

		
		
		for (int i = 0; i < parts.length; i++) {

			partsRefined.add(parts[i]);

		}
		
	
		

		int answerCheck = 0;
		System.out.println("\n");
		System.out.println("-----------------------------------------------------");
		Part newPart;
		
	
		Scanner scan = new Scanner(System.in);
		int x = 0;
		do {
			try {
				System.out.println("Would you like to see the parts added?");
				System.out.println("0 = no || 1 = yes");
				
				System.out.print(":"); x = scan.nextInt();
				System.out.println("");
				
			} catch (InputMismatchException IMME) {
				System.out.println("Please press 1 or 2.");
				scan.nextLine();
			}
			
			if(x < 0 || x > 1) {
				System.out.println("Invalid Option");
				scan.nextLine();
			}
			else {
				if (x == 1) {
					
					System.out.println("_________________________Parts____________________________");
					for (int i = 0; i < partsRefined.size(); i++) {
						System.out.println("Part " + i + " added: " + partsRefined.get(i).getName());
						System.out.println(partsRefined.get(i).getPartType());
					}
					
					/*
					System.out.println("_________________________B's OM____________________________");
					for (int i = 0; i < bomEntries.size(); i++) {
						System.out.println("Part: " + i);
						Part retrievedPart = retrievePart(bomEntries.get(i).getPartNumber());
						System.out.println("");
						
					}
					
					*/
					
					
					
					answerCheck = 1;
				}
				else if(x == 0){
				answerCheck = 1;	
					
				}
			}
		}while(answerCheck == 0);
		

		for (int i = 0; i < partsRefined.size(); i++) {

			//	String partNumber,
			//	String name, 
			//	String partType, 
			//	float price
			
			newPart = new Part(partsRefined.get(i).getPartNumber(), partsRefined.get(i).getName(),
					partsRefined.get(i).getPartType(), partsRefined.get(i).getPrice());
			
			addToHash(partsRefined.get(i).getPartNumber(), newPart);
		}
		for (int i = 0; i < partsRefined.size(); i++) {
			newPart = new Part(partsRefined.get(i).getPartNumber(), partsRefined.get(i).getName(),
					partsRefined.get(i).getPartType(), partsRefined.get(i).getPrice());

			addToMaster(newPart);
			
		}
		
		/*
		
		for (int i = 0; i < partsRefined.size(); i++) {
			BomEntry entry = new BomEntry(partsRefined.get(i).getList().get(i).getPartNumber(),
					partsRefined.get(i).getList().get(i).getQuantity()); 
		}
		*/
		
		
		
		Scanner EC = new Scanner(System.in);
		int y = 0;
		answerCheck = 0;
		do {
			try {
				System.out.println();
				System.out.println();
				System.out.println("Would you like to see the Extra Credit Hashmap Display?");
				System.out.println("0 = no || 1 = yes");
				
				System.out.print(":"); y = EC.nextInt();
				System.out.println("");
				
			} catch (InputMismatchException IMME) {
				System.out.println("Please press 1 or 2.");
				scan.nextLine();
			}
			
			if(x < 0 || x > 1) {
				System.out.println("Invalid Option");
				scan.nextLine();
			}
			else {
				if (x == 1) {
					System.out.println();
					System.out.println("____________________HashMap Contents________________________");
					
					 Set set = hashedParts.entrySet();
				      Iterator iterator = set.iterator();
				      while(iterator.hasNext()) {
				         Map.Entry mapEntry = (Map.Entry)iterator.next();
				         System.out.print("key is: "+ mapEntry.getKey() + " & Value is: ");
				         System.out.println(mapEntry.getValue());
				      }
					
					
					
					answerCheck = 1;
				}
				else if(y == 0){
				answerCheck = 1;	
					
				}
			}
		}while(answerCheck == 0);
		
		
		
		
		
		
		
		
		
		
		 /*
		BomEntry entries = new BomEntry(assemblyOrComponent.getList().get(i).getPartNumber(),
				assemblyOrComponent.getList().get(i).getQuantity());
				
				assemblyOrComponent.addToEntries(entries);
		*/
		
		
		
		
		
		
		
		
		// 1: Read the contents of the bom.json JSON file into a String.

		// 2: Use the GSON library to convert the BOM data from the JSON format to an
		// array of Part instances.
		// See the Part POJO section above for the attributes of the Part class

		// 3: Scan the array of parts and save each part to a collection of your choice.

		// 4: . Return the number of imported parts

		/**
		 * EC
		 * 
		 * Extra Credit Opportunity: The best collection to store the Parts would be a
		 * collection that stored a key/value pair where the key would be the part
		 * number and the value would be the Part instance relating to the part number.
		 * HASHMAP
		 * 
		 * This collection exists; however, we have not discussed it yet. Five extra
		 * credit points will be rewarded if you research and correctly use this Java
		 * Collection in this project to store the Parts.
		 * 
		 * 
		 */
		//=================================IMPORTANT==============================================================================

		//=================================IMPORTANT==============================================================================
		// This Extra Credit was attemped and successfully implemented but the hashMap list is not used for 
		// every methods Operation. A JUnitTest method has been added to show that the hashmap can get a
		// Part Object using a valid part Number.
		//=================================IMPORTANT==============================================================================

		//=================================IMPORTANT==============================================================================


		return partsRefined.size();

	}
	
    private float roundForMoney(final float value) { return new
    BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

	@Override
	public Part costPart(String partNumber) {
		
		
		
		String confirmedPartNumber = "";
		checkLoop: for (int i = 0; i < partsMasterList.size(); i++) {
			
			if(partsMasterList.get(i).getPartNumber().equals(partNumber)) {
				confirmedPartNumber = partsMasterList.get(i).getPartNumber();
				break checkLoop;
			}
			else {
				confirmedPartNumber = null;
			}
			
		}
		
		
		if(confirmedPartNumber == null) {
			
			System.out.println("The part Number is invalid. And therefore cannot be priced \n"
					+ "Part does not exsist");
			return null;
			
		}
		else {
			Part partToBePriced = getFromHash(confirmedPartNumber);
			
			System.out.println("Price of " + partToBePriced.getName() + ":");
			System.out.println(partToBePriced.getPrice());
			
		}
		
		
			
			
		
	
		
		//ArrayList<BomEntry> bom = partToBePriced.getList();

	
		
		
		
	//	for (int i = 0; i < bom.size(); i++) {
	//		
		//	System.out.println(bom.get(i).getQuantity());
			
	//	}
		
		//float extendedPrice = roundForMoney(partToBePriced.getPrice() *
			//	  partToBePriced.getList().getQuantity());
		
		
		/*
		 * This method computes the cost of manufacturing the part associated with the
		 * supplied part number. Along with computing the manufacturing cost of the
		 * supplied part, this method also computes the cost of each sub component part,
		 * and their sub component parts, until all parts under the supplied part have
		 * been costed.
		 */

		return null;
	}
	
	@Override
	public Part retrievePart(String partNumber) {

		
		String confirmedPartNumber = "";
		checkLoop: for (int i = 0; i < partsMasterList.size(); i++) {
			
			if(partsMasterList.get(i).getPartNumber().equals(partNumber)) {
				confirmedPartNumber = partsMasterList.get(i).getPartNumber();
				break checkLoop;
			}
			else {
				confirmedPartNumber = null;
			}
			
		}
		
		
		if(confirmedPartNumber == null) {
			
			System.out.println("The part Number is invalid. And therefore cannot be priced \n"
					+ "Part does not exsist");
			return null;
			
		}
	
		Part partToReturn = getFromHash(confirmedPartNumber);
			
			System.out.println("The part associated With this part number is: \n"
					+ partToReturn.getName());
		
		
		
		
		
		/*
		 * Return the Part instance from the part store that is related to the supplied
		 * part number. Return null if no Part instance is found for the supplied part
		 * number.
		 */

		return partToReturn;
	}

	@Override
	public List<Part> getFinalAssemblies() {

		
		List<Part> assemblyParts = new ArrayList<>();
		List<String> assemblyPartNum = new ArrayList<>();
		List<Part> assemblyPartsByPartNum = new ArrayList<>();
		
		
		for (int i = 0; i < partsMasterList.size(); i++) {
			if (partsMasterList.get(i).getPartType().equals("ASSEMBLY")) {
				assemblyParts.add(partsMasterList.get(i));
				assemblyPartNum.add(partsMasterList.get(i).getPartNumber());
				
			}
		}
		
		
		
		Collections.sort(assemblyPartNum, new PartNumberComparator());
		
		//To make specified order on assignment page.
		Collections.reverse(assemblyPartNum);	
		
		for (int i = 0; i < assemblyPartNum.size(); i++) {
			
			assemblyPartsByPartNum.add(getFromHash(assemblyPartNum.get(i)));
			
		}
		
		System.out.println();
		
		System.out.println("returning AssemblyPartsByPart#: ");
		
			for (int i = 0; i < assemblyPartsByPartNum.size(); i++) {
			
			System.out.println(assemblyPartsByPartNum.get(i).getName());
			System.out.println(assemblyPartsByPartNum.get(i).getPartNumber());
			
		}
		
		System.out.println();
		
		
		/*
		 * Scan all parts imported in the part store and return only the final assembly
		 * parts. Final assembly parts have a part type of “ASSEMBLY”. The returned list
		 * of final assembly parts should be sorted in ascending order by their part
		 * number
		 */

		return assemblyPartsByPartNum;
	}
	
	@Override
	public List<Part> getPurchasePartsByPrice() {
		
	
		List<Part> purchaseParts = new ArrayList<>();
		List<Float> partPrices = new ArrayList<>();
		List<Part> purchasePartsByPrice = new ArrayList<>();
		
		
		for (int i = 0; i < partsMasterList.size() ; i++) {
			
			if(partsMasterList.get(i).getPartType().equals("PURCHASE")) {
				purchaseParts.add(partsMasterList.get(i));
				addToPriceHash(partsMasterList.get(i).getPrice(), partsMasterList.get(i));
				partPrices.add(partsMasterList.get(i).getPrice());
			}
		}
		 Collections.sort(partPrices, new PurchasedPartsPriceComparator());
		 
		 
		 
			for (int i = 0; i < partPrices.size(); i++) {
				
				purchasePartsByPrice.add(getFromPriceHash(partPrices.get(i)));
				
				
			}
		/*
		 * Scan all parts imported in the part store and return only the purchased
		 * parts. Purchased parts have a part type of “PURCHASE”. The returned list of
		 * purchased parts should be sorted in descending order by their price (highest
		 * price to lowest price)
		 */

		return purchasePartsByPrice;
	}

}
