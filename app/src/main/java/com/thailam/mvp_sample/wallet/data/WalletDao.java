package com.thailam.mvp_sample.wallet.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.thailam.mvp_sample.wallet.Wallet;

import java.util.List;

@Dao
public interface WalletDao {
	@Query("SELECT * FROM wallets")
	List<Wallet> getWallets();

	@Insert
	void insert(Wallet wallet);

	@Delete
	void delete(Wallet wallet);
}
