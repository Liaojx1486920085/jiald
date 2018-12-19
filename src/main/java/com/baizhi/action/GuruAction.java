package com.baizhi.action;


import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/guru")
public class GuruAction {
    @Resource
    private GuruService guruService;

    @RequestMapping("/selectGuru")
    public List<Guru> seletGuru() {
        System.out.println("进入");
        List<Guru> gurus = guruService.selectGuru();
        return gurus;
    }

}
