package com.example.admin.parsowaniexml;

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


}
