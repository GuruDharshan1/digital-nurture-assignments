package com.cts;

import com.cts.model.Attempt;
import com.cts.model.AttemptQuestion;
import com.cts.model.AttemptOption;
import com.cts.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        attemptService = context.getBean(AttemptService.class);
        testGetAttemptDetails();
    }

    public static void testGetAttemptDetails() {
        Attempt attempt = attemptService.getAttempt(1, 1);
        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            System.out.println(aq.getQuestion().getText());
            for (AttemptOption ao : aq.getAttemptOptions()) {
                System.out.printf("%d) %s\t%.1f\t%b\n",
                    ao.getOption().getId(),
                    ao.getOption().getText(),
                    ao.getOption().getScore(),
                    ao.isSelected()
                );
            }
        }
    }
}
