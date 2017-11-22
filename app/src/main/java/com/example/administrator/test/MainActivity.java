package com.example.administrator.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.test.Adapter.ContactAdapter;
import com.example.administrator.test.Date.ContactDate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ContactDate> list = null;
    public ContactDate contactDate;
    private ListView listView_Contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_Contact = (ListView) findViewById(R.id.listView_Contact) ;
        initDate();
    }

    public void initDate() {
        list = new ArrayList<ContactDate>();
        for(int i = 0; i < 20; i++) {
            contactDate = new ContactDate();
            contactDate.setSort("A");
            contactDate.setContactName("姓名" + String.valueOf(i));
            if(0 == i) {
                contactDate.setVisible(View.VISIBLE);
            } else {
                contactDate.setVisible(View.GONE);
            }
            list.add(contactDate);
        }
        ContactAdapter contactAdapter = new ContactAdapter(this, list);
        listView_Contact.setAdapter(contactAdapter);
    }
}
