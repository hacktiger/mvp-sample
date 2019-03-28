package com.thailam.mvp_sample.wallet;

import java.util.List;

public interface WalletContract {
	interface Presenter {
		List<WalletModel> getData();
		void loadData();
	}

	interface View {
		void setProgressBar();
		void showWallets(List<WalletModel> list);
	}
}
