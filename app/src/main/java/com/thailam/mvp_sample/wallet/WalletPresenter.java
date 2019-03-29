package com.thailam.mvp_sample.wallet;

import com.thailam.mvp_sample.wallet.data.WalletRepository;

import java.util.List;

public class WalletPresenter implements WalletContract.Presenter, WalletRepository.GetWalletsCallback {

	private final WalletContract.View mView;
	private List<Wallet> mList;
	private WalletRepository mWalletRepo;


	public WalletPresenter(WalletContract.View view) {
		mView = view;
	}

	@Override
	public void addData(Wallet wallet) {
		mWalletRepo.insertWallet(wallet);
	}

	@Override
	public void loadData() {
		mWalletRepo.getAllWallets();
	}

	@Override
	public void initRepository() {
		if (mWalletRepo == null) {
			mWalletRepo = new WalletRepository(mView.getContext(), this);
		}
	}

	@Override
	public void callback(List<Wallet> wallets) {
		if (wallets == null) {
			return;
		}
		mView.setProgressBar();
		mView.showWallets(wallets);
	}
}
