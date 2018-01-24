package cn.aegisa.acm.web.controller;

import cn.aegisa.acm.dao.service.ICommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Using IntelliJ IDEA.
 *
 * @author HNAyd.xian
 * @date 2018/1/22 12:26
 */
@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ICommonService service;

    @RequestMapping("/01/{id}")
    public String test01(@PathVariable Integer id, Model model) {
        return null;
    }
}
