package com.edutech.progressive.controller;

import com.edutech.progressive.entity.TicketBooking;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/")
public class TicketBookingController {

    public ResponseEntity<List<TicketBooking>> getAllBookings() {
        return null;
    }

    public ResponseEntity<Integer> createBooking(TicketBooking ticketBooking) {
        return null;
    }

    public ResponseEntity<Void> cancelBooking(int bookingId) {
        return null;
    }

    public ResponseEntity<List<TicketBooking>> getBookingsByUserEmail(String email) {
        return null;
    }
}