package test.java.com.acme.mytrader.strategy;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import main.java.com.acme.mytrader.execution.ExecutionService;
import main.java.com.acme.mytrader.price.PriceListener;
import main.java.com.acme.mytrader.price.PriceSource;
import main.java.com.acme.mytrader.product.Product;
import main.java.com.acme.mytrader.strategy.TradingStrategy;

public class TradingStrategyTest {
	
	PriceSource stock = null;	
	ExecutionService service = null;	
	
	@Before
	public void init() {
	   stock = new TradingStrategy();	
	   service = new TradingStrategy();	
	}
	
	@Test
	public void addIBMProduct() {
		PriceListener product = new Product("IBM", 10);
		stock.addPriceListener(product);
		product = new Product("AWS", 100);
		stock.addPriceListener(product);
	}
	
   	@Test
    	public void move() {  
		service.buy("IBM", 10, 100);	
		service.sell("AWS", 11, 100);
		
		service.buy("AWS", 101, 100);	
		service.sell("IBM", 110, 100);
    	}  
}
