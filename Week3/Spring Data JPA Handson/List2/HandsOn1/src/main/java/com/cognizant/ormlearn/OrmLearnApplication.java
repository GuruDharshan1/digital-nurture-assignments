package com.cognizant.ormlearn;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        CountryService service = context.getBean(CountryService.class);

        System.out.println("Search by 'ou':");
        List<Country> list1 = service.searchContaining("ou");
        list1.forEach(System.out::println);

        System.out.println("\nSorted Search by 'ou':");
        List<Country> list2 = service.searchContainingSorted("ou");
        list2.forEach(System.out::println);

        System.out.println("\nCountries starting with 'Z':");
        List<Country> list3 = service.searchStartingWith("Z");
        list3.forEach(System.out::println);
    }
}
