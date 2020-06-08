package com.jiuyv.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiuyv.util.ResultVOUtil;
import com.jiuyv.vo.ResultVO;

import freemarker.template.Configuration;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/word")
@RestController
public class WordController {
	@Value("${fileStoreRootPath}")
    String filePath;

	@PostMapping("new")
    public ResultVO<Map<String, String>> create(){
		 String filePath="C:/tmp";
        try {
            Map<String,String> dataMap = new HashMap<String,String>();
            dataMap.put("f1", "Jerry");
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            //指定模板路径的第二种方式,我的路径是C:/      还有其他方式
            System.out.println("filePath==="+filePath);
            configuration.setDirectoryForTemplateLoading(new File(filePath));
            // 输出文档路径及名称
            File outFile = new File(filePath+File.separator+"test.doc");
            //以utf-8的编码读取ftl文件
            Template t =  configuration.getTemplate("m1.ftl","utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
            t.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("rs", "success");

        return ResultVOUtil.success(map);
    }
	
	@PostMapping("template3")
    public ResultVO<Map<String, String>> createTemplate3(){
        try {
            Map<String,Object> dataMap = new HashMap<String,Object>();
            dataMap.put("f1", "张三");
            dataMap.put("f2", "男");
            dataMap.put("f3", "1999年1月1日");
            dataMap.put("f4", "汉");
            dataMap.put("f5", "本科");
            dataMap.put("f6", "计算机");
            dataMap.put("f7", "中国");
            dataMap.put("f8", "10000");
            dataMap.put("f9", "1385664464");
            dataMap.put("f10", "今年毕业");
            dataMap.put("f11", "JAVA,数据库");
            dataMap.put("f12", "篮球，乒乓球");
            dataMap.put("f13", "努力");
            dataMap.put("f14", "1年");
            //图片
            // dataMap.put("image1", getImageBase("C:\\tmp\\123.jpg"));
            dataMap.put("image2", getImageBase("C:\\tmp\\123.jpg"));
            //表格 开始
            List<Map<String, Object>> proList = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("name","Harry");
            map1.put("startdate","2020-03-9");
            map1.put("enddate","2020-03-12");

            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("name","jerry");
            map2.put("startdate","2020-03-10");
            map2.put("enddate","2020-03-12");

            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("name","Kris");
            map3.put("startdate","2020-03-10");
            map3.put("enddate","2020-03-18");
            proList.add(map1);
            proList.add(map2);
            proList.add(map3);
            dataMap.put("proList", proList);
            //表格 结束
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            //指定模板路径的第二种方式,我的路径是D:/      还有其他方式
            System.out.println("filePath==="+filePath);
            configuration.setDirectoryForTemplateLoading(new File(filePath));

            // 输出文档路径及名称
            File outFile = new File(filePath+File.separator+"个人简历3.doc");
            //以utf-8的编码读取ftl文件
            Template t =  configuration.getTemplate("m4.ftl","utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
            t.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("rs", "success");

        return ResultVOUtil.success(map);
    }
	
	@PostMapping("/freemarkertest")
    public ResultVO<Map<String, String>> freemakertest(){
        try {
            Map<String,Object> dataMap = new HashMap<String,Object>();
            dataMap.put("username", "张三");
            dataMap.put("uData", "1999年1月1日");
            dataMap.put("content", "testFreemarker");
           
            //表格 结束
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            //指定模板路径的第二种方式,我的路径是D:/      还有其他方式
            System.out.println("filePath==="+filePath);
            configuration.setDirectoryForTemplateLoading(new File(filePath));
            List<Map<String, Object>> newsList=new ArrayList<Map<String,Object>>();
            for(int i=1;i<=10;i++){
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("title", "标题"+i);
           map.put("content", "内容"+(i*2));
            map.put("author", "作者"+(i*3));
            newsList.add(map);
           }
           dataMap.put("newsList",newsList);
           
            // 输出文档路径及名称
            File outFile = new File(filePath+File.separator+"freemarkertest.doc");
            //以utf-8的编码读取ftl文件
            Template t =  configuration.getTemplate("freemakertest2.ftl","utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
            t.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("rs", "success");

        return ResultVOUtil.success(map);
    }
	//获得图片的base64码

    public String getImageBase(String src) {
        if(src==null||src==""){
            return "";
        }
        File file = new File(src);
        if(!file.exists()) {
            return "";
        }
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
