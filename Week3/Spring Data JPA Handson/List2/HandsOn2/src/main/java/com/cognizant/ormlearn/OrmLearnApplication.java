package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        StockService service = context.getBean(StockService.class);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("FB stocks in September 2019:");
        List<Stock> fbStocks = service.getFBStocksBetween(sdf.parse("2019-09-01"), sdf.parse("2019-09-30"));
        fbStocks.forEach(System.out::println);

        System.out.println("\nGOOGL stocks with close > 1250:");
        List<Stock> googlStocks = service.getGoogleStocksGreaterThan1250();
        googlStocks.forEach(System.out::println);

        System.out.println("\nTop 3 highest volume transactions:");
        List<Stock> topVolume = service.getTop3HighestVolume();
        topVolume.forEach(System.out::println);

        System.out.println("\nLowest 3 Netflix stock closes:");
        List<Stock> lowestNetflix = service.getLowestNetflixStocks();
        lowestNetflix.forEach(System.out::println);
    }
}
