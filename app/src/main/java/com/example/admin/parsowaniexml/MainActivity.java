package com.example.admin.parsowaniexml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView t1;

    List<XmlValuesModel> myData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.b1);
        t1 = (TextView)findViewById(R.id.t1);

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



    }
}
