package com.example.admin.parsowaniexml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.xml.sax.*;
import javax.xml.parsers.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView t1;

    List<XmlValuesModel> myData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        t1 = (TextView) findViewById(R.id.t1);

        final String XMLData = "" +
                "<?xml version=\"1.0\"?>" +
                "<login>" +
                "<status>OK</status>" +
                "<jobs>" +
                "<job>" +
                "<id>4</id><company_id>441</company_id><company>Android Corp1</company><address>Adres1</address><city>Gliwice1</city>" +
                "</job>" +
                "<job>" +
                "<id>4</id><company_id>442</company_id><company>Android Corp2</company><address>Adres2</address><city>Gliwice2</city>" +
                "</job>" +
                "<job>" +
                "<id>4</id><company_id>443</company_id><company>Android Corp3</company><address>Adres3</address><city>Gliwice3</city>" +
                "</job>" +
                "</jobs>" +
                "</login>";

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BufferedReader br = new BufferedReader(new StringReader(XMLData));
                InputSource is = new InputSource(br);
                XMLParser parser = new XMLParser();

                SAXParserFactory factory = SAXParserFactory.newInstance();

                try {
                    SAXParser sp = factory.newSAXParser();
                    XMLReader reader = sp.getXMLReader();
                    reader.setContentHandler(parser);
                    reader.parse(is);
                    myData = parser.list;
                    if (myData != null) {
                        String OutputData = "";

                        for (XmlValuesModel xmlRowData : myData) {
                            if (xmlRowData != null) {

                                int id = xmlRowData.getId();
                                int companyid = xmlRowData.getCompanyid();
                                String company = xmlRowData.getCompany();
                                String adress = xmlRowData.getAddress();
                                String city = xmlRowData.getCity();
                                OutputData += "Job node: \n\n " +
                                        company + " | " +
                                        adress + " | " +
                                        city + " | " +
                                        "\n\n";


                            } else
                                Log.e("Jobs", "Wartosc job jest null");
                        }
                        t1.setText(OutputData);

                    }


                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


    }
}
