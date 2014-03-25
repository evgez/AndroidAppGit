package com.evgen3.dynamiclayoutthirdedition.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar sbWeight;
    Button btn1;
    Button btn2;

    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1     = (Button)  findViewById(R.id.btn1);
        btn2     = (Button)  findViewById(R.id.btn2);

        lParams1    =   (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2    =   (LinearLayout.LayoutParams) btn2.getLayoutParams();

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int leftValue   =   i;
        int rightValue  =   seekBar.getMax() - i;
        //настраивем вес
        lParams1.weight =   leftValue;
        lParams2.weight =   rightValue;
        //в текст кнопок пишем значения переменных
        btn1.setText(String.valueOf(leftValue));
        btn2.setText(String.valueOf(rightValue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Ай щекотно!",Toast.LENGTH_SHORT);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Уфф наконец-то!",Toast.LENGTH_SHORT);
    }
}
