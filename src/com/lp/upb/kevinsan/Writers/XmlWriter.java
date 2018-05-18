package com.lp.upb.kevinsan.Writers;

import com.lp.upb.kevinsan.Beans.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlWriter {

    private static XmlWriter xmlW;

    public static XmlWriter get(){
        if (xmlW==null){
            xmlW = new XmlWriter();
        }
        return  xmlW;
    }

    public void write(Persona p){
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element entidad = doc.createElement("Persona");
            doc.appendChild(entidad);

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(p.nombre));
            entidad.appendChild(nombre);

            Element apellido = doc.createElement("apellido");
            apellido.appendChild(doc.createTextNode(p.apellido));
            entidad.appendChild(apellido);

            Element edad = doc.createElement("edad");
            edad.appendChild(doc.createTextNode(p.edad));
            entidad.appendChild(edad);

            Element direccion = doc.createElement("direccion");
            direccion.appendChild(doc.createTextNode(p.direccion));
            entidad.appendChild(direccion);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("test.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("Archivo XML guardado correctamente...");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }


    }
}
