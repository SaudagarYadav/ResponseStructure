package com.responseStructure.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.xml.sax.InputSource;

public class XMLService {
	public static <T> String createRequestXml(final Class<T> inputClass, final T input)
			throws JAXBException, PropertyException {

		final JAXBContext jaxbContext = JAXBContext.newInstance(inputClass);
		final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		final StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(input, writer);

		final String requestXml = writer.toString().trim();
		return requestXml;
	}

	public static <T> T performUnmarshaling(final Class<T> inputClass, final String sourceXML) {
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance(inputClass);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			final InputSource source = new InputSource(new StringReader(sourceXML));
			return inputClass.cast(jaxbUnmarshaller.unmarshal(source));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param <T>
	 * @param inputClass
	 * @param data
	 * @param rootElement
	 * @param fileLocation
	 * @return
	 * @throws JAXBException
	 */
	public static <T> String createXML(final Class<T> inputClass, final T data, final String rootElement) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(inputClass);
		Marshaller marshaller = jaxbContext.createMarshaller();
		JAXBElement<T> jaxbElement = new JAXBElement<T>(new QName("", rootElement), inputClass, data);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbElement.setNil(true);
		final StringWriter writer = new StringWriter();
		marshaller.marshal(jaxbElement, writer);
		return writer.toString().trim();
	}


}
