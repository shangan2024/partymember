package com.project.demo.controller;

import com.project.demo.entity.GeneralManager;
import com.project.demo.service.GeneralManagerService;
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
 * 普通管理者：(GeneralManager)表控制层
 *
 */
@RestController
@RequestMapping("/general_manager")
public class GeneralManagerController extends BaseController<GeneralManager, GeneralManagerService> {

    /**
     * 普通管理者对象
     */
    @Autowired
    public GeneralManagerController(GeneralManagerService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapstudent_id = new HashMap<>();
        mapstudent_id.put("student_id",String.valueOf(paramMap.get("student_id")));
        List liststudent_id = service.select(mapstudent_id, new HashMap<>()).getResultList();
        if (liststudent_id.size()>0){
            return error(30000, "字段学号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
