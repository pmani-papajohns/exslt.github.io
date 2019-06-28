package com.papajohns;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

public class XMLTransformer_Facility {

	final static Logger logger = Logger.getLogger(XMLTransformer_Facility.class);
	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException {
		
		try {	
		String val = "";
		String val2 = "";
		logger.debug("Before Starts");
		File idval = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Manhattan_Facility.xml");
		
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(idval);
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("Facility");		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);							
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			val = eElement.getElementsByTagName("PrimaryFacilityAliasId").item(0).getTextContent();
			}
		}
		val2 = "00369";
		
		if(val.equals(val2))
		{
		change_Entity();		
		}
		else
		{
		add_Entity();
		}
	}	
	catch (Exception e) {
    e.printStackTrace();
    }
	}
	public static void add_Entity()
	{
		try{
		System.out.println("Testing AddEntity");
		File inputfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Manhattan_Facility.xml");
		File interfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Facility_AddEntity.xsl");
		File outputfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Jda_Facility_AddEntity.xml");
		
		StreamSource inpSource = new StreamSource(inputfile);
		StreamSource styleSource = new StreamSource(interfile);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
		transformer.transform(inpSource, new StreamResult(outputfile));
		}
		catch (Exception e) {
			logger.error("Error>>>", e);
		}
	}
	public static void change_Entity()
	{
		try{
		System.out.println("Testing ChangeEntity");
		File inputfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Manhattan_Facility.xml");
		File interfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Facility_ChangeEntity.xsl");
		File outputfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Jda_Facility_ChangeEntity.xml");
		
		StreamSource inpSource = new StreamSource(inputfile);
		StreamSource styleSource = new StreamSource(interfile);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
		transformer.transform(inpSource, new StreamResult(outputfile));
		}
		catch (Exception e) {
			logger.error("Error>>>", e);
		}
	}
}
