package com.sahil.learning.lld.meetingscheduler;

public record Notification(
        String fromAddress,
        String toAddress,
        String title,
        String body) {
}
