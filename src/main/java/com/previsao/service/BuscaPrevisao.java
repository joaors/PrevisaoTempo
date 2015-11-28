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
import java.io.StringReader;

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
            String previsao = port.getWeather(CITY, COUNTRY);
            CurrentWeather c = unmarshalFilePrevisao(previsao);
            return c;
        } catch (javax.xml.ws.WebServiceException e) {
            throw new Error("Servidor de previsão não respondendo, tente novamente mais tarde.", e);
        }
    }

    private CurrentWeather unmarshalFilePrevisao(String previsao) throws Exception {
        try {
            JAXBContext context = JAXBContext.newInstance(CurrentWeather.class);
            Unmarshaller umn = context.createUnmarshaller();
            return (CurrentWeather) umn.unmarshal(new StringReader(previsao));
        } catch (JAXBException e) {
            throw new Exception("Problemas ao fazer Unmarshal do arquivo xml", e);
        }
    }

}
