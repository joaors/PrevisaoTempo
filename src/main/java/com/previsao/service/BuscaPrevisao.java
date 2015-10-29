package com.previsao.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import com.previsao.ws.net.webservicex.GlobalWeatherSoap;
import com.previsao.xmlClass.CurrentWeather;


@Stateless
public class BuscaPrevisao {

	private static final String COUNTRY = "Brazil";
	private static final String CITY = "Florianopolis";

	public CurrentWeather buscar() throws Exception {
		try {
			   URL wsdlURL = new URL("http://www.webservicex.net/globalweather.asmx?wsdl");
			   QName serviceName = new QName("http://www.webserviceX.NET", "GlobalWeather");
			   Service service = Service.create(wsdlURL, serviceName);
			   GlobalWeatherSoap port = service.getPort(GlobalWeatherSoap.class);
				//Set timeout until a connection is established
			   ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.connectionTimeout", "15000");

				//Set timeout until the response is received
			   ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.receiveTimeout", "15000");			
				
				String cities = port.getCitiesByCountry(COUNTRY);
				if (!cities.contains(CITY)) {
					throw new Exception("Cidade não encontrada");
				}
				String previsao = getStringPrevisao(cities, port);
				saveFile(previsao);
				CurrentWeather c = unmarshalFilePrevisao(previsao);			
			
			
			/*
			GlobalWeather service = new GlobalWeather();
			GlobalWeatherSoap port = service.getGlobalWeatherSoap();
			//Set timeout until a connection is established
			//((BindingProvider)service).getRequestContext().put("javax.xml.ws.client.connectionTimeout", "1000");

			//Set timeout until the response is received
			//((BindingProvider) service).getRequestContext().put("javax.xml.ws.client.receiveTimeout", "1000");			
			
			String cities = port.getCitiesByCountry(COUNTRY);
			if (!cities.contains(CITY)) {
				throw new Exception("Cidade não encontrada");
			}
			String previsao = getStringPrevisao(cities, port);
			saveFile(previsao);
			CurrentWeather c = unmarshalFilePrevisao(previsao);
			*/
			return c;			
		} catch (javax.xml.ws.WebServiceException e) {
			throw new Error("Servidor de previsão não respondendo, tente novamente mais tarde.", e);
		}
	}
	
	private String getStringPrevisao(String cities, GlobalWeatherSoap port) {
		try {
			Integer idxBegin = cities.indexOf(CITY);
			Integer idxEnd = cities.indexOf("<", idxBegin);
			String cidade = cities.substring(idxBegin, idxEnd);
			String previsao = port.getWeather(cidade, COUNTRY);
			return previsao.replace("utf-16", "ISO-8859-1");     					
		} catch (Exception e) {
			throw new Error("Problemas ao separar previsão do tempo da cidade", e);
		}
	}

	private CurrentWeather unmarshalFilePrevisao(String previsao) throws Exception {		
		try {
			File file = new File("previsao.xml");
			JAXBContext context;
			context = JAXBContext.newInstance("com.previsao.xmlClass");
			Unmarshaller umn = context.createUnmarshaller();			
			return (CurrentWeather) umn.unmarshal(file);
		} catch (JAXBException e) {
			throw new Exception("Problemas ao fazer Unmarshal do arquivo xml", e);
		}	            
	}
	
	private void saveFile(String previsao) throws Exception {
		java.io.FileWriter fw = null; 
		try {
			fw = new java.io.FileWriter("previsao.xml");
			fw.write(previsao);
			fw.flush();
		} catch (IOException e) {
			throw new Exception("Problemas ao Salvar arquivo xml com previsão", e);
		} finally {
			if (!Objects.isNull(fw)) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new Exception("Problemas ao fechar o arquivo xml", e);
				}
			}			
		}
	}

}
