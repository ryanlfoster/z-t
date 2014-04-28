package com.australia.cqimport.service;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.cqimport.domain.ConsumerBaseFoundationType;

@Service
@Component
public class DefaultConsumerBaseFoundationService implements ConsumerBaseFoundationService {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultConsumerBaseFoundationService.class);

	@SuppressWarnings("unchecked")
	@Override
	public ConsumerBaseFoundationType getByPath(String path) {
		try {
			InputStream file = this.getClass().getClassLoader().getResourceAsStream("prod-content/" + path + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ConsumerBaseFoundationType.class);
			Unmarshaller jaxbUnmarshaller;
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return ((JAXBElement<ConsumerBaseFoundationType>) jaxbUnmarshaller.unmarshal(file)).getValue();
		} catch (Exception e) {
			LOG.error("Error loading file:" + path, e);
		}
		return null;
	}

}
