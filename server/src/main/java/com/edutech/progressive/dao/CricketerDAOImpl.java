package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO {

    List<Cricketer> cricketers = new ArrayList<>();

    @Override
    public int addCricketer(Cricketer cricketer) {
        cricketers.add(cricketer);
        return -1;
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        Cricketer c = cricketers.get(cricketerId);
        if (c!=null) {
            return c;
        }
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) {
        int cid = cricketer.getCricketerId();
        for (Cricketer cricketer2 : cricketers) {
            if (cricketer2.getCricketerId()==cid) {
                cricketer2.setAge(cricketer.getAge());
                cricketer2.setCricketerName(cricketer.getCricketerName());
                cricketer2.setExperience(cricketer.getExperience());
                cricketer2.setNationality(cricketer.getNationality());
                cricketer2.setRole(cricketer.getRole());
                cricketer2.setTeamId(cricketer.getTeamId());
                cricketer2.setTotalRuns(cricketer.getTotalRuns());
                cricketer2.setTotalWickets(cricketer.getTotalWickets());
            }
        }
            
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        Cricketer c = cricketers.get(cricketerId);
        if (c!=null) {
            cricketers.remove(cricketerId);
        }
    }

    @Override
    public List<Cricketer> getAllCricketers() {
       return cricketers;
    }

}
