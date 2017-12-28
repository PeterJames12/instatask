package com.example.instatask.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instatask.R;
import com.example.instatask.di.component.DaggerGumComponent;
import com.example.instatask.di.component.GumComponent;
import com.example.instatask.di.module.GumDynamicModule;
import com.example.instatask.model.dto.GumRoom;
import com.example.instatask.presenter.GumActivityPresenter;
import com.example.instatask.util.Constants;
import com.example.instatask.view.adapter.GumRoomAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Igor Hnes on 12/26/17.
 */
public class GumActivity extends AppCompatActivity implements GumActivityView {
    @Inject
    GumActivityPresenter presenter;
    @BindView(R.id.root_gum)
    CoordinatorLayout rootView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.gum_recycler)
    RecyclerView recyclerGums;
    private GumComponent component;
    private GumRoomAdapter adapter;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gum);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (component == null) {
            component = DaggerGumComponent.builder()
                    .gumDynamicModule(new GumDynamicModule(this))
                    .build();
        }
        component.inject(this);
        initRecycler();
        presenter.onCreate();
    }

    /**
     * Init Recycler and adapter.
     */
    private void initRecycler() {
        adapter = new GumRoomAdapter(new ArrayList<>(), presenter);
        adapter.setHasStableIds(true);
        recyclerGums.setAdapter(adapter);
        recyclerGums.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showGums(List<GumRoom> gumRooms) {
        adapter.setGumRooms(gumRooms);
    }

    /**
     * @param hallId      item position.
     * @param targetClass Class name.
     */
    @Override
    public void startActivity(int hallId, Class targetClass) {
        Intent intent = new Intent(getApplicationContext(), targetClass);
        intent.putExtra(Constants.KEY_HALL_ID, hallId);
        startActivity(intent);
    }

    /**
     * @param message text message.
     */
    @Override
    public void showMessage(String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }
}
