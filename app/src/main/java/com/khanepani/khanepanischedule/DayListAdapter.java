package com.khanepani.khanepanischedule;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Otimus on 5/23/2016.
 */
public class DayListAdapter extends BaseAdapter {

    private final Activity context;
    private final List<RoutineData> objects;

    static class ViewHolder {
        public TextView day;
        public TextView startTime;

        public TextView endTime;


    }

    public DayListAdapter(Activity context, List<RoutineData> objects) {
        this.context = context;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.day = (TextView) convertView.findViewById(R.id.day);
            viewHolder.startTime = (TextView) convertView.findViewById(R.id.startTime);
            viewHolder.endTime = (TextView) convertView.findViewById(R.id.endTime);
            convertView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        RoutineData routineData = objects.get(position);
        holder.day.setText(routineData.day);
        holder.startTime.setText(routineData.startTime);
        holder.endTime.setText(routineData.endTime);
        return convertView;

    }

}
