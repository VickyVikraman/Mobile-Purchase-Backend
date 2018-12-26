package com.mobile.purchase.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="mobile")
@Table(name="mobile")
public class MobileEntity {
	
	@Id
	private int mobileId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="os")
	private String os;
	
	@Column(name="version")
	private String version;
	
	@Column(name="battery")
	private int battery;
	
	@Column(name="weight")
	private float weight;
	
	@Column(name="ram")
	private int ram;
	
	@Column(name="internal")
	private int internal;
	
	@Column(name="expandable")
	private int expandable;
	
	@Column(name="width")
	private float width;
	
	@Column(name="depth")
	private float depth;
	
	@Column(name="height")
	private float height;

	@Column(name="stock")
	private int stock;
	
	@Column(name="price")
	private int price;
	
	@Column(name="images")
	private String images;
	
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getInternal() {
		return internal;
	}

	public void setInternal(int internal) {
		this.internal = internal;
	}

	public int getExpandable() {
		return expandable;
	}

	public void setExpandable(int expandable) {
		this.expandable = expandable;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
