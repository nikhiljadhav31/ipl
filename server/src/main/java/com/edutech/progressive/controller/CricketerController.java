package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Cricketer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/")
public class CricketerController {

    public ResponseEntity<List<Cricketer>> getAllCricketers() {
        return null;
    }

    public ResponseEntity<Cricketer> getCricketerById(int cricketerId) {
        return null;
    }

    public ResponseEntity<Integer> addCricketer(Cricketer cricketer) {
        return null;
    }

    public ResponseEntity<Void> updateCricketer(int cricketerId, Cricketer cricketer) {
        return null;
    }

    public ResponseEntity<Void> deleteCricketer(int cricketerId) {
        return null;
    }

    public ResponseEntity<List<Cricketer>> getCricketersByTeam(int teamId) {
        return null;
    }
}