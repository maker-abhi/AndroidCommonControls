package com.example.abhishekjain.framework;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.commoncontrols.ListItem;

/**
 * Created by Abhishek Jain on 2/25/2017.
 */

class TextItem implements ListItem {

    private String name;

    TextItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private TextItem(Parcel in) {
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TextItem> CREATOR = new Parcelable.Creator<TextItem>() {
        @Override
        public TextItem createFromParcel(Parcel in) {
            return new TextItem(in);
        }

        @Override
        public TextItem[] newArray(int size) {
            return new TextItem[size];
        }
    };
}
