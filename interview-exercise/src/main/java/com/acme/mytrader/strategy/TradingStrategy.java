package com.acme.mytrader.strategy;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy implements PriceSource, ExecutionService {
	
	private static List<PriceListener> prices = new ArrayList<PriceListener>();

	@Override
	public void addPriceListener(PriceListener priceListener) {
		prices.add(priceListener);		
	}

	@Override
	public void removePriceListener(PriceListener priceListener) {
		prices.remove(priceListener);		
	}

	@Override
	public void buy(String security, double price, int volume) {
		System.out.println("Buying {"+volume+"} product {"+security+"} at price {"+price+"} ");
		for (PriceListener priceListener : prices) {
			priceListener.priceUpdate(security, price);
		}		
	}

	@Override
	public void sell(String security, double price, int volume) {
		System.out.println("Selling {"+volume+"} product {"+security+"} at price {"+price+"} ");
		for (PriceListener priceListener : prices) {
			priceListener.priceUpdate(security, price);
		}	
	}
}
