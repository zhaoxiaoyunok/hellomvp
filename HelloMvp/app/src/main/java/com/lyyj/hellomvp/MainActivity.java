package com.lyyj.hellomvp;

import android.animation.ObjectAnimator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity {
    private MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("hello mvp");
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab =
                (FloatingActionButton) findViewById(R.id.fab_edit_task);
        checkNotNull(fab, "fab not found in layout");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator oa = ObjectAnimator.ofFloat(v, "rotation", 0f,180f, 360f);
                oa.setDuration(1000);
                oa.start();
//                ObjectAnimator oa1 = ObjectAnimator.ofFloat(v, "rotation", 0f,-45f);
//                oa1.setDuration(500);
//                oa1.start();
                mMainPresenter.getData();
            }
        });
        MainView mainView = (MainView) findViewById(R.id.main_view);
        checkNotNull(mainView, "main_view not found in layout");

        mMainPresenter = new MainPresenter( Repository.getInstance( ),mainView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.start();
    }
}
