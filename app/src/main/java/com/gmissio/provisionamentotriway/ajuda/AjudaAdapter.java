package com.gmissio.provisionamentotriway.ajuda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.gmissio.provisionamentotriway.R;

import java.util.HashMap;
import java.util.List;

public class AjudaAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> topicos;
    HashMap<String,List<String>> listItem;

    public AjudaAdapter(Context context,List<String> topicos, HashMap<String,List<String>>listItem){
        this.context = context;
        this.topicos = topicos;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return topicos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItem.get(this.topicos.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.topicos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItem.get(this.topicos.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.topicos,null);
        }

        TextView textView = convertView.findViewById(R.id.list_titulo);
        textView.setText(group);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_ajuda,null);
        }

        TextView textView = convertView.findViewById(R.id.list_corpo);
        textView.setText(child);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
