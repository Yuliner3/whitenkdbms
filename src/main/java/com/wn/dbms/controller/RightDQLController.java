package com.wn.dbms.controller;

import com.wn.dbms.entity.Right;
import com.wn.dbms.service.RightDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dql")
public class RightDQLController {
    @Autowired
    RightDQLService rightDQLService;

    @GetMapping("/selectRightList")
    public List<Right> selectRightList(){
        return rightDQLService.selectRightList();
    }
}
