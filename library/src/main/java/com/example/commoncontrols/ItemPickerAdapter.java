package com.example.commoncontrols;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class ItemPickerAdapter extends RecyclerView.Adapter<ItemPickerAdapter.ContentViewHolder> {
    private final ItemPickerDialogFragment itemPickerDialogFragment;
    private ArrayList<ListItem> allItemsList;

    ItemPickerAdapter(ArrayList<ListItem> allItemsList, ItemPickerDialogFragment itemPickerDialogFragment) {
        this.allItemsList = allItemsList;
        this.itemPickerDialogFragment = itemPickerDialogFragment;
    }


    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.textView.setText(allItemsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return allItemsList.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        ContentViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemPickerDialogFragment.onSelect(allItemsList.get(getAdapterPosition()));
        }
    }
}
