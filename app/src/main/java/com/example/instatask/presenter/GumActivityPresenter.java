package com.example.instatask.presenter;

import com.example.instatask.app.InstaApp;
import com.example.instatask.model.dto.GumRoom;
import com.example.instatask.view.impl.DetailActivity;
import com.example.instatask.view.GumActivityView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class GumActivityPresenter extends BasePresenter {
    private GumActivityView view;

    @Inject
    public GumActivityPresenter() {
    }

    public GumActivityPresenter(GumActivityView view) {
        super();
        InstaApp.getComponent().inject(this);
        this.view = view;
    }

    /**
     * Bind onCreate.
     */
    public void onCreate() {
        instaApi.getRooms().enqueue(new Callback<List<GumRoom>>() {
            @Override
            public void onResponse(Call<List<GumRoom>> call, Response<List<GumRoom>> response) {
                if (response.isSuccessful()) {
                    List<GumRoom> gumList = response.body();
                    if (gumList != null && !gumList.isEmpty()) {
                        view.showGums(gumList);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GumRoom>> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }

    /**
     * @param hallId id hall currentItem.
     */
    public void onItemClick(int hallId) {
        view.startActivity(hallId, DetailActivity.class);
    }
}
