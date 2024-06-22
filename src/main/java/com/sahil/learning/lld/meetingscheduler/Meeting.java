package com.sahil.learning.lld.meetingscheduler;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Getter
public class Meeting {

    private final String title;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Duration duration;
    private final List<Invitee> invitees;

    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, Duration duration, List<Invitee> invitees) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.invitees = invitees;
    }

    public Notification createNotification() {
        final List<String> toAddress = invitees.stream().map(Invitee::email).toList();
        return new Notification("no-reply@test.com",
                String.join(";", toAddress), title, getNotificationBody());
    }


    private String getNotificationBody(){
        return  String.format("""
                You are invited for meeting %s
                Start time %s
                End Time %s
                Duration %s
                """, title, startTime, endTime, duration);
    }
}
