package com.edutech.progressive.service.impl;
import java.util.*;
import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;
public class CricketerServiceImplJdbc implements CricketerService {
   private CricketerDAO dao;
   public CricketerServiceImplJdbc(CricketerDAO dao) {
       this.dao = dao;
   }
   @Override
   public List<Cricketer> getAllCricketers() {
       try {
           return dao.getAllCricketers();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public Integer addCricketer(Cricketer c) {
       try {
           return dao.addCricketer(c);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public List<Cricketer> getAllCricketersSortedByExperience() {
       try {
           List<Cricketer> list = dao.getAllCricketers();
           Collections.sort(list, Comparator.comparingInt(Cricketer::getExperience));
           return list;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public void updateCricketer(Cricketer c) {
       try {
           dao.updateCricketer(c);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public void deleteCricketer(int id) {
       try {
           dao.deleteCricketer(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
   @Override
   public Cricketer getCricketerById(int id) {
       try {
           return dao.getCricketerById(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }
}