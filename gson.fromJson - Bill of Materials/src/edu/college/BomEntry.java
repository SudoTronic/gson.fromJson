package edu.college;
@SuppressWarnings("unused")
public class BomEntry {
	//POJO
	private String partNumber;
	
	private int quantity;
	
		//OC
	//----------------------------------------------------------------------------------------------------------------
	public BomEntry(String partNumber, int quantity) {
		super();
		this.partNumber = partNumber;
		this.quantity = quantity;
	}
	public BomEntry(int quantity) {
		super();
		this.quantity = quantity;
	}
	public BomEntry() {
		super();
	}
	//----------------------------------------------------------------------------------------------------------------
	
	public String getPartNumber() {
		String encapPartNumber = this.partNumber;
		return encapPartNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public int getQuantity() {
		int encapQuantity = this.quantity;
		return encapQuantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BomEntry other = (BomEntry) obj;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		return true;
	}
}
