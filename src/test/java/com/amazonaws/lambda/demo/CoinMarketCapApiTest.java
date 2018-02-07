package com.amazonaws.lambda.demo;

import org.junit.Assert;
import org.junit.Test;


public class CoinMarketCapApiTest {
	
	@Test
    public void testMarketCapHandler() {
        CoinMarketCapApi coinMarketCapApi = new CoinMarketCapApi();
        CryptoCurrency[] cryptos = coinMarketCapApi.tryToGetCoins(200);
        Assert.assertEquals(200, cryptos.length);
    }
}
