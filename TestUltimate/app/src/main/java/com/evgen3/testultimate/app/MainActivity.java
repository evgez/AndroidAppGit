package com.evgen3.testultimate.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    CheckBox checkBox;
    Button buttonContinue;
    SharedPreferences pref;
    EditText etID;

    final int savedID = 0;
    Boolean saveID = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText) findViewById(R.id.etID);

        buttonContinue = (Button) findViewById(R.id.btnContinue);
        buttonContinue.setOnClickListener(this);

        checkBox = (CheckBox) findViewById(R.id.checkBoxSave);
        checkBox.setOnClickListener(this);

        loadId();

        //если уже есть сохраненный ID то продолжаем работу
        if (etID.getText().toString().length() == 5){
            Intent intent = new Intent(this,ListOfSpecializations.class);
            startActivity(intent);
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

    public void saveId() {
        pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();
        ed.putString(String.valueOf(savedID) ,etID.getText().toString());
        ed.commit();
        Toast.makeText(this,"ID сохранён.",Toast.LENGTH_SHORT).show();
    }

    public void loadId() {
        pref    =   getPreferences(MODE_PRIVATE);

        String saved_ID = pref.getString(String.valueOf(savedID), "");
        etID.setText(saved_ID);
        Toast.makeText(this,"ID загружен: " + saved_ID,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkBoxSave:
                saveID = true;
                break;
            case R.id.btnContinue:
                if (saveID) {
                    saveId();
                }
                Intent intent = new Intent(this,ListOfSpecializations.class);
                startActivity(intent);
                break;
        }
    }
}
