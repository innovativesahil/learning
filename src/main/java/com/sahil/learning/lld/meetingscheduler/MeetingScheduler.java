package com.sahil.learning.lld.meetingscheduler;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {

    private static MeetingScheduler instance;

    private final List<MeetingRoom> meetingRooms;

    private final NotificationSender notificationSender;

    private MeetingScheduler(final  NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
        this.meetingRooms = new ArrayList<>();
    }

    public static MeetingScheduler getInstance(final NotificationSender notificationSender) {
        if(instance == null){
            instance = new MeetingScheduler(notificationSender);
        }
        return instance;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRooms.add(meetingRoom);
    }

    public boolean scheduleMeeting(final Meeting meeting) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if(meetingRoom.scheduleMeeting(meeting)){
                notificationSender.sendNotification(meeting.createNotification());
                return true;
            }
        }
        return false;
    }

    public void getRoomAvailability() {

        for(MeetingRoom meetingRoom : meetingRooms){
            meetingRoom.getAvailability();
        }
    }
}
