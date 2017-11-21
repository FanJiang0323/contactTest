package com.example.administrator.test.Date;

import android.net.Uri;

import java.net.URL;

/**
 * Created by Administrator on 2017-11-21.
 */

public class ContactDate {
    public  String  sort="";                //名字对应的字母
    public  String  contactName = "";      //联系人姓名
    public  Uri iconUri = null;             //头像地址
    public  boolean selected=false;     //是否被选中

    public String getSort(){
        return  sort;
    }

    public void setcontactName(String sort){
        this.sort = sort;
    }

    public String getContactName(){
        return  contactName;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    public Uri getIconUri(){
        return iconUri;
    }

    public void setIconUri(Uri iconUri){
        this.iconUri = iconUri;
    }

    public boolean getSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }
}
