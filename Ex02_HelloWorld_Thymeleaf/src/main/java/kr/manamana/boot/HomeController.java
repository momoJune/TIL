package kr.manamana.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping("/")
    public ModelAndView indexPage() {
    	//view name으로 page 파일 명을 입력한다.
        //prefix + 파일명 + suffix
        ModelAndView modelAndView = new ModelAndView("index");

        Map<String, Object> info = new HashMap<>();
        info.put("name", "kim");
        info.put("age", 29);

        List<String> datas = new ArrayList<>();
        datas.add("red");
        datas.add("orange");
        datas.add("yellow");

        modelAndView.addObject("info", info);
        modelAndView.addObject("datas", datas);

        return modelAndView;
    }
}