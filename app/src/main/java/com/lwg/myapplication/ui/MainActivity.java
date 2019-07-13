package com.lwg.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lwg.myapplication.R;
import com.lwg.myapplication.adapters.AnswersAdapter;
import com.lwg.myapplication.models.Item;
import com.lwg.myapplication.models.SOAnswersResponse;
import com.lwg.myapplication.mvp.presenters.MainActivityPresenter;
import com.lwg.myapplication.mvp.view.MainActivityView;

public class MainActivity extends AppCompatActivity implements MainActivityView, AnswersAdapter.itemClickedListener {
    private AnswersAdapter adapter;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new AnswersAdapter(this);
        presenter = new MainActivityPresenter(this);
        presenter.ready();
    }

    @Override
    public void init() {

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void responses(SOAnswersResponse response) {
        adapter.setCountryList(response.getItems());
    }

    @Override
    public void onItemClicked(Item item, int selectedViewYPosition) {
        Log.d("lwg", item.getOwner().getProfileImage());
    }
}
