package com.tutor.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button   btnOK;
        Button   btnCancel;
        final TextView tvOut;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK       =   (Button)findViewById(R.id.btnOk);
        btnCancel   =   (Button)findViewById(R.id.btnCancel);
        tvOut       =   (TextView)findViewById(R.id.tvOut);

        View.OnClickListener    ocl = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //по id определяем кнопку вызвавшую разработчик
                switch (view.getId())   {
                    case R.id.btnOk:
                        tvOut.setText(" OK! ");
                        break;
                    case R.id.btnCancel:
                        tvOut.setText(" CANCEL");
                        break;
                }
            }
        };

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

}
