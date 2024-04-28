package com.project.demo.controller;

import com.project.demo.entity.Experience;
import com.project.demo.service.ExperienceService;
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
 * 心得体会：(Experience)表控制层
 *
 */
@RestController
@RequestMapping("/experience")
public class ExperienceController extends BaseController<Experience, ExperienceService> {

    /**
     * 心得体会对象
     */
    @Autowired
    public ExperienceController(ExperienceService service) {
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
