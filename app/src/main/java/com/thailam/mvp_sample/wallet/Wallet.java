package com.thailam.mvp_sample.wallet;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "wallets")
public class Wallet {
	@PrimaryKey
	@ColumnInfo(name = "id")
	public int mId;

	@Nullable
	@ColumnInfo(name = "name")
	public String mName;

	@ColumnInfo(name = "amount")
	public double mAmount;

	public Wallet(int id, String name, double amount) {
		this.mId = id;
		this.mName = name;
		this.mAmount = amount;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int id) {
		mId = id;
	}

	@Nullable
	public String getmName() {
		return mName;
	}

	public void setmName(@Nullable String name) {
		mName = name;
	}

	public double getmAmount() {
		return mAmount;
	}

	public void setmAmount(double amount) {
		mAmount = amount;
	}

	@Override
	@NonNull
	public String toString() {
		return "Wallet{" +
				"mId=" + mId +
				", mName='" + mName + '\'' +
				", mAmount=" + mAmount +
				'}';
	}
}
