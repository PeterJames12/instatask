package com.example.instatask.presenter;

import android.support.annotation.NonNull;

import com.example.instatask.app.InstaApp;
import com.example.instatask.model.dto.Schedule;
import com.example.instatask.view.DetailActivityView;
import com.example.instatask.view.vo.Day;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class DetailActivityPresenter extends BasePresenter {

    private static final int WEEK_DAYS_AFTER_MONDAY = 6;
    private final DateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private DetailActivityView view;
    private static final String LOG_TAG = "my";

    @Inject
    public DetailActivityPresenter() {
    }

    public DetailActivityPresenter(DetailActivityView view) {
        super();
        InstaApp.getComponent().inject(this);
        this.view = view;
    }

    /**
     * @param hallId int.
     */
    public void fetchData(int hallId) {
        String dataStart = getMondayDate();
        String dataEnd = getSundayDate();
        instaApi.getSchedule(dataStart, dataEnd, hallId).enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(@NonNull Call<List<Schedule>> call, @NonNull Response<List<Schedule>> response) {
                if (response.isSuccessful()) {
                    List<Schedule> scheduleList = response.body();
                    if (scheduleList != null && !scheduleList.isEmpty()) {
                        updateUi(scheduleList);
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Schedule>> call, @NonNull Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }

    private void updateUi(List<Schedule> scheduleList) {
        List<Day> days = mapScheduleToDay(scheduleList);
        view.updateAdapter(days);
    }

    /**
     * @param scheduleList List Schedule object
     * @return mapped object to day.
     */
    private List<Day> mapScheduleToDay(List<Schedule> scheduleList) {
        Set<LocalDate> daySet = new TreeSet<>();
        List<Day> days = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            LocalDate localDate = new DateTime(schedule.getStart()).toLocalDate();
            daySet.add(localDate);
        }

        for (LocalDate localDate : daySet) {
            Day day = new Day();
            day.setDate(getFormattedDate(localDate));
            List<Schedule> schedules = new ArrayList<>();
            for (Schedule schedule : scheduleList) {
                LocalDate date = new DateTime(schedule.getStart()).toLocalDate();
                if (date.equals(localDate)) {
                    schedules.add(schedule);
                }
            }
            day.setSchedules(schedules);
            days.add(day);
        }
        return days;
    }

    /**
     * @return formatted Date.
     */
    private String getFormattedDate(LocalDate localDate) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MMM yyyy");
        return fmt.print(localDate);
    }

    /**
     * @return current formatted Date.
     */
    private String getMondayDate() {
        Calendar calendar = getCalendarWithCurrentMonday();
        return formatter.format(calendar.getTime());
    }

    private Calendar getCalendarWithCurrentMonday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar;
    }

    /**
     * @return current Sunday formatted Date.
     */
    private String getSundayDate() {
        Calendar calendar = getCalendarWithCurrentMonday();
        calendar.add(Calendar.DAY_OF_WEEK, WEEK_DAYS_AFTER_MONDAY);
        return formatter.format(calendar.getTime());
    }
}
