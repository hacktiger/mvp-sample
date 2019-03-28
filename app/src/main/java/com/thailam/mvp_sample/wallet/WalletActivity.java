package com.thailam.mvp_sample.wallet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thailam.mvp_sample.R;

import java.util.List;

public class WalletActivity extends AppCompatActivity implements WalletContract.View {

	private WalletPresenter mWalletPresenter;
	private Button mLoadBtn;
	private ProgressBar mProgressBar;
	private TextView mTxt1, mTxt2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// init comps
		initPresenter();
		initButton();
		initTxtView();
		initProgressBar();
	}

	@Override
	public void setProgressBar() {
		mProgressBar.setVisibility(View.INVISIBLE);
	}

	@Override
	public void showWallets(List<WalletModel> list) {
		mTxt1.setText(list.get(0).getmName());
		mTxt2.setText(list.get(1).getmName());
	}

	private void initPresenter() {
		mWalletPresenter = new WalletPresenter(this);
	}

	private void initButton() {
		mLoadBtn = findViewById(R.id.btn_show);
		mLoadBtn.setOnClickListener(v -> {
			mWalletPresenter.getData();
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
