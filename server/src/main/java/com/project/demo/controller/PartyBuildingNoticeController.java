package com.project.demo.controller;

import com.project.demo.entity.PartyBuildingNotice;
import com.project.demo.service.PartyBuildingNoticeService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 党建通知：(PartyBuildingNotice)表控制层
 *
 */
@RestController
@RequestMapping("/party_building_notice")
public class PartyBuildingNoticeController extends BaseController<PartyBuildingNotice, PartyBuildingNoticeService> {

    /**
     * 党建通知对象
     */
    @Autowired
    public PartyBuildingNoticeController(PartyBuildingNoticeService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
