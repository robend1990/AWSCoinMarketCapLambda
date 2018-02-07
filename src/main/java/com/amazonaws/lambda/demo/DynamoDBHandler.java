package com.amazonaws.lambda.demo;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.TableWriteItems;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;

public class DynamoDBHandler {

	private AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
	private DynamoDB dynamoDB = new DynamoDB(client);
	ItemBuilder itemBuilder = new ItemBuilder();

	public void batchWriteCryptoCurrencies(CryptoCurrency[] cryptos) {
		List<Item> itemsToSave = itemBuilder.createItems(cryptos);
		TableWriteItems cryptocurrencyTableWriteItems = new TableWriteItems("Cryptocurrency");
		cryptocurrencyTableWriteItems.withItemsToPut(itemsToSave);
		BatchWriteItemOutcome outcome = dynamoDB.batchWriteItem(cryptocurrencyTableWriteItems);
		do {
			retryBatchWriteForUnprocessedItems(outcome);
		} while (outcome.getUnprocessedItems().size() > 0);
	}

	public void retryBatchWriteForUnprocessedItems(BatchWriteItemOutcome outcome) {
		Map<String, List<WriteRequest>> unprocessedItems = outcome.getUnprocessedItems();
		if (outcome.getUnprocessedItems().size() == 0) {
			System.out.println("No unprocessed items found");
		} else {
			System.out.println("Retrieving the unprocessed items");
			outcome = dynamoDB.batchWriteItemUnprocessed(unprocessedItems);
		}
	}

	public void setClient(AmazonDynamoDB client) {
		this.client = client;
	}

	public void setDynamoDB(DynamoDB dynamoDB) {
		this.dynamoDB = dynamoDB;
	}

}
