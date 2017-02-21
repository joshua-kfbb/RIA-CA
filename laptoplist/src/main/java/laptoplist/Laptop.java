package laptoplist;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the laptop database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Laptop.findAll", query="SELECT l FROM Laptop l")
public class Laptop implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public enum KBLType {
    	monochrome,
    	color,
    	none,
    }
    
    public enum StorageType{
    	HDD,
    	SSD
    }
	@Column(name="adapter_power")
	private short adapterPower;

	private String cpu;

	private String gpu;

	@Enumerated(EnumType.STRING)
	@Column(name="kb_backlight",columnDefinition="ENUM('monochrome', 'color', 'none')")
	private KBLType kbBacklight;

	@Column(name="l_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lId;

	@Column(name="l_model")
	private String lModel;

	@Column(name="main_mem")
	private short mainMem;

	private String manufacturer;

	@Column(name="screen_resolution")
	private String screenResolution;

	@Column(name="screen_size")
	private BigDecimal screenSize;

	@Column(name="storage_size")
	private short storageSize;
	
	@Enumerated(EnumType.STRING)
	@Column(name="storage_type", columnDefinition="ENUM('HDD', 'SSD')")
	private StorageType storageType;

	@Column(name="video_mem")
	private double videoMem;

	private double weight;

	public Laptop() {
	}

	public short getAdapterPower() {
		return this.adapterPower;
	}

	public void setAdapterPower(short adapterPower) {
		this.adapterPower = adapterPower;
	}

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return this.gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public KBLType getKbBacklight() {
		return this.kbBacklight;
	}

	public void setKbBacklight(KBLType kbBacklight) {
		this.kbBacklight = kbBacklight;
	}

	public int getLId() {
		return this.lId;
	}

	public void setLId(int lId) {
		this.lId = lId;
	}

	public String getLModel() {
		return this.lModel;
	}

	public void setLModel(String lModel) {
		this.lModel = lModel;
	}

	public short getMainMem() {
		return this.mainMem;
	}

	public void setMainMem(short mainMem) {
		this.mainMem = mainMem;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getScreenResolution() {
		return this.screenResolution;
	}

	public void setScreenResolution(String screenResolution) {
		this.screenResolution = screenResolution;
	}

	public BigDecimal getScreenSize() {
		return this.screenSize;
	}

	public void setScreenSize(BigDecimal screenSize) {
		this.screenSize = screenSize;
	}

	public short getStorageSize() {
		return this.storageSize;
	}

	public void setStorageSize(short storageSize) {
		this.storageSize = storageSize;
	}



	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public double getVideoMem() {
		return this.videoMem;
	}

	public void setVideoMem(double videoMem) {
		this.videoMem = videoMem;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}