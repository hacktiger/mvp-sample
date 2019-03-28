package com.thailam.mvp_sample.wallet;

import java.util.ArrayList;
import java.util.List;

public class WalletPresenter implements WalletContract.Presenter {

	private final WalletContract.View mView;
	private List<WalletModel> mList;

	public WalletPresenter(WalletContract.View view) {
		mView = view;
	}

	@Override
	public List<WalletModel> getData() {
		if(mList == null) {
			mList = new ArrayList<>();
		}
		loadData();
		return mList;
	}

	@Override
	public void loadData() {
		mList.add(new WalletModel(1,"wallet1",500));
		mList.add(new WalletModel(2,"wallet2",5200));
		processTask();
	}

	private void processTask() {
		mView.showWallets(mList);
		mView.setProgressBar();
	}
}
