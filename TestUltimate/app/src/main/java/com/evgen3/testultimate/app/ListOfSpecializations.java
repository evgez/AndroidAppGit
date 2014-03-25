package com.evgen3.testultimate.app;

import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ListOfSpecializations extends ActionBarActivity implements View.OnClickListener {

    TextView tvWebPage;
    Button   btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_specializations);

        tvWebPage   =   (TextView)findViewById(R.id.tvWebPage);
        btnConnect  =   (Button)  findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(this);
    }

    private String readStream(InputStream in) throws IOException {
        StringBuilder sb  = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr,1000);
        while(!br.readLine().isEmpty()){
            sb.append(br.readLine());
        }
        in.close();

        return sb.toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_of_specializations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void downloadInfo(){
        Boolean correct = URLUtil.isValidUrl("http://ac.opu.ua/2014/xml/xml_vstup_onpu.php");

        if (!correct) {
            Toast.makeText(this, "Нет такого ID.", Toast.LENGTH_SHORT).show();
            return;
        }

        URL link;
        try {
            Toast.makeText(this, "Загрузка началась.", Toast.LENGTH_SHORT).show();
            link = new URL("http://ac.opu.ua/2014/xml/xml_vstup_onpu.php");
            URLConnection uC = link.openConnection();
            InputStream in   = new BufferedInputStream(uC.getInputStream());
            readStream(in);

        } catch (MalformedURLException e) {
            Log.d("=======error!", e.toString());
        } catch (IOException e) {
            Log.d("=======error!", e.toString());
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
          case R.id.btnConnect:
            downloadInfo();
              break;

        }
    }
}
