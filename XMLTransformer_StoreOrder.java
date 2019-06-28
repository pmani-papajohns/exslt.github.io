package com.papajohns;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.log4j.Logger;

public class XMLTransformer_StoreOrder {
	

	final static Logger logger = Logger.getLogger(XMLTransformer_StoreOrder.class);
	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException {
		
		try{

		File inputfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Manhattan_StoreOrder.xml");
		File interfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/StoreOrder.xsl");
		File outputfile = new File("C:/Users/791729/workspace/PapaJohns/src/com/papajohns/Jda_StoreOrder.xml");
		
		StreamSource inpSource = new StreamSource(inputfile);
		StreamSource styleSource = new StreamSource(interfile);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
		transformer.transform(inpSource, new StreamResult(outputfile));
		System.out.println("Testing Purchase order");
		
		}
		catch (Exception e) {
			logger.error("Error>>>", e);
		}
	}
}
