package com.example.administrator.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.test.Adapter.ContactAdapter;
import com.example.administrator.test.Adapter.IconAdapter;
import com.example.administrator.test.Date.ContactDate;
import com.gjiazhe.wavesidebar.WaveSideBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ContactDate> list = null;
    public ContactDate contactDate;
    private ListView listView_Contact;
    private ListView listView_Icon;
    public ContactAdapter contactAdapter;
    public IconAdapter iconAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_Contact = (ListView) findViewById(R.id.listView_Contact) ;
        listView_Icon = (ListView) findViewById(R.id.listView_Icon) ;
        initDate();
        initSideBar();
    }

    public void initDate() {
        list = new ArrayList<ContactDate>();
        for(int i = 0; i < 50; i++) {
            contactDate = new ContactDate();
            if (i < 10){
                contactDate.setSort("A");
            }else if(i < 20) {
                contactDate.setSort("B");
            }else if(i < 30) {
                contactDate.setSort("C");
            }else if(i < 40) {
                contactDate.setSort("D");
            }else if(i < 50) {
                contactDate.setSort("F");
            }
            contactDate.setSelected(true);
            contactDate.setContactName("姓名" + String.valueOf(i));
            if(i % 10 == 0) {
                contactDate.setVisible(View.VISIBLE);
            } else {
                contactDate.setVisible(View.GONE);
            }
            list.add(contactDate);
        }
        contactAdapter = new ContactAdapter(this, list);
        listView_Contact.setAdapter(contactAdapter);
        iconAdapter = new IconAdapter(this, list);
        listView_Icon.setAdapter(iconAdapter);

//        listView_Contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Log.e("contact_item", "点击了一下contact_item");
//            }
//        });
    }

    public void initSideBar() {
        WaveSideBar sideBar = (WaveSideBar) findViewById(R.id.side_bar);
        sideBar.setIndexItems("↑","☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#");
        sideBar.setLazyRespond(true);


        sideBar.setMaxOffset(100);
        sideBar.setPosition(WaveSideBar.POSITION_LEFT);
        sideBar.setTextAlign(WaveSideBar.TEXT_ALIGN_CENTER);
        sideBar.setLazyRespond(true);

        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                Log.d("WaveSideBar", index);
                // Do something here ....
                for (int i = 0; i < list.size(); i++){
                    if (list.get(i).getSort().equals(index)){
                        listView_Contact.smoothScrollToPosition(i);
                        contactAdapter.notifyDataSetChanged();
                        return;
                    }
                }
            }
        });
    }
}
