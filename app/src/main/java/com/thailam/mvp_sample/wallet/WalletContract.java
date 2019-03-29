package com.thailam.mvp_sample.wallet;

import android.content.Context;

import java.util.List;

public interface WalletContract {
	interface Presenter {
		void addData(Wallet wallet);

		void loadData();

		void initRepository();
	}

	interface View {
		void setProgressBar();

		void showWallets(List<Wallet> list);

		Context getContext();
	}
}
