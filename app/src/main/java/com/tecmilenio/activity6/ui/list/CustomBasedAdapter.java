package com.tecmilenio.activity6.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecmilenio.activity6.R;

public class CustomBasedAdapter extends BaseAdapter {

    private Context context;
    private String[] memberList;
    private int[] memberImages;

    public CustomBasedAdapter(Context context, String[] memberList, int[] memberImages) {
        this.context = context;
        this.memberList = memberList;
        this.memberImages = memberImages;
    }

    @Override
    public int getCount() {
        return memberList.length;
    }

    @Override
    public Object getItem(int position) {
        return memberList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // Get the TextView and ImageView from the custom layout
        TextView memberName = convertView.findViewById(R.id.memberName);
        ImageView memberImage = convertView.findViewById(R.id.memberImage);

        // Set the text and image for the current item
        memberName.setText(memberList[position]);
        memberImage.setImageResource(memberImages[position]);

        return convertView;
    }
}
