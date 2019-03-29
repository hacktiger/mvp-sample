package com.thailam.mvp_sample.wallet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thailam.mvp_sample.R;

import java.util.List;

public class WalletActivity extends AppCompatActivity implements WalletContract.View {
    private WalletContract.Presenter mWalletPresenter;
    private ProgressBar mProgressBar;
    private TextView mTxt1, mTxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // test the new indent style
        initButtons();
        initTxtView();
        initProgressBar();
        initPresenter();
    }

    @Override
    public void setProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showWallets(List<Wallet> list) {
        mTxt1.setText(list.get(1).mName);
        mTxt2.setText(list.get(2).mName);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    private void initPresenter() {
        if (mWalletPresenter == null) {
            mWalletPresenter = new WalletPresenter(this);
            mWalletPresenter.initRepository();
        }
    }

    private void initButtons() {
        Button loadBtn = findViewById(R.id.btn_show);
        loadBtn.setOnClickListener(v -> {
            mWalletPresenter.loadData();
        });
        Button addBtn = findViewById(R.id.btn_add);
        addBtn.setOnClickListener(v -> {
            mWalletPresenter.addData(new Wallet(27, "wallet1", 100)); // Dummy data
        });
    }

    private void initTxtView() {
        mTxt1 = findViewById(R.id.text_1);
        mTxt2 = findViewById(R.id.text_2);
    }

    private void initProgressBar() {
        mProgressBar = findViewById(R.id.progress_bar);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
