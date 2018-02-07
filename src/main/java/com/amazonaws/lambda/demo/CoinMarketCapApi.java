package com.amazonaws.lambda.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

public class CoinMarketCapApi {

	private final String MARKETCAP_URL = "https://api.coinmarketcap.com/v1/ticker/";	
	private final int success_status_code = 200;
	private final CryptoCurrency[] EMPTY_LIST = {};
	HttpClient client = new DefaultHttpClient();
	
	CryptoCurrency[] tryToGetCoins(int limit) {
		try {
			return getCoins(limit);
		} catch (Exception e) {
			throw new RuntimeException("Collecting cryptocurrencies failed");
		}
	}
	
	private CryptoCurrency[] getCoins(int limit) throws ClientProtocolException, IOException {
		HttpGet getRequest = new HttpGet(MARKETCAP_URL + "?limit=" + limit);
		HttpResponse response = client.execute(getRequest);
		if (response.getStatusLine().getStatusCode() == success_status_code) {
			return jsonToArray(toJson(response.getEntity().getContent()));
		}
		return EMPTY_LIST;
	}
	
	private CryptoCurrency[] jsonToArray(String json) {
		if (json != null && !json.isEmpty()) {
			Gson gson = new Gson();
			return gson.fromJson(json, CryptoCurrency[].class);
		}
		return EMPTY_LIST;
	}
	
	private String toJson(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
		return scanner.hasNext() ? scanner.next() : "";
	}

	public void setClient(HttpClient client) {
		this.client = client;
	}
	
	
}
