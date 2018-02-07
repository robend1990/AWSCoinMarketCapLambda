package com.amazonaws.lambda.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.dynamodbv2.document.Item;

public class ItemBuilder {

	Item createItem(CryptoCurrency cryptoCurrency) {
		Item item = new Item();
		item.withString(CryptoCurrencyTable.id.toString(), cryptoCurrency.getId());
		item.withString(CryptoCurrencyTable.name.toString(), cryptoCurrency.getName());
		item.withString(CryptoCurrencyTable.symbol.toString(), cryptoCurrency.getSymbol());
		item.withNumber(CryptoCurrencyTable.rank.toString(), cryptoCurrency.getRank());
		item.withNumber(CryptoCurrencyTable.price_btc.toString(), cryptoCurrency.getPrice_btc());
		item.withNumber(CryptoCurrencyTable.price_usd.toString(), cryptoCurrency.getPrice_usd());
		item.withNumber(CryptoCurrencyTable.percent_change_1h.toString(), cryptoCurrency.getPercent_change_1h());
		item.withNumber(CryptoCurrencyTable.percent_change_24h.toString(), cryptoCurrency.getPercent_change_24h());
		item.withNumber(CryptoCurrencyTable.percent_change_7d.toString(), cryptoCurrency.getPercent_change_7d());
		return item;
	}
	
	List<Item> createItems(CryptoCurrency[] cryptoCurrencies) {
		if (cryptoCurrencies != null && cryptoCurrencies.length > 0) {
			return Arrays.stream(cryptoCurrencies).map(c -> createItem(c)).collect(Collectors.toList());
		}
		return Collections.EMPTY_LIST;
	}
}
