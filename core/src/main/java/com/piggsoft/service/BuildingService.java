package com.piggsoft.service;

import com.piggsoft.mapper.BuildingMapper;
import com.piggsoft.model.Building;
import com.piggsoft.model.BuildingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <br>Created by fire pigg on 2016/01/05.
 *
 * @author piggsoft@163.com
 */
@Service
@Transactional
public class BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;


    public int create(Building building) {
        return buildingMapper.insert(building);
    }

    public List<Building> searchBySsn(String ssn) {
        BuildingExample example = new BuildingExample();
        example.createCriteria()
                .andSsnLike("%" + ssn + "%");
        return buildingMapper.selectByExample(example);
    }

    public Building findById(int id) {
        return buildingMapper.selectByPrimaryKey(id);
    }
}
