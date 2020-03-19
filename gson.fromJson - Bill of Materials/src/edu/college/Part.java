package edu.college;

import java.util.ArrayList;
import java.util.List;

//POJO
@SuppressWarnings("unused")
public class Part {

	private String partNumber;

	private String name;

	private String partType;

	private float price;

	private ArrayList<BomEntry> billOfMaterial;
	
	public void addToBom(ArrayList<BomEntry> listOfMat) {
		this.billOfMaterial = listOfMat;
	}
	
	public ArrayList<BomEntry> getList(){
		ArrayList<BomEntry> billOfMaterialEncapped = new ArrayList<BomEntry>();
		
			billOfMaterialEncapped.addAll(billOfMaterial);
			
		return billOfMaterialEncapped;
	}
	
	//OC
//------------------------------------------------------------------------------------------------------------------------------------------------
	public Part(String partNumber, String name, String partType, float price,ArrayList<BomEntry> bom ) {
		
		this.partNumber = partNumber;
		this.name = name;
		this.partType = partType;
		this.price = price;
		this.billOfMaterial = bom;
	}
	
	public Part(String partNumber, String name, String partType, float price) {
		
		this.partNumber = partNumber;
		this.name = name;
		this.partType = partType;
		this.price = price;
	}

	public Part(String name, String partType, float price) {
		
		this.name = name;
		this.partType = partType;
		this.price = price;
	}

	public Part(String partType, float price) {
	
		this.partType = partType;
		this.price = price;
	}

	public Part(float price) {
		
		this.price = price;
	}

	public Part() {
		
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String getPartNumber() {
		String encapPartNumber = this.partNumber;
		return encapPartNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		String encapName = this.name;
		return encapName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartType() {
		String encapPartType = this.partType;
		return encapPartType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public float getPrice() {
		float encapPartPrice = this.price;
		return encapPartPrice;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
