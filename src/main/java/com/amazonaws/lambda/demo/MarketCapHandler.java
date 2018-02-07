package com.amazonaws.lambda.demo;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MarketCapHandler implements RequestHandler<Object, String> {
	
	private int coinLimit = 20;
	DynamoDBHandler DynamoDBHandler = new DynamoDBHandler();

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        CoinMarketCapApi coinMarketCapApi = new CoinMarketCapApi();
        CryptoCurrency[] cryptoCurriencies = coinMarketCapApi.tryToGetCoins(coinLimit);
        DynamoDBHandler.batchWriteCryptoCurrencies(cryptoCurriencies);
        // TODO: implement your handler
        return "Hello from Lambda!";
    }

}
