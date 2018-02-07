package com.amazonaws.lambda.demo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.dynamodbv2.document.Item;

public class ItemBuilderTest {
	
	private static CryptoCurrency crypto = new CryptoCurrency();
	private static CryptoCurrency crypto2 = new CryptoCurrency();
	
	@BeforeClass
	public static void initializeCrypto() {
		crypto.setId("bitcoin");
		crypto.setName("Bitcoin");
		crypto.setSymbol("BTC");
		crypto.setRank(1);
		crypto.setPrice_btc(1);
		crypto.setPrice_usd(477.2f);
		crypto.setPercent_change_1h(24.2f);
		crypto.setPercent_change_24h(54.2f);
		crypto.setPercent_change_7d(22.2f);
		
		crypto2.setId("etherum");
		crypto2.setName("Etherum");
		crypto2.setSymbol("ETH");
		crypto2.setRank(2);
		crypto2.setPrice_btc(1);
		crypto2.setPrice_usd(477.2f);
		crypto2.setPercent_change_1h(24.2f);
		crypto2.setPercent_change_24h(54.2f);
		crypto2.setPercent_change_7d(22.2f);
	}
	
	@Test
	public void testCreateItem() {
		ItemBuilder ItemBuilder = new ItemBuilder();
		Item item = ItemBuilder.createItem(crypto);
		Assert.assertTrue(isItemEqualToCryptoCurrencyObject(item, crypto));
	}
	
	@Test
	public void testCreateItems() {
		CryptoCurrency[] cryptocurrencies = {crypto, crypto2};
		ItemBuilder ItemBuilder = new ItemBuilder();
		List<Item> items = ItemBuilder.createItems(cryptocurrencies);
		for (int i = 0; i > items.size(); i++) {
			Assert.assertTrue(isItemEqualToCryptoCurrencyObject(items.get(i), cryptocurrencies[i]));
		}
	}
	
	private boolean isItemEqualToCryptoCurrencyObject(Item item, CryptoCurrency cryptoToCompare) {
		return item.getString(CryptoCurrencyTable.id.toString()).equals(cryptoToCompare.getId()) &&
		item.getString(CryptoCurrencyTable.name.toString()).equals(cryptoToCompare.getName()) &&
		item.getString(CryptoCurrencyTable.symbol.toString()).equals(cryptoToCompare.getSymbol()) &&
		item.getInt(CryptoCurrencyTable.rank.toString()) == cryptoToCompare.getRank() &&
		item.getFloat(CryptoCurrencyTable.price_btc.toString()) == cryptoToCompare.getPrice_btc() &&
		item.getFloat(CryptoCurrencyTable.price_usd.toString()) == cryptoToCompare.getPrice_usd() &&
		item.getFloat(CryptoCurrencyTable.percent_change_1h.toString()) == cryptoToCompare.getPercent_change_1h() &&
		item.getFloat(CryptoCurrencyTable.percent_change_24h.toString()) == cryptoToCompare.getPercent_change_24h() &&
		item.getFloat(CryptoCurrencyTable.percent_change_7d.toString()) ==cryptoToCompare.getPercent_change_7d();
	}
}
