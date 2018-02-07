package com.amazonaws.lambda.demo;

public enum CryptoCurrencyTable {
	 id,
	 name,
	 symbol,
	 rank,
	 price_usd,
	 price_btc,
	 percent_change_1h,
	 percent_change_24h,
	 percent_change_7d,
	 Cryptocurrency;
	
	public String getTableName() {
		return Cryptocurrency.toString();
	}
}
