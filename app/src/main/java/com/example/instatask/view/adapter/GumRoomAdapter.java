package com.example.instatask.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instatask.R;
import com.example.instatask.model.dto.GumRoom;
import com.example.instatask.presenter.GumActivityPresenter;
import com.example.instatask.util.StringUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class GumRoomAdapter extends RecyclerView.Adapter<GumRoomAdapter.ViewHolder> {
    private List<GumRoom> gumRooms;
    private GumActivityPresenter presenter;

    public GumRoomAdapter(List<GumRoom> gumRooms, GumActivityPresenter presenter) {
        this.gumRooms = gumRooms;
        this.presenter = presenter;
    }

    /**
     * @param gumRooms List<GumRoom>.
     */
    public void setGumRooms(List<GumRoom> gumRooms) {
        this.gumRooms = gumRooms;
        notifyDataSetChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gum, parent, false);
        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GumRoom gumRoom = gumRooms.get(position);
        holder.textViewGumTitle.setText(gumRoom.getTitle());
        holder.textViewDescription.setText(gumRoom.getDescription());

        final Context context = holder.cardImage.getContext();
        String open = context.getResources().getString(R.string.prefix_open)
                + " " + StringUtil.formatStringTimeWithoutSecond(gumRoom.getTimeOpen());
        String close = context.getResources().getString(R.string.prefix_close)
                + " " + StringUtil.formatStringTimeWithoutSecond(gumRoom.getTimeClose());

        holder.textViewTimeOpen.setText(open);
        holder.textViewTimeClose.setText(close);

        Picasso.with(context)
                .load(gumRoom.getImage())
                .into(holder.cardImage);
        holder.cardView.setOnClickListener(v ->
                presenter.onItemClick(gumRoom.getId()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemCount() {
        return gumRooms.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_gum)
        CardView cardView;
        @BindView(R.id.card_image)
        ImageView cardImage;
        @BindView(R.id.card_title)
        TextView textViewGumTitle;
        @BindView(R.id.tv_gum_description)
        TextView textViewDescription;
        @BindView(R.id.tv_time_open)
        TextView textViewTimeOpen;
        @BindView(R.id.tv_time_close)
        TextView textViewTimeClose;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
