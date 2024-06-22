package com.sahil.learning.lld.meetingscheduler;

public class EmailNotificationSender implements NotificationSender {


    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Notification sent " + notification);
    }
}
