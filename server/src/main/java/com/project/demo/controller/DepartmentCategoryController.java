package com.project.demo.controller;

import com.project.demo.entity.DepartmentCategory;
import com.project.demo.service.DepartmentCategoryService;
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
 * 院系类别：(DepartmentCategory)表控制层
 *
 */
@RestController
@RequestMapping("/department_category")
public class DepartmentCategoryController extends BaseController<DepartmentCategory, DepartmentCategoryService> {

    /**
     * 院系类别对象
     */
    @Autowired
    public DepartmentCategoryController(DepartmentCategoryService service) {
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
