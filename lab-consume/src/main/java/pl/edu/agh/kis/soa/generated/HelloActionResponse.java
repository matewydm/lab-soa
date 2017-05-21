
package pl.edu.agh.kis.soa.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for helloActionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="helloActionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="greet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "helloActionResponse", propOrder = {
    "greet"
})
public class HelloActionResponse {

    protected String greet;

    /**
     * Gets the value of the greet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreet() {
        return greet;
    }

    /**
     * Sets the value of the greet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreet(String value) {
        this.greet = value;
    }

}
