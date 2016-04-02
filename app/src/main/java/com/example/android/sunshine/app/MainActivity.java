package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        //String yang akan dimasukan ke dalam listview
        String[] weathers = {
                "Today - Sunny - 88 / 63",
                "Monday - Sunny - 78 / 63",
                "Tuesday - Sunny - 83 / 63",
                "Wednesday - Sunny - 84 / 63",
                "Thursday - Sunny - 85 / 63",
                "Friday - Sunny - 86 / 63",
                "Saturday - Sunny - 87 / 63",
                "Sunday - Sunny - 88 / 63",
                "Monday - Sunny - 78 / 63",
                "Tuesday - Sunny - 83 / 63",
                "Wednesday - Sunny - 84 / 63",
                "Thursday - Sunny - 85 / 63",
                "Friday - Sunny - 86 / 63"
        };

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //root view untuk menuju fragmen
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //adapter untuk mengatur tampilan string ke dalam listview

            /*1 elemen view menggunakan 1 adapter*/
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    //referensi ke aktiviti yang sedang digunakan
                    getActivity(),
                    //file layout yang akan dijadikan list view
                    R.layout.list_item_forecast,
                    //id view dari elemen yang akan dijadikan list view
                    R.id.list_item_forecast_textview,
                    //data string
                    weathers);
            //referensi list view di fragment
            ListView listview = (ListView)rootView.findViewById(R.id.forecast_listview);
            //menerapkan adapter ke dalam listview
            listview.setAdapter(adapter);

            return rootView;
        }
    }
}
