package com.evgen3.xmlparser.app.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.evgen3.xmlparser.app.R;
import com.evgen3.xmlparser.app.dialogs.DialogConfirm;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    CharacterPickerDialog cpd;
    String options;
    SharedPreferences spref;
    ConnectivityManager connectivityManager;
    URL connectionURL;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private Bundle savedInstanceState;


    public void setSavedInstanceState(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String url = getResources().getString(R.string.URL);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSavedInstanceState(savedInstanceState);

        //trying to connect
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
//            String id = loadId();
//            //check id
//            if (id.length() > 0) {
//                //connect to server with
//                try {
            try {
                connectionURL = new URL(url + "90001");
                makeToast(connectionURL.toString());
                new DownloadWebPageTask().execute(connectionURL);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
//            } else {
//                //generating new user id
//                CustomDialog customDialog = new CustomDialog();
//                customDialog.setActivity(this);
//                customDialog.onCreateDialog(savedInstanceState).show();
//                try {
//                    connectionURL = new URL(url + loadId());
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//            }


        } else {
            makeToast(getResources().getString(R.string.connecting_error));
        }
        ;


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    private String loadId() {
        String saved_id = "saved_id";
        spref = getPreferences(MODE_PRIVATE);
        String id = spref.getString(saved_id, "");
        return id;
    }

    private void makeToast(String Text) {
        Toast.makeText(this, Text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_example) {
            DialogConfirm dialog = new DialogConfirm();
            dialog.setActivity(this);
            dialog.onCreateDialog(getSavedInstanceState()).show();
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    //download web page
    class DownloadWebPageTask extends AsyncTask<URL, Integer, List<Map<String, String>>> {

        @Override
        protected List<Map<String, String>> doInBackground(URL... strings) {

            try {
                return downloadURL(strings[0]);
            } catch (IOException e) {
                makeToast("Unable to retrieve webpage");
            }

            return null;
        }

        private List<Map<String, String>> downloadURL(URL string) throws IOException {

            InputStream is = null;
            List<Map<String, String>> listData = null;

            try {
                HttpURLConnection conn = (HttpURLConnection) string.openConnection();
                conn.setReadTimeout(10000); //10 seconds
                conn.setConnectTimeout(15000);//15 seconds
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                int response = conn.getResponseCode();
                Log.d("-------response code if 200 then good------", String.valueOf(response));

                is = conn.getInputStream();
                readIT(is, listData);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } finally {

                is.close();

            }


            return listData;
        }

        private List readIT(InputStream is, List<Map<String, String>> listData) throws IOException, XmlPullParserException {
            XmlPullParser parser = Xml.newPullParser();


            Map<String, String> info = null;

            String abiturientName = "";
            String tagName = null;
            String tagText = null;
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            String parserTag = "parser ----- debug";
            while (parser.next() != XmlPullParser.END_DOCUMENT) {

                if (parser.getEventType() == XmlPullParser.START_TAG) {
                    Log.d(parserTag, parser.getName());
                    tagName = parser.getName();
                }

                if (parser.getEventType() == XmlPullParser.END_TAG) {

                    info.put(tagName, tagText);
                    if (tagName.equals("request")) {
                        listData.add(info);
                    }

                }

                if (parser.getEventType() == XmlPullParser.TEXT) {
                    Log.d(parserTag, parser.getText());
                    if (tagName.equals("person")) {
                        abiturientName = parser.getText();
                        mTitle = abiturientName;
                        setTitle(abiturientName);
                    } else {
                        tagText = parser.getText();
                    }
                }

            }

            return listData;
        }
    }


}
