package com.eugez.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button btn;
    EditText editTxt;
    TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        editTxt = (EditText) findViewById(R.id.editText);
        txtView = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (editTxt.length() > 5) {
            txtView.setText("Длина ID 5!");
            return;
        } else if (editTxt.length() < 5) {
            txtView.setText("Длина ID 5!");
            return;
        } else {
            switch (view.getId()) {
                case R.id.button:
                    //call second activity
                    Intent intent = new Intent(this, Results.class);
                    startActivity(intent);
                    break;
                default:
                    Toast.makeText(this, "Not implemented yet!", Toast.LENGTH_SHORT);
                    break;
            }
        }
    }

    public void onClickMenu(MenuItem menu) {
        switch (menu.getItemId()){
            case R.id.information_settings:
                Intent intent1 = new Intent(this, Settings.class);
                startActivity(intent1);
                break;
            case R.id.results_settings:
                Intent intent2 = new Intent(this, Results.class);
                startActivity(intent2);
                break;
        }
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
