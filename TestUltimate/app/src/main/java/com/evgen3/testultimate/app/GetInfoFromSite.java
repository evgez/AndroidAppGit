package com.evgen3.testultimate.app;

import android.os.AsyncTask;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.net.ContentHandler;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Евгений on 21.03.14.
 */
public class GetInfoFromSite extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser        parser  = factory.newSAXParser();
            XMLReader        reader  = parser.getXMLReader();
            reader.setContentHandler();
            ContentHandler handler = new ContentHandler[];
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
