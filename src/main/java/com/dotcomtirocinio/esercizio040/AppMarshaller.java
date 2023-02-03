package com.dotcomtirocinio.esercizio040;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.w3c.dom.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.InputStream;


@EnableWebMvc  //utilizzato per abilitare Spring MVC
@Configuration
public class AppMarshaller {



//    Oggetti Java in dati XML
    @Bean("xmlMarshaller")
    public Jaxb2Marshaller getMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Parametri.class);

        return marshaller;
    }

//    XML per oggetti Java.
    @Bean
    public Parametri getParametri() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext   = JAXBContext.newInstance(Parametri.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

//    Ottieni file XML
        InputStream is = Parametri.class.getResourceAsStream("/web.xml");
        Parametri param = (Parametri) jaxbUnmarshaller.unmarshal(is);

//    Ottieni il valore della proprietà del "risultato = parametro_uno + parametro_due + parametro_tre"
//        XmlCalField = param.getRisultato();

        return param;
    }

}



