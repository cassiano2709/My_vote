package com.votacao.schedule;

import com.votacao.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class VoteScheduling {

    private SessionService sessionService;

    @Autowired
    public VoteScheduling(SessionService sessionService) {
        this.sessionService = sessionService;
       }

    @Scheduled(cron = "15 * * * * *")
    public void verifyWhoTheTopicVotingSessionIsClosed() {
        System.out.println("Scheduling run...");
        List<String> listOfSessionClosed = sessionService.doHaveAnOpenSessionThatCanBeClosed();
        listOfSessionClosed.forEach(session -> {
            System.out.println("Producing message: " + session);
        });
        System.out.println("Scheduling finished...");
    }

}
