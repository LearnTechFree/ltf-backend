package com.learntechfree.ltf.unit;

import com.learntechfree.ltf.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> listUnits(){
        return unitRepository.findAll();
    }

}
