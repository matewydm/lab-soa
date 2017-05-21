
package pl.edu.agh.kis.soa.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findStudentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findStudentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getStudent" type="{http://soa.kis.agh.edu.pl/}student" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findStudentResponse", propOrder = {
    "getStudent"
})
public class FindStudentResponse {

    protected Student getStudent;

    /**
     * Gets the value of the getStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getGetStudent() {
        return getStudent;
    }

    /**
     * Sets the value of the getStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setGetStudent(Student value) {
        this.getStudent = value;
    }

}
