package com.project.demo.controller;

import com.project.demo.entity.CertificateOfAchievement;
import com.project.demo.service.CertificateOfAchievementService;
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
 * 成绩证书：(CertificateOfAchievement)表控制层
 *
 */
@RestController
@RequestMapping("/certificate_of_achievement")
public class CertificateOfAchievementController extends BaseController<CertificateOfAchievement, CertificateOfAchievementService> {

    /**
     * 成绩证书对象
     */
    @Autowired
    public CertificateOfAchievementController(CertificateOfAchievementService service) {
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
