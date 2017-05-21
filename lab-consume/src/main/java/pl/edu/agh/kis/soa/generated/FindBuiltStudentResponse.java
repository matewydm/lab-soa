
package pl.edu.agh.kis.soa.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findBuiltStudentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findBuiltStudentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="builtStudent" type="{http://soa.kis.agh.edu.pl/}student" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findBuiltStudentResponse", propOrder = {
    "builtStudent"
})
public class FindBuiltStudentResponse {

    protected Student builtStudent;

    /**
     * Gets the value of the builtStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getBuiltStudent() {
        return builtStudent;
    }

    /**
     * Sets the value of the builtStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setBuiltStudent(Student value) {
        this.builtStudent = value;
    }

}
