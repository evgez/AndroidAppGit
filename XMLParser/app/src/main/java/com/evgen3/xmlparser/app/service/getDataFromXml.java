package com.evgen3.xmlparser.app.service;

import android.text.TextUtils;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Евгений on 23.03.2014.
 */
public class getDataFromXml {

    final String LOG_TAG = "myLog";
    StringBuilder stringBuilder = new StringBuilder();
    String tmp = "Dont working yet";
    ArrayList<String> specialnosti = new ArrayList<String>();
    String currentTag = "";


    private XmlPullParser parser;

    public XmlPullParser getParser() {
        return parser;
    }

    public void setParser(XmlPullParser parser) {
        this.parser = parser;
    }

    public void getData(XmlPullParser parser) throws XmlPullParserException {
        while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
            try {
                switch (parser.getEventType()) {
                    //Начало документа
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(LOG_TAG, "START_DOCUMENT");
                        break;

                    case XmlPullParser.START_TAG:
                        Log.d(LOG_TAG, "START_TAG: name = " + parser.getName());
                        currentTag = parser.getName();
                        tmp = "";
                        for (int i = 0; i < parser.getAttributeCount(); i++) {
                            tmp = tmp + parser.getAttributeName(i) +
                                    " : " + parser.getAttributeValue(i) + "\n";
                        }

                        if (!TextUtils.isEmpty(tmp))
                            Log.d(LOG_TAG, "Attributes: " + tmp);
                        break;

                    //конец тега
                    case XmlPullParser.END_TAG:
                        Log.d(LOG_TAG, "text = " + parser.getText());
                        break;

                    case XmlPullParser.TEXT:
                        Log.d(LOG_TAG, " text = " + parser.getText());
                        if (currentTag.equals("person")) {
                            final String person = parser.getText();
                            currentTag = "";
                            break;
                        }
                        if (currentTag.equals("speciality")) {
                            specialnosti.add(parser.getText());
                            currentTag = "";
                            break;
                        }
                        stringBuilder.append(parser.getText() + "\n");
                        break;
                    default:
                        break;
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            //следующий элемент
            try {
                parser.next();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Log.d(LOG_TAG, "END DOCUMENT");
        }


    }
}