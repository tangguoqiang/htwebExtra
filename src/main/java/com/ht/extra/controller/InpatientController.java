package com.ht.extra.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.base.CharMatcher;
import com.ht.extra.pojo.Inpatient;
import com.ht.extra.service.InpatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Dell on 2016/7/26.
 */

@Controller
@RequestMapping("/inpatient")
public class InpatientController {
    @Resource
    private InpatientService inpatientService;
    @RequestMapping("/showInp")
    public String showMsg(HttpServletRequest request, Model model){
        String ipid = request.getParameter("id");
        System.out.println("ipid==>"+ipid);
        Inpatient inp = inpatientService.getInpatientByIpid("ZY010016118941");
        System.out.println(JSON.toJSONString(inp));
        model.addAttribute("inp",inp);
        return "showInp";
    }
    @RequestMapping("/showInps")
    public String showInpsmsg(HttpServletRequest request, Model model){
        String time1 = request.getParameter("id");
        String time2 = request.getParameter("id");
        List<Inpatient> inps = inpatientService.getInpaientsByOutTime("20160728071010","20160728101010");
        model.addAttribute("inps",inps);
        return "showInps";
    }
    @RequestMapping("/inptest")
    public String test(HttpServletRequest request, Model model){
        System.out.println("test");
        try{
            InputStream is = request.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[4096];
            int count = -1;
            while((count = is.read(data,0,2048)) != -1)
                outStream.write(data, 0, count);

            String test = new String(outStream.toByteArray(),"UTF-8");
            System.out.println(test);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "111";

    }
    @ResponseBody
    @RequestMapping("/showInpsJstl")
    public Object showInpsJstl(HttpServletRequest request, Model model){
        //String time1 = request.getParameter("id");
        //String time2 = request.getParameter("id");
//        String ipid = request.getParameter("ipid");
//        System.out.println(ipid);
//        String date = request.getParameter("statu");
//        System.out.println(date);
//        date = date.split(" ")[0].replaceAll("-","");
//        List<Inpatient> inps = inpatientService.getInpaientsByOutTime("20160728071010","20160728101010");
//        return JSONArray.toJSON(inps);
        return request.getParameter("data");
    }
}
