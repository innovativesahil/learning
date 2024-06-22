package com.sahil.learning.lld.meetingscheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

public class MeetingSchedulerDemo {

    public static void main(String[] args) {

        NotificationSender notificationSender = new EmailNotificationSender();

        MeetingScheduler meetingScheduler = MeetingScheduler.getInstance(notificationSender);
        MeetingRoom meetingRoom1 = new MeetingRoom(10, UUID.randomUUID().toString());
        MeetingRoom meetingRoom2 = new MeetingRoom(50, UUID.randomUUID().toString());
        MeetingRoom meetingRoom3 = new MeetingRoom(3, UUID.randomUUID().toString());
        meetingScheduler.addMeetingRoom(meetingRoom1);
        meetingScheduler.addMeetingRoom(meetingRoom2);
        meetingScheduler.addMeetingRoom(meetingRoom3);

        Invitee invitee = new Invitee("Sahil", "sahil@test.com");
        final List<Invitee> inviteeList = List.of(invitee);

        LocalDateTime today = LocalDateTime.now();
        Duration meetingDuration = Duration.of(30, ChronoUnit.MINUTES);
        Meeting meeting = new Meeting("Demo LLD Design", today, today, meetingDuration, inviteeList);

        boolean scheduled = meetingScheduler.scheduleMeeting(meeting);
        System.out.println("Meeting scheduled: " + scheduled);

        meetingScheduler.getRoomAvailability();
//        meetingScheduler.getRoomAvailability(start, end);
    }
}
