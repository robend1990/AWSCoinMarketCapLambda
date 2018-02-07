package com.amazonaws.lambda.demo;

public class CryptoCurrency {

	private String id;
	private String name;
	private String symbol;
	private int rank;
	private float price_usd;
	private float price_btc;
	private float percent_change_1h;
	private float percent_change_24h;
	private float percent_change_7d;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public float getPrice_usd() {
		return price_usd;
	}
	public void setPrice_usd(float price_usd) {
		this.price_usd = price_usd;
	}
	public float getPrice_btc() {
		return price_btc;
	}
	public void setPrice_btc(float price_btc) {
		this.price_btc = price_btc;
	}
	public float getPercent_change_1h() {
		return percent_change_1h;
	}
	public void setPercent_change_1h(float percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}
	public float getPercent_change_24h() {
		return percent_change_24h;
	}
	public void setPercent_change_24h(float percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}
	public float getPercent_change_7d() {
		return percent_change_7d;
	}
	public void setPercent_change_7d(float percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(percent_change_1h);
		result = prime * result + Float.floatToIntBits(percent_change_24h);
		result = prime * result + Float.floatToIntBits(percent_change_7d);
		result = prime * result + Float.floatToIntBits(price_btc);
		result = prime * result + Float.floatToIntBits(price_usd);
		result = prime * result + rank;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CryptoCurrency other = (CryptoCurrency) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(percent_change_1h) != Float.floatToIntBits(other.percent_change_1h))
			return false;
		if (Float.floatToIntBits(percent_change_24h) != Float.floatToIntBits(other.percent_change_24h))
			return false;
		if (Float.floatToIntBits(percent_change_7d) != Float.floatToIntBits(other.percent_change_7d))
			return false;
		if (Float.floatToIntBits(price_btc) != Float.floatToIntBits(other.price_btc))
			return false;
		if (Float.floatToIntBits(price_usd) != Float.floatToIntBits(other.price_usd))
			return false;
		if (rank != other.rank)
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
	
	
	
}
