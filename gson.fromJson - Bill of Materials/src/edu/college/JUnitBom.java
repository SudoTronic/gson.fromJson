package edu.college;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.junit.Test;

@SuppressWarnings("unused")
public class JUnitBom {

	@Test
	public void test_PartManagerimpl_Class() {

		//File Selection
		//-------------------------------------------------------------------------------------

		Scanner scan = new Scanner(System.in);

		JFileChooser choose = new JFileChooser();
		FileNameExtensionFilter jason = new FileNameExtensionFilter(".json", "json");
		choose.setFileFilter(jason);
		File bomFile;

		int extCheck = 0;
		do {

			System.out.println("Please Select the Associated 'bom.json' file for the assignment");
			System.out.println("Press enter to continue or exit to manage the file location");
			scan.nextLine();

			int result = choose.showOpenDialog(choose);

			bomFile = choose.getSelectedFile();

			String extension = "";
			String expectedExtension = "json";
			String bomName = bomFile.getName().toString();

			bomFile = choose.getSelectedFile();

			int i = bomName.lastIndexOf('.');
			if (i > 0) {
				extension = bomName.substring(i + 1);
			}

			System.out.println(extension);

			if (extension.equals(null)) {
				System.out.println("The system did not recognize this files extension, please try again");
				extCheck = 0;

			} else {

				if (extension.equals(expectedExtension)) {

					if (result == JFileChooser.APPROVE_OPTION) {
						System.out.println("File has been selected at: " + "\n" + choose.getCurrentDirectory());
						extCheck = 1;

					} else {
						System.out.println("User did not select a file.");
						extCheck = 0;

					}
				} else {

					System.out.println("This is not the expected extension for the bom file, please try again.");
					extCheck = 0;

				}

			}

			choose.setCurrentDirectory(bomFile);

		} while (extCheck == 0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Done With File Selection
		//--------------------------------------------------------------------------------------
		
		int expectedNumberOfParts = 79;
		
		
		
		
		String validPartNumber = "20-0001";
		String	invalidPartNum = "20-8957965795974";
		String bomFileLocale = bomFile.getPath().toString();
		
		
		PartManager mngr = new PartManagerimpl();
		Part nullPart = new Part();
		 nullPart = null;
		 
		 Part partForCostMethod = new Part();
		
		
		
		

		
		
	
		System.out.println("Now Testing importPartStore");
		System.out.println("-------------------------------------");
		int numOfParts = mngr.importPartStore(bomFileLocale);
		
		System.out.println();
		System.out.println("Imported " + numOfParts + " Parts.");
		
		assertEquals(expectedNumberOfParts, numOfParts);
	
		
		
		/*
		 	"partNumber": "20-0001",
    		"name": "EveryRoad GPS, Shippable, US Model 300",
    		"partType": "ASSEMBLY",
		 */
		
		
		
		System.out.println("Now testing  'Cost'Part'");
		System.out.println("-------------------------------------");
		partForCostMethod = mngr.costPart(validPartNumber);
		float expectedPrice = (float) 0.0;
		
		// assertEquals((float) partForCostMethod.getPrice(), expectedPrice);
		
		
		
		System.out.println();
		mngr.getFinalAssemblies();
		
		
		
		
		System.out.println("Now testing invalid number in 'Cost'Part'");
		System.out.println("-------------------------------------");
		System.out.println("");
		Part shoudlBeNull = mngr.costPart(invalidPartNum);
		Part returnedPart = new Part();
		System.out.println("");
		
		assertEquals(shoudlBeNull, nullPart);
		
		
		
		
		
		System.out.println("Now testing part Retrieval ");
		System.out.println("-------------------------------------");
		System.out.println("");
		returnedPart = mngr.retrievePart(validPartNumber);
		System.out.println("");
		System.out.println("__________Returned Part________________");
		System.out.println(returnedPart.getName());
		System.out.println(returnedPart.getPartNumber());
		System.out.println(returnedPart.getPartType());
		System.out.println(returnedPart.getPrice());
		System.out.println("");
		
		
		
		
		System.out.println("Now testing invalid number in 'Retrieve Part'");
		System.out.println("");
		returnedPart = mngr.retrievePart(invalidPartNum);
		
		
		/*
		System.out.println("__________BOM for " + returnedPart.getName() +  "________________");
		System.out.println(returnedPart.getList());
		*/
		
		
		List<Part> purchasePartsByPriceReturned = mngr.getPurchasePartsByPrice();
		
		System.out.println("");
		System.out.println("Now testing getPurchasedPartsByPrice ");
		System.out.println("-------------------------------------");
		
			for (int i = 0; i < purchasePartsByPriceReturned.size(); i++) {
				
			System.out.println(purchasePartsByPriceReturned.get(i).getName());
			System.out.println(purchasePartsByPriceReturned.get(i).getPrice());
			
		}
		
		
		
		
	}

}
