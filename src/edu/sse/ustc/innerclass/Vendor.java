package edu.sse.ustc.innerclass;

/**
 * Vendor entity. @author MyEclipse Persistence Tools
 */

public class Vendor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mac;
	private String vendor;

	// Constructors

	/** default constructor */
	public Vendor() {
	}

	/** minimal constructor */
	public Vendor(String mac) {
		this.mac = mac;
	}

	/** full constructor */
	public Vendor(String mac, String vendor) {
		this.mac = mac;
		this.vendor = vendor;
	}

	// Property accessors

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}