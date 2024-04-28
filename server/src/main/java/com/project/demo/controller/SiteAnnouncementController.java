package com.project.demo.controller;

import com.project.demo.entity.SiteAnnouncement;
import com.project.demo.service.SiteAnnouncementService;
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
 * 站点公告：(SiteAnnouncement)表控制层
 *
 */
@RestController
@RequestMapping("/site_announcement")
public class SiteAnnouncementController extends BaseController<SiteAnnouncement, SiteAnnouncementService> {

    /**
     * 站点公告对象
     */
    @Autowired
    public SiteAnnouncementController(SiteAnnouncementService service) {
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
