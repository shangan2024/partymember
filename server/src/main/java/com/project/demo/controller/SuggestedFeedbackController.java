package com.project.demo.controller;

import com.project.demo.entity.SuggestedFeedback;
import com.project.demo.service.SuggestedFeedbackService;
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
 * 建议反馈：(SuggestedFeedback)表控制层
 *
 */
@RestController
@RequestMapping("/suggested_feedback")
public class SuggestedFeedbackController extends BaseController<SuggestedFeedback, SuggestedFeedbackService> {

    /**
     * 建议反馈对象
     */
    @Autowired
    public SuggestedFeedbackController(SuggestedFeedbackService service) {
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
