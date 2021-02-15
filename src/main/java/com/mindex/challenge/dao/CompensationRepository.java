package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

/**
 * Class to handle persistence of compensation data
 */
@Repository
public class CompensationRepository {
    private HashMap<String, Compensation> compensationData = new HashMap<>();

    public boolean insert(Compensation compensation){
        if(compensationData.putIfAbsent(compensation.getEmployeeId(), compensation) == null){
            return true;
        }else{
            return false;
        }
    }

    public Compensation read(String id){
        Compensation compensation = compensationData.get(id);
        System.out.println(compensation.getEmployeeId() + " " + compensation.getEffectiveDate() + " " + compensation.getSalary());
        return compensation;
    }
}
