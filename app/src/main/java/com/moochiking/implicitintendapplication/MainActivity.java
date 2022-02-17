package com.moochiking.implicitintendapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    static final String[] ACTIVITY_CHOICES = new String[] {
      "Open Website Example" , "Open Contacts" , "Open Phone Dialer Example" , "Search Google Example" , "Exit"
    };

    final String searchTerms = "pokemon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , ACTIVITY_CHOICES));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setTextFilterEnabled(true);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.android.com")));
                        break;
                    case 1 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")));
                        break;
                    case 2 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0650757849")));
                        break;
                    case 3 :
                        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY , searchTerms);
                        startActivity(intent);
                        break;
                    case 4 :
                        finish();
                        break;
                    default :
                        break;
                }
            }
        });
    }
}