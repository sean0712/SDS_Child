package com.teamProject2.sdschild;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.List;

public class SnackListAdapter extends BaseAdapter {
    List<Item> items;
    Context context;
    LayoutInflater inflater;

    public SnackListAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.snack_list_item, null);
        }

        ImageView ImageViewSnack = (ImageView) convertView.findViewById(R.id.ImageViewSnack);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.TextTitle);
//        TextView txtContent = (TextView) convertView.findViewById(R.id.txtContent);

        Item item = items.get(position);

        String image = item.poster;
        byte[] b = binaryStringToByteArray(image);
        ByteArrayInputStream is = new ByteArrayInputStream(b);
        Drawable reviewImage = Drawable.createFromStream(is, "reviewImage");
        ImageViewSnack.setImageDrawable(reviewImage);

        txtTitle.setText(item.name);
//        txtContent.setText(item.amount);

        return convertView;
    }

    public static byte[] binaryStringToByteArray(String s) {
        int count = s.length() / 8;
        byte[] b = new byte[count];
        for (int i = 1; i < count; ++i) {
            String t = s.substring((i - 1) * 8, i * 8);
            b[i - 1] = binaryStringToByte(t);
        }
        return b;
    }

    public static byte binaryStringToByte(String s) {
        byte ret = 0, total = 0;
        for (int i = 0; i < 8; ++i) {
            ret = (s.charAt(7 - i) == '1') ? (byte) (1 << i) : 0;
            total = (byte) (ret | total);
        }
        return total;
    }
}