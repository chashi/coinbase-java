package com.coinbase.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.joda.money.Money;
import org.joda.time.DateTime;

import com.coinbase.api.deserializer.MoneyDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Transaction implements Serializable {

    public enum Status {
	PENDING("pending"),
	COMPLETE("complete");
	
	private String _value;
	private Status(String value) { this._value = value; }
	
	@JsonValue
	public String toString() { return this._value; }
	
	@JsonCreator
	public static Status create(String val) {
	    for (Status status : Status.values()) {
		if (status.toString().equalsIgnoreCase(val)) {
		    return status;
		}
	    }
	    return null;
	}
    }

    /**
     * 
     */
    private static final long serialVersionUID = 2817857314208431664L;
    private String _id;
    private DateTime _createdAt;
    private String _hsh;
    private String _idem;
    private String _notes;
    private String _userFee;
    private Money _amount;
    private Boolean _request;
    private Status _status;
    private User _sender;
    private User _recipient;
    private String _recipientAddress;

    // Request Money
    private String _amountString;
    private String _amountCurrencyIso;
    private String _from;
    
    // Send Money
    private String _to;

    // Order
    private Integer _confirmations;

    public Integer getConfirmations() {
        return _confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        _confirmations = confirmations;
    }

    public String getTo() {
        return _to;
    }

    public void setTo(String to) {
        _to = to;
    }

    public String getFrom() {
        return _from;
    }

    public void setFrom(String from) {
        _from = from;
    }

    public String getAmountString() {
        return _amountString;
    }

    public void setAmountString(String amountString) {
        _amountString = amountString;
    }

    public String getAmountCurrencyIso() {
        return _amountCurrencyIso;
    }

    public void setAmountCurrencyIso(String amountCurrencyIso) {
        _amountCurrencyIso = amountCurrencyIso;
    }
    
    public String getId() {
        return _id;
    }
    
    public void setId(String id) {
        _id = id;
    }
    
    public DateTime getCreatedAt() {
        return _createdAt;
    }
    
    public void setCreatedAt(DateTime createdAt) {
        _createdAt = createdAt;
    }
    
    public String getHsh() {
        return _hsh;
    }
    
    public void setHsh(String hsh) {
        _hsh = hsh;
    }

    public String getHash() {
        return _hsh;
    }
    
    public void setHash(String hash) {
        _hsh = hash;
    }

    public String getNotes() {
        return _notes;
    }
    
    public void setNotes(String notes) {
        _notes = notes;
    }

    @JsonIgnore
    public Money getAmount() {
        return _amount;
    }
    
    @JsonProperty
    @JsonDeserialize(using=MoneyDeserializer.class)
    public void setAmount(Money amount) {
        _amount = amount;
        if (amount != null) {
            setAmountString(amount.getAmount().toPlainString());
            setAmountCurrencyIso(amount.getCurrencyUnit().getCurrencyCode());
        } else {
            setAmountString(null);
            setAmountCurrencyIso(null);
        }
    }
    
    public Boolean isRequest() {
        return _request;
    }
    
    public void setRequest(Boolean request) {
        _request = request;
    }
    
    public Status getStatus() {
        return _status;
    }
    
    public void setStatus(Status status) {
        _status = status;
    }
    
    public User getSender() {
        return _sender;
    }
    
    public void setSender(User sender) {
        _sender = sender;
    }
    
    public User getRecipient() {
        return _recipient;
    }
    
    public void setRecipient(User recipient) {
        _recipient = recipient;
    }

    public String getUserFee() {
        return _userFee;
    }

    public void setUserFee(BigDecimal userFee) {
        _userFee = userFee.toPlainString();
    }

    public String getRecipientAddress() {
        return _recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        _recipientAddress = recipientAddress;
    }

    public String getIdem() {
        return _idem;
    }

    public void setIdem(String idem) {
        _idem = idem;
    }
}
