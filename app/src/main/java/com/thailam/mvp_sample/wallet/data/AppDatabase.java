package com.thailam.mvp_sample.wallet.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.thailam.mvp_sample.wallet.Wallet;

@Database(entities = {Wallet.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
	private static AppDatabase sInstance;
	private static final String DB_NAME = "my_db";

	public abstract WalletDao walletDao();

	public static AppDatabase getInstance(Context context) {
		if (sInstance == null) {
			sInstance = Room.databaseBuilder(context.getApplicationContext(),
					AppDatabase.class, DB_NAME)
					.build();
		}
		return sInstance;
	}

	public static void destroyInstance() {
		sInstance = null;
	}
}
