package com.ht.extra.controller;

import com.ht.extra.pojo.Inpatient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xps13 on 2017/4/15.
 */
@Controller
@RequestMapping("/toSend")
public class ToSendController {
    @ResponseBody
    @RequestMapping("/to")
    public String showInpsmsg(HttpServletRequest request, Model model){
        String data = request.getParameter("data");
        return data;
    }
}
