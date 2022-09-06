package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

//    Logger log = LoggerFactory.getLogger(getClass());//org.slf4j를 사용해야함 LomBok @Slf4j 로 대체가능

    @RequestMapping("/")
    public String home() {
        log.info("home controller"); // @Slf4j
        return "home"; //home.html로 타잎리프파일을 찾아감
    }



}
