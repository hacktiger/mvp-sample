package com.thailam.mvp_sample.wallet;

public class WalletModel {
	private int mId;
	private String mName;
	private double mAmount;

	public WalletModel(int mId, String mName, double mAmount) {
		this.mId = mId;
		this.mName = mName;
		this.mAmount = mAmount;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public double getmAmount() {
		return mAmount;
	}

	public void setmAmount(double mAmount) {
		this.mAmount = mAmount;
	}

	@Override
	public String toString() {
		return "WalletModel{" +
				"mId=" + mId +
				", mName='" + mName + '\'' +
				", mAmount=" + mAmount +
				'}';
	}
}
