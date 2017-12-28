package com.example.instatask.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.instatask.R;
import com.example.instatask.util.ListViewUtil;
import com.example.instatask.view.vo.Day;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ViewHolder> {

    private List<Day> dayList;

    public DaysAdapter(List<Day> dayList) {
        this.dayList = dayList;
    }

    /**
     * Setter for property 'dayList'.
     *
     * @param dayList Value to set for property 'dayList'.
     */
    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
        notifyDataSetChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_days, parent, false);
        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Day day = dayList.get(position);
        holder.toolbar.setTitle(day.getDate());
        final Context context = holder.listViewTrainig.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        ViewGroup header = (ViewGroup) inflater
                .inflate(R.layout.list_header_layout, holder.listViewTrainig, false);
        holder.listViewTrainig.addHeaderView(header);
        holder.listViewTrainig.setHeaderDividersEnabled(true);
        holder.listViewTrainig.setAdapter(new ScheduleAdapter(context, day.getSchedules()));
        ListViewUtil.setListViewHeightBasedOnItems(holder.listViewTrainig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemCount() {
        return dayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_toolbar)
        Toolbar toolbar;
        @BindView(R.id.list_training)
        ListView listViewTrainig;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
