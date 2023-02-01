package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ajlj - Austin Mays ajmays@dmacc.edu
 * CIS175 - Spring 2023
 * Jan 31, 2023
 */

@Entity
@Table(name="bank")
public class Bank {
	@Id
	@GeneratedValue
	@Column(name="NAME")
	private String name;
	@Column(name="ACCOUNT")
	private int acctNum;
	
	public Bank() {
		super();
	}
	public Bank(String name, int acctNum) {
		this.name = name;
		this.acctNum = acctNum;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the acctNum
	 */
	public int getAcctNum() {
		return acctNum;
	}
	/**
	 * @param acctNum the acctNum to set
	 */
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	public String toString() {
		return this.name + " : " + this.acctNum;
	}
}
