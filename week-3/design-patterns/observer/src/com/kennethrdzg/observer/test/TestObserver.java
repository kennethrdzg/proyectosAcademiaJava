package com.kennethrdzg.observer.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kennethrdzg.observer.BotInvestor;
import com.kennethrdzg.observer.HumanInvestor;
import com.kennethrdzg.observer.Investor;
import com.kennethrdzg.observer.Stock;

class TestObserver {
	
	@Test
	void testObserverRegistersAndRemoves() {
		Stock stock = new Stock("TEST", 1000.0);
		
		Investor investor = new HumanInvestor("Mike");
		
		stock.addObserver(investor);
		assertTrue(stock.getInvestors().contains(investor));
		
		stock.removeObserver(investor);
		assertFalse(stock.getInvestors().contains(investor));
	}
	
	@Test
	void testNotification() {
		Stock stock = new Stock("TEST", 1000.0);
		stock.addObserver(new HumanInvestor("Mike"));
		stock.addObserver(new BotInvestor(10));
		assertEquals(stock.notifyObservers(), stock.getInvestors().size());
	}
	
	@Test
	void testObserverUpdates() {
		Stock stock = new Stock("TEST", 1000.0);
		HumanInvestor investor = new HumanInvestor("Mike");
		stock.addObserver(investor);
		
		stock.setPrice(950.0);
		assertEquals(950.0, investor.lastPrice);
	}
	
	@Test
	void testPriceUpdate() {
		Stock stock = new Stock("TEST", 1000.0);
		stock.setPrice(900.0);
		assertEquals(stock.getPrice(), 900.0);
	}
}
