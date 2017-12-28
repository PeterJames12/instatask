package com.example.instatask.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.instatask.R;
import com.example.instatask.model.dto.Schedule;
import com.example.instatask.util.StringUtil;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class ScheduleAdapter extends ArrayAdapter<Schedule> {
    private static final String LOG_TAG = "my";
    public ScheduleAdapter(@NonNull Context context, List<Schedule> schedules) {
        super(context, R.layout.item_shedule, schedules);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Schedule schedule = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_shedule, null);
        }
        assert schedule != null;
        String start = getFormattedStartTime(schedule.getStart());
        ((TextView) convertView.findViewById(R.id.tv_time_start)).setText(start);

        String end = getFormattedStartTime(schedule.getEnd());
        ((TextView) convertView.findViewById(R.id.tv_time_end)).setText(end);

        String duration = StringUtil.formatStringTimeWithoutSecond(schedule.getDuration());
        ((TextView) convertView.findViewById(R.id.tv_duration)).setText(duration);

        ((TextView) convertView.findViewById(R.id.tv_direction)).setText(schedule.getTitle());
        return convertView;
    }

    private String getFormattedStartTime(String startTime) {
        LocalDateTime dateTime = LocalDateTime.parse(startTime, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
        return fmt.print(dateTime);
    }
}
