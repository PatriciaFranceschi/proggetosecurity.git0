package com.dotcomtirocinio.esercizio040;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parametro" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="maggiore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="minore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="nome" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="risultato" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "parametro",
        "risultato"
})
@XmlRootElement(name = "parametri")
public class Parametri<P> {

    @XmlElement(required = true)
    protected List<Parametri.Parametro> parametro;
    @XmlElement(required = true)
    protected String risultato;

    @Override
    public String toString() {
        return "Parametri{" +
                "parametro=" + parametro +
                ", risultato='" + risultato + '\'' +
                '}';
    }

    public List<Parametri.Parametro> getParametro() {
        if (parametro == null) {
            parametro = new ArrayList<Parametri.Parametro>();
        }
        return this.parametro;
    }

    /**
     * Gets the value of the risultato property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRisultato() {
        return risultato;
    }

    /**
     * Sets the value of the risultato property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRisultato(String value) {
        this.risultato = value;
    }

    public void unmarshallList() {
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="maggiore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="minore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="nome" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "maggiore",
            "minore"
    })
    public static class Parametro {

        protected String maggiore;
        protected BigDecimal minore;
        @XmlAttribute(name = "nome", required = true)
        protected String nome;

        public Parametro(String name1, String surname1) {
        }

        public Parametro() {

        }

        /**
         * Gets the value of the maggiore property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public String getMaggiore() {
            return maggiore;
        }

        /**
         * Sets the value of the maggiore property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setMaggiore(String value) {
            this.maggiore = value;
        }

        /**
         * Gets the value of the minore property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getMinore() {
            return minore;
        }

        /**
         * Sets the value of the minore property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setMinore(BigDecimal value) {
            this.minore = value;
        }

        /**
         * Gets the value of the nome property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNome() {
            return nome;
        }

        /**
         * Sets the value of the nome property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNome(String value) {
            this.nome = value;
        }

    }

}