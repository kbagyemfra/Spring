package com.example.com;

public class Sales {

	 private int id;
	    private String item;
	    private int quantity;
	    private double amount;
	 
	    protected Sales() {
	    }
	 
	    public Sales(String item, int quantity, double amount) {
	        this.item = item;
	        this.quantity = quantity;
	        this.amount = amount;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
	
	    
	    
}
