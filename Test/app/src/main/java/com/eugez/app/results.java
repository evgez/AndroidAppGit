package com.eugez.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Results extends Activity {

    //тестовое название факультетов
    String[] groups = new String[]{"Системная инженерия", "Программная инженерия",
            "Шоколадная инженерия"};

    String[] firstInfo = new String[]{"Рейтинг - 15", "Рейтинг по оригиналам - 10"
            , "Бюджетных мест -12"};
    String[] secondInfo = new String[]{"Рейтинг - 12", "Рейтинг по оригиналам - 1"
            , "Бюджетных мест - 2"};
    String[] thirdInfo = new String[]{"Рейтинг - 5", "Рейтинг по оригиналам - 2"
            , "Бюджетных мест - 25"};

    //коллекция для групп
    ArrayList<Map<String, String>> groupData;
    //коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;
    //общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;

    //список атрибутов группы или элементов
    Map<String, String> m;

    ExpandableListView elvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        groupData = new ArrayList<Map<String, String>>();

        for (String group : groups) {
            m = new HashMap<String, String>();
            m.put("groupName", group);
            groupData.add(m);
        }

        String groupForm[] = new String[]{"groupName"};
        int groupTo[] = new int[]{android.R.id.text1};

        childData = new ArrayList<ArrayList<Map<String, String>>>();


        pushToCollection(firstInfo);
        pushToCollection(secondInfo);
        pushToCollection(thirdInfo);

        String childFrom[] = new String[]{""};
        int childTo[] = new int[]{android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupForm,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo);

        elvMain = (ExpandableListView) findViewById(R.id.expandableListView);
        elvMain.setAdapter(adapter);
    }

    private void pushToCollection(String[] firstInfo) {
        childDataItem = new ArrayList<Map<String, String>>();

        for (String info : firstInfo) {
            m = new HashMap<String, String>();
            m.put("", info);
            childDataItem.add(m);
        }

        childData.add(childDataItem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.results, menu);
        return true;
    }

    public void onClickMenu(MenuItem menu) {
        switch (menu.getItemId()) {
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
