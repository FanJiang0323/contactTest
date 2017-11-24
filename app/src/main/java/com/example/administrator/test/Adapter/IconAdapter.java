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

/**
 * Created by Administrator on 2017-11-21.
 */

public class IconAdapter extends BaseAdapter {

    private ArrayList<ContactDate> list = null;
    private Context mContext;

    public IconAdapter(){super();}

    public IconAdapter(Context mContext, ArrayList<ContactDate> list){
        this.mContext = mContext;
        this.list = list;
        Log.i("ContactAdapter","list length is:" + list.size());
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
        IconAdapter.ViewHolder holder = null;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.icon_item, parent, false);
            holder = new IconAdapter.ViewHolder();
            holder.imageView_Icon = convertView.findViewById(R.id.imageView_icon);
            convertView.setTag(holder);
        }else {
            holder = (IconAdapter.ViewHolder)convertView.getTag();
        }
//        ContactDate contactDate = getItem(position);
//        if (contactDate.getSelected()){
//            holder.imageView_Icon.setVisibility(View.VISIBLE);
//        } else {
//            holder.imageView_Icon.setVisibility(View.GONE);
//        }


        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public class ViewHolder {
        public ImageView imageView_Icon;
    }
}
