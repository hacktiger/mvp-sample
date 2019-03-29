package com.thailam.mvp_sample.wallet.data;

import android.content.Context;
import android.os.AsyncTask;

import com.thailam.mvp_sample.wallet.Wallet;

import java.util.List;

public class WalletRepository {
	private static AppDatabase mAppDatabase;
	private static GetWalletsCallback mCallback;

	public WalletRepository(Context context, GetWalletsCallback callback) {
		mAppDatabase = AppDatabase.getInstance(context);
		mCallback = callback;
	}

	public void getAllWallets() {
		handleGetWallets();
	}

	private static void handleGetWallets() {
		new AsyncTask<Void, Void, List<Wallet>>() {
			@Override
			protected List<Wallet> doInBackground(Void... voids) {
				return mAppDatabase.walletDao().getWallets();
			}

			@Override
			protected void onPostExecute(List<Wallet> wallets) {
				mCallback.callback(wallets);
			}
		}.execute();
	}

	public void insertWallet(Wallet wallet) {
		handleInsertWallet(wallet);
	}

	private static void handleInsertWallet(final Wallet wallet) {
		new AsyncTask<Wallet, Void, Void>() {
			@Override
			protected Void doInBackground(Wallet... wallets) {
				mAppDatabase.walletDao().insert(wallets[0]);
				return null;
			}
		}.execute(wallet);
	}

	public interface GetWalletsCallback {
		void callback(List<Wallet> wallets);
	}
}