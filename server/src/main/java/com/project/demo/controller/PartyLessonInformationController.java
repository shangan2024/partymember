package com.project.demo.controller;

import com.project.demo.entity.PartyLessonInformation;
import com.project.demo.service.PartyLessonInformationService;
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
 * 党课信息：(PartyLessonInformation)表控制层
 *
 */
@RestController
@RequestMapping("/party_lesson_information")
public class PartyLessonInformationController extends BaseController<PartyLessonInformation, PartyLessonInformationService> {

    /**
     * 党课信息对象
     */
    @Autowired
    public PartyLessonInformationController(PartyLessonInformationService service) {
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
