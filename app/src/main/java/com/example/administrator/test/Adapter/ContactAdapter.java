package com.example.administrator.test.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.test.Date.ContactDate;
import com.example.administrator.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-11-21.
 */

public class ContactAdapter extends BaseAdapter {

    private ArrayList<ContactDate> list = null;
    private Context mContext;

    public ContactAdapter() {
        super();
    }

    public ContactAdapter(Context mContext, ArrayList<ContactDate> list) {
        this.mContext = mContext;
        this.list = list;
        Log.i("ContactAdapter","list length is:" + list.size());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ContactDate getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_item, null);
            holder = new ViewHolder();
            holder.textView_Sort = convertView.findViewById(R.id.textView_sort);
            holder.textView_ContactName = convertView.findViewById(R.id.textView_contactName);
            holder.imageView_ContactIcon = convertView.findViewById(R.id.imageView_contactIcon);
            holder.checkBox_ContactIsCheck = convertView.findViewById(R.id.checkBox_contactIsCheck);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        ContactDate contactDate = getItem(position);
        holder.textView_Sort.setText(contactDate.getSort());
        holder.textView_ContactName.setText(contactDate.getContactName());
//        holder.imageView_ContactIcon.setImageURI(contactDate.getIconUri());
        holder.textView_Sort.setVisibility(contactDate.getVisible());

        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    public class ViewHolder {
        public TextView textView_Sort;
        public TextView textView_ContactName;
        public ImageView imageView_ContactIcon;
        public CheckBox checkBox_ContactIsCheck;
    }
}
