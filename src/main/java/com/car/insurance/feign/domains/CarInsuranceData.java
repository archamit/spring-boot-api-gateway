/**
 * 
 */
package com.car.insurance.feign.domains;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 *
 */
public class CarInsuranceData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280555932856033773L;
	
	private String id;
	private String ownerName;
	private String carModel;
	private String carManufacturer;
	private String manufacturingYear;
	private String engineCapacity;
	private String bodyColor;
	private Date currentInsuranceValidTill;
	private Date newInsuranceDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName
	 *            the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the carModel
	 */
	public String getCarModel() {
		return carModel;
	}

	/**
	 * @param carModel
	 *            the carModel to set
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	/**
	 * @return the carManufacturer
	 */
	public String getCarManufacturer() {
		return carManufacturer;
	}

	/**
	 * @param carManufacturer
	 *            the carManufacturer to set
	 */
	public void setCarManufacturer(String carManufacturer) {
		this.carManufacturer = carManufacturer;
	}

	/**
	 * @return the manufacturingYear
	 */
	public String getManufacturingYear() {
		return manufacturingYear;
	}

	/**
	 * @param manufacturingYear
	 *            the manufacturingYear to set
	 */
	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	/**
	 * @return the engineCapacity
	 */
	public String getEngineCapacity() {
		return engineCapacity;
	}

	/**
	 * @param engineCapacity
	 *            the engineCapacity to set
	 */
	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	/**
	 * @return the bodyColor
	 */
	public String getBodyColor() {
		return bodyColor;
	}

	/**
	 * @param bodyColor
	 *            the bodyColor to set
	 */
	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	/**
	 * @return the currentInsuranceValidTill
	 */
	public Date getCurrentInsuranceValidTill() {
		return currentInsuranceValidTill;
	}

	/**
	 * @param currentInsuranceValidTill
	 *            the currentInsuranceValidTill to set
	 */
	public void setCurrentInsuranceValidTill(Date currentInsuranceValidTill) {
		this.currentInsuranceValidTill = currentInsuranceValidTill;
	}

	/**
	 * @return the newInsuranceDate
	 */
	public Date getNewInsuranceDate() {
		return newInsuranceDate;
	}

	/**
	 * @param newInsuranceDate
	 *            the newInsuranceDate to set
	 */
	public void setNewInsuranceDate(Date newInsuranceDate) {
		this.newInsuranceDate = newInsuranceDate;
	}

}
