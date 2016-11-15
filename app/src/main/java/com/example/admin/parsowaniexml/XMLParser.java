package com.example.admin.parsowaniexml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/15/2016.
 */

public class XMLParser extends DefaultHandler{

    List<XmlValuesModel> list = null;

    StringBuilder builder;
    XmlValuesModel jobsValues = null;

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<XmlValuesModel>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        builder = new StringBuilder();

        if (localName.equals("login")) {

        } else if (localName.equals("status")) {

        } else if (localName.equals("jobs")) {

        } else if (localName.equals("job")) {
            jobsValues = new XmlValuesModel();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (localName.equals("job")) {
            list.add(jobsValues);
        } else
            if (localName.equalsIgnoreCase("status")) {

            } else
            if (localName.equalsIgnoreCase("id")) {
                jobsValues.setId(Integer.parseInt(builder.toString()));

            } else
        if (localName.equalsIgnoreCase("companyid")) {
            jobsValues.setCompanyid(Integer.parseInt(builder.toString()));

        }
        else
        if (localName.equalsIgnoreCase("company")) {
            jobsValues.setCompany(builder.toString());

        }
        else
        if (localName.equalsIgnoreCase("adress")) {
            jobsValues.setAddress(builder.toString());

        }
        else
        if (localName.equalsIgnoreCase("city")) {
            jobsValues.setCity(builder.toString());

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tempString = new String(ch, start, length);
        builder.append(tempString);

    }
}
