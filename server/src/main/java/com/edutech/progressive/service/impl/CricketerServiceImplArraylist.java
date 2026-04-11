package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService {

    List<Cricketer> cl = new ArrayList<>();

    @Override
    public List<Cricketer> getAllCricketers() {
        return cl;
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) {
        cl.add(cricketer);
        return 1;

        
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        Collections.sort(cl);
        return cl;
}
    @Override
    public void emptyArrayList(){
        cl = new ArrayList<>();
    }

}