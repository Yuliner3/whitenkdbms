package com.wn.dbms.controller;

import com.wn.dbms.entity.View;
import com.wn.dbms.service.ViewDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dql")
public class ViewDQLController {
    @Autowired
    ViewDQLService viewDQLService;

    @GetMapping("/selectViewList")
    public List<View> selectViewList(){
        return viewDQLService.selectViewList();
    }
}
