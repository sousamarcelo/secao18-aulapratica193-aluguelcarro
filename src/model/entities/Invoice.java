package model.entities;

public class Invoice {
	
	private Double baseciPayment;
	private Double tax;
	
	public Invoice() {
	}

	public Invoice(Double baseciPayment, Double tax) {
		this.baseciPayment = baseciPayment;
		this.tax = tax;
	}

	public Double getBaseciPayment() {
		return baseciPayment;
	}

	public void setBaseciPayment(Double baseciPayment) {
		this.baseciPayment = baseciPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double totalPayment() {
		return getBaseciPayment() + getTax();
	}
	
}
