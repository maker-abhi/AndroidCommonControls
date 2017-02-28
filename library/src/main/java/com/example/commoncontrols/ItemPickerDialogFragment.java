package com.example.commoncontrols;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemPickerDialogFragment extends DialogFragment implements View.OnClickListener, ListItemActionListener {
    private ArrayList<ListItem> allItemsList;
    private ListItemActionListener callback;
//    private ArrayList<ListItem> mostUsedItemsList;

    public ItemPickerDialogFragment() {
    }

    public static ItemPickerDialogFragment newInstance(ArrayList<ListItem> allItemsList, ArrayList<ListItem> mostUsedItemsList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("allItemsList", allItemsList);
        args.putParcelableArrayList("mostUsedItemsList", mostUsedItemsList);

        ItemPickerDialogFragment fragment = new ItemPickerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_picker_dialog, container, false);
        allItemsList = getArguments().getParcelableArrayList("allItemsList");
        getDialog().setTitle("Title");
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        RecyclerView allItemsRecyclerView = (RecyclerView) view.findViewById(R.id.item_picker_recycler_view);
        allItemsRecyclerView.setAdapter(new ItemPickerAdapter(allItemsList, this));
        view.findViewById(R.id.item_picker_dialog_close).setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ListItemActionListener) context;
    }

    @Override
    public void onClick(View v) {
        dismiss();
        callback.onCancel();
    }

    @Override
    public void onSelect(ListItem listItem) {
        dismiss();
        callback.onSelect(listItem);
    }

    @Override
    public void onCancel() {

    }
}
