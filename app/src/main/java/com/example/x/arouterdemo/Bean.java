package com.example.x.arouterdemo;

import android.os.Parcel;
import android.os.Parcelable;

import butterknife.internal.Utils;

/**
 * Created by X on 2017/12/18.
 */

public class Bean implements Parcelable {

    String name;
    int age;

    Bean(String name,int age){
        this.name = name;
        this.age = age;
    }




    protected Bean(Parcel in) {

        name = in.readString();
        age = in.readInt();

    }

    public static final Creator<Bean> CREATOR = new Creator<Bean>() {
        @Override
        public Bean createFromParcel(Parcel in) {
            return new Bean(in);
        }

        @Override
        public Bean[] newArray(int size) {
            return new Bean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }

}
