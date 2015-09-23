//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.22 às 03:30:23 PM BRT 
//


package com.previsao.xmlClass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Wind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Visibility" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SkyConditions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DewPoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RelativeHumidity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pressure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "location",
    "time",
    "wind",
    "visibility",
    "skyConditions",
    "temperature",
    "dewPoint",
    "relativeHumidity",
    "pressure",
    "status"
})
@XmlRootElement(name = "CurrentWeather")
public class CurrentWeather {

    @XmlElement(name = "Location", required = true)
    protected String location;
    @XmlElement(name = "Time", required = true)
    protected String time;
    @XmlElement(name = "Wind", required = true)
    protected String wind;
    @XmlElement(name = "Visibility", required = true)
    protected String visibility;
    @XmlElement(name = "SkyConditions", required = true)
    protected String skyConditions;
    @XmlElement(name = "Temperature", required = true)
    protected String temperature;
    @XmlElement(name = "DewPoint", required = true)
    protected String dewPoint;
    @XmlElement(name = "RelativeHumidity", required = true)
    protected String relativeHumidity;
    @XmlElement(name = "Pressure", required = true)
    protected String pressure;
    @XmlElement(name = "Status", required = true)
    protected String status;

    /**
     * Obtém o valor da propriedade location.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define o valor da propriedade location.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Obtém o valor da propriedade time.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Define o valor da propriedade time.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Obtém o valor da propriedade wind.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWind() {
        return wind;
    }

    /**
     * Define o valor da propriedade wind.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWind(String value) {
        this.wind = value;
    }

    /**
     * Obtém o valor da propriedade visibility.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * Define o valor da propriedade visibility.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibility(String value) {
        this.visibility = value;
    }

    /**
     * Obtém o valor da propriedade skyConditions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkyConditions() {
        return skyConditions;
    }

    /**
     * Define o valor da propriedade skyConditions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkyConditions(String value) {
        this.skyConditions = value;
    }

    /**
     * Obtém o valor da propriedade temperature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Define o valor da propriedade temperature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperature(String value) {
        this.temperature = value;
    }

    /**
     * Obtém o valor da propriedade dewPoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDewPoint() {
        return dewPoint;
    }

    /**
     * Define o valor da propriedade dewPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDewPoint(String value) {
        this.dewPoint = value;
    }

    /**
     * Obtém o valor da propriedade relativeHumidity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    /**
     * Define o valor da propriedade relativeHumidity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelativeHumidity(String value) {
        this.relativeHumidity = value;
    }

    /**
     * Obtém o valor da propriedade pressure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * Define o valor da propriedade pressure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressure(String value) {
        this.pressure = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
