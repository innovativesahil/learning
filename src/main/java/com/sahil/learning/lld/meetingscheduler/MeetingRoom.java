package com.sahil.learning.lld.meetingscheduler;

import lombok.Getter;

import java.util.Calendar;

@Getter
public class MeetingRoom {

    private final int maxCapacity;
    private final String meetingRoomId;
    private final Calendar calendar;
    // meeting room should have some info on already existing meetings

    public MeetingRoom(int maxCapacity, String meetingRoomId) {
        this.maxCapacity = maxCapacity;
        this.meetingRoomId = meetingRoomId;
        this.calendar = Calendar.getInstance(); // send invitee the correct time as per their timezone
    }

    public boolean scheduleMeeting(Meeting meeting) {
        if(meeting.getInvitees().size() >= maxCapacity) {
            return false;
        }

//        if(meeting.getStartTime())

        return false;
    }

    public void getAvailability() {
        System.out.println(calendar);
    }
}
