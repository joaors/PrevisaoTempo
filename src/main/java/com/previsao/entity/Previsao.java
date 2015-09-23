package com.previsao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.previsao.xmlClass.CurrentWeather;

@Entity
public class Previsao implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer id;
    private String currentLocation;
    private String currenttime;
    private String wind;
    private String visibility;
    private String skyConditions;
    private String temperature;
    private String dewPoint;
    private String relativeHumidity;
    private String pressure;
    private String status;
    
    @Transient
    private String identity;
    
    Previsao() {}
    
    
	public Previsao(PrevisaoBuilder builder) {
		this.id = builder.id;
		this.currentLocation = builder.location;
		this.currenttime = builder.time;
		this.wind = builder.wind;
		this.visibility = builder.visibility;
		this.skyConditions = builder.visibility;
		this.temperature = builder.temperature;
		this.dewPoint = builder.dewPoint;
		this.relativeHumidity = builder.relativeHumidity;
		this.pressure = builder.pressure;
		this.status = builder.status;
	}

	public static Previsao create(CurrentWeather currentWeather) {
		Previsao p = new Previsao();
		p.setCurrentLocation(currentWeather.getLocation());
		p.setCurrenttime(currentWeather.getTime());
		p.setWind(currentWeather.getTime());
		p.setVisibility(currentWeather.getVisibility());
		p.setSkyConditions(currentWeather.getSkyConditions());
		p.setTemperature(currentWeather.getTemperature());
		p.setDewPoint(currentWeather.getDewPoint());
		p.setRelativeHumidity(currentWeather.getRelativeHumidity());
		p.setPressure(currentWeather.getPressure());
		p.setStatus(currentWeather.getStatus());
		return p;
		
	}

	/**
	 * @return the wind
	 */
	public String getWind() {
		return wind;
	}
	/**
	 * @param wind the wind to set
	 */
	public void setWind(String wind) {
		this.wind = wind;
	}
	/**
	 * @return the visibility
	 */
	public String getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the skyConditions
	 */
	public String getSkyConditions() {
		return skyConditions;
	}
	/**
	 * @param skyConditions the skyConditions to set
	 */
	public void setSkyConditions(String skyConditions) {
		this.skyConditions = skyConditions;
	}
	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the dewPoint
	 */
	public String getDewPoint() {
		return dewPoint;
	}
	/**
	 * @param dewPoint the dewPoint to set
	 */
	public void setDewPoint(String dewPoint) {
		this.dewPoint = dewPoint;
	}
	/**
	 * @return the relativeHumidity
	 */
	public String getRelativeHumidity() {
		return relativeHumidity;
	}
	/**
	 * @param relativeHumidity the relativeHumidity to set
	 */
	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}
	/**
	 * @return the pressure
	 */
	public String getPressure() {
		return pressure;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
    
	/**
	 * @return the currenttime
	 */
	public String getCurrenttime() {
		return currenttime;
	}


	/**
	 * @param currenttime the currenttime to set
	 */
	public void setCurrenttime(String currenttime) {
		this.currenttime = currenttime;
	}

	/**
	 * @return the currentLocation
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}


	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return String.valueOf(id);
	}


	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public static class PrevisaoBuilder {
	    Integer id;		
	    String location;
	    String time;
	    String wind;
	    String visibility;
	    String skyConditions;
	    String temperature;
	    String dewPoint;
	    String relativeHumidity;
	    String pressure;
	    String status;
	    
	    public PrevisaoBuilder id(Integer id) {
	    	this.id = id;
	    	return this;
	    }
	    
	    public PrevisaoBuilder location(String location) {
	    	this.location = location;
	    	return this;
	    }
	    
	    public PrevisaoBuilder time(String time) {
	    	this.time = time;
	    	return this;
	    }
	    
	    public PrevisaoBuilder wind(String wind) {
	    	this.wind = wind;
	    	return this;
	    }
	    
	    public PrevisaoBuilder visibility(String visibility) {
	    	this.visibility = visibility;
	    	return this;
	    }
	    
	    public PrevisaoBuilder skyConditions(String skyConditions) {
	    	this.skyConditions = skyConditions;
	    	return this;
	    }
	    
	    public PrevisaoBuilder temperature(String temperature) {
	    	this.temperature = temperature;
	    	return this;
	    }
	    
	    public PrevisaoBuilder dewPoint(String dewPoint) {
	    	this.dewPoint = dewPoint;
	    	return this;
	    }
	    
	    public PrevisaoBuilder relativeHumidity(String relativiHumidity) {

	    	this.relativeHumidity = relativiHumidity;
	    	return this;
	    }
	    
	    public PrevisaoBuilder pressure(String pressure) {
	    	this.pressure = pressure;
	    	return this;
	    }
	    
	    public PrevisaoBuilder status(String status) {
	    	this.status = status;
	    	return this;
	    }
	    
	    public Previsao build() {
	    	return new Previsao(this);
	    }
	    
	}
    

}
