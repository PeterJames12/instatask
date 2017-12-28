package com.example.instatask.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.instatask.R;
import com.example.instatask.di.component.DaggerDetailComponent;
import com.example.instatask.di.component.DetailComponent;
import com.example.instatask.di.module.DetailActivityDynamicModule;
import com.example.instatask.presenter.DetailActivityPresenter;
import com.example.instatask.util.Constants;
import com.example.instatask.view.DetailActivityView;
import com.example.instatask.view.adapter.DaysAdapter;
import com.example.instatask.view.vo.Day;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class DetailActivity extends AppCompatActivity implements DetailActivityView {

    private static final String BUNDLE_HALL_ID = "bundle_hall_id";
    @Inject
    DetailActivityPresenter presenter;
    @BindView(R.id.root_detail)
    CoordinatorLayout rootView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.days_recycler)
    RecyclerView recyclerViewDay;
    private DetailComponent component;
    private int hallId;
    private DaysAdapter adapter;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (component == null) {
            component = DaggerDetailComponent.builder()
                    .detailActivityDynamicModule(new DetailActivityDynamicModule(this))
                    .build();
        }
        component.inject(this);

        if (savedInstanceState == null) {
            hallId = getIntent().getIntExtra(Constants.KEY_HALL_ID, 0);
        } else {
            hallId = savedInstanceState.getInt(BUNDLE_HALL_ID);
        }
        presenter.fetchData(hallId);
        initRecycler();
    }

    /**
     * Init RecyclerView.
     */
    private void initRecycler() {
        adapter = new DaysAdapter(new ArrayList<>());
        adapter.setHasStableIds(true);
        recyclerViewDay.setAdapter(adapter);
        recyclerViewDay.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_HALL_ID, hallId);
    }


    /**
     * {@inheritDoc}.
     */
    @Override
    public void updateAdapter(List<Day> daysList) {
        adapter.setDayList(daysList);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void showMessage(String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }
}
