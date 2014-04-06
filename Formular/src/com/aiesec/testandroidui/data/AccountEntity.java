package com.aiesec.testandroidui.data;

import org.json.JSONObject;

public class AccountEntity 
{
	private String accountNumber;
	private String bankName;
	private double value;
	private String currency;
	
	public void parseJSON(JSONObject object)
	{
		accountNumber = object.optString("accountNumber");
		bankName = object.optString("bank");
		value = object.optDouble("value");
		currency = object.optString("currency");
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
