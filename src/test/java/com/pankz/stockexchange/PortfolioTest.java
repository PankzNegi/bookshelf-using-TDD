package com.pankz.stockexchange;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class PortfolioTest {
    @Test
    public void testing()
    {
        Portfolio portfolio=new Portfolio(new FixedStockExchange());
       int value= portfolio.getValue();
        assertEquals(100,value);
    }

}

class FixedStockExchange implements StockExchange
{

    @Override
    public int getPrice(String stock) {
        return 10;
    } }