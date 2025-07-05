package com.cognizant.ormlearn.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getFBStocksBetween(Date start, Date end) {
        return stockRepository.findByStCodeAndStDateBetween("FB", start, end);
    }

    public List<Stock> getGoogleStocksGreaterThan1250() {
        return stockRepository.findByStCodeAndStCloseGreaterThan("GOOGL", 1250);
    }

    public List<Stock> getTop3HighestVolume() {
        return stockRepository.findTop3ByOrderByStVolumeDesc();
    }

    public List<Stock> getLowestNetflixStocks() {
        return stockRepository.findTop3ByStCodeOrderByStCloseAsc("NFLX");
    }
}
