package com.example.abhishekjain.framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.commoncontrols.ListItemActionListener;
import com.example.commoncontrols.ItemPickerDialogFragment;
import com.example.commoncontrols.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListItemActionListener {

    private ArrayList<ListItem> textItemArrayList;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);
        textView.setOnClickListener(this);
        textItemArrayList = new ArrayList<>();
        textItemArrayList.add(new TextItem("Item 1"));
        textItemArrayList.add(new TextItem("Item 2"));
        textItemArrayList.add(new TextItem("Item 3"));
        textItemArrayList.add(new TextItem("Item 4"));
        textItemArrayList.add(new TextItem("Item 5"));
        textItemArrayList.add(new TextItem("Item 6"));

    }

    @Override
    public void onClick(View v) {
        ItemPickerDialogFragment itemPickerDialogFragment = ItemPickerDialogFragment.newInstance(textItemArrayList, null);
        itemPickerDialogFragment.show(getSupportFragmentManager(), "Tag");
    }

    @Override
    public void onSelect(ListItem listItem) {
        textView.setText(listItem.getName());
    }

    @Override
    public void onCancel() {

    }
}
