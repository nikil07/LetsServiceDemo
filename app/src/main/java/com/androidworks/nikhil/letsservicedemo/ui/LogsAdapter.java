package com.androidworks.nikhil.letsservicedemo.ui;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidworks.nikhil.letsservicedemo.R;
import com.androidworks.nikhil.letsservicedemo.model.LocationLog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nikhil on 24-May-17.
 */
public class LogsAdapter extends BaseAdapter {

    private Activity activity;
    private List<LocationLog> logs;

    public LogsAdapter(Activity activity, List<LocationLog> logs) {
        this.activity = activity;
        this.logs = logs;
    }

    @Override
    public int getCount() {
        return logs.size();
    }

    @Override
    public Object getItem(int i) {
        return logs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * helper method to update list based on new data
     *
     * @param newLogs
     */
    public void updateData(List<LocationLog> newLogs) {
        this.logs = newLogs;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.location_log_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LocationLog log = logs.get(position);
        viewHolder.latLong.setText("(" + String.valueOf(log.getLatitude()) + "," + String.valueOf(log.getLongitude()) + ")");
        viewHolder.timestamp.setText(log.getTimeStamp());


        return convertView;
    }

    static class ViewHolder {

        @BindView(R.id.tv_latlong)
        TextView latLong;
        @BindView(R.id.tv_timestamp)
        TextView timestamp;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
