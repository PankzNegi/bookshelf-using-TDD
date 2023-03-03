package com.pankz.stockexchange;

import java.util.Random;

public class Portfolio {

    public String stock = "msft";
    int noOfStock=10;
    private  StockExchange stockExchange;
    public Portfolio(StockExchange stockExchange)
    {
        this.stockExchange=stockExchange;
    }
    int getValue()
    {
       return  stockExchange.getPrice(stock)*noOfStock;

    }


}
class TokyoStockExchange implements StockExchange
{
    static int max=100;
    static  int min=40;
    @Override
   public int getPrice(String stock)
    {

        return (int)(Math.random()*(max-min)+min);
    }
}

interface StockExchange
{
 int getPrice(String stock);
}

