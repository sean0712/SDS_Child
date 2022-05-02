package com.teamProject2.sdschild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BoardListAdapter extends BaseAdapter {
    List<Board> boards;
    Context context;
    LayoutInflater inflater;

    public BoardListAdapter(List<Board> boards, Context context) {
        this.boards = boards;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return boards.size();
    }

    @Override
    public Object getItem(int position) {
        return boards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtContent = (TextView) convertView.findViewById(R.id.txtContent);

        Board board = boards.get(position);
        txtTitle.setText(board.id);
        txtContent.setText(board.date);

        return convertView;
    }
}