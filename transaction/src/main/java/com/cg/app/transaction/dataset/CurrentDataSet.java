package com.cg.app.transaction.dataset;

import java.util.List;

import org.springframework.hateoas.Link;

import com.cg.app.transaction.entity.Transaction;

public class CurrentDataSet {
	private List<Transaction> transaction;
	private Link nextLink;
	private Link prevLink;

	
	
	public CurrentDataSet() {
		super();
	}

	public CurrentDataSet(List<Transaction> transaction, Link nextLink, Link prevLink) {
		super();
		this.transaction = transaction;
		this.nextLink = nextLink;
		this.prevLink = prevLink;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Link getNextLink() {
		return nextLink;
	}

	public void setNextLink(Link nextLink) {
		this.nextLink = nextLink;
	}

	public Link getPrevLink() {
		return prevLink;
	}

	public void setPrevLink(Link prevLink) {
		this.prevLink = prevLink;
	}

	@Override
	public String toString() {
		return "CurrentDateSet [transaction=" + transaction + ", nextLink=" + nextLink + ", prevLink=" + prevLink + "]";
	}
	
	

}
