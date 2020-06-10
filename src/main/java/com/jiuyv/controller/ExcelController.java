package com.jiuyv.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.jiuyv.excel.DemoDataOne;
import com.jiuyv.excel.ExcelFillCellMergeStrategy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("ExcelController")
@ResponseBody
public class ExcelController {

    @RequestMapping(value = "getEXcel", method = RequestMethod.POST)
    public void getEXcel( HttpServletResponse response) throws IOException {
        //获取数据源
        List<DemoDataOne> data = data();
        //设置输入流，设置响应域
        response.setContentType("application/ms-excel");
        response.setCharacterEncoding("utf-8");
        String filename = "src/main/resources/write1.xlsx";
        response.setHeader("Content-disposition","attachment;filename="+filename);
        //需要合并的列
        int[] mergeColumeIndex = {0,2};
        //需要从第一行开始，列头第一行
        int mergeRowIndex = 1;
        EasyExcel//将数据映射到DownloadDTO实体类并响应到浏览器
                .write(filename, DemoDataOne.class)
                //07的excel版本,节省内存
                //.excelType(ExcelTypeEnum.XLSX)
                //是否自动关闭输入流
                .autoCloseStream(Boolean.TRUE)
                .registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumeIndex))
//               // 自定义列宽度，有数字会
//                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                //设置excel保护密码
//                .password("123456")
                .sheet().doWrite(data);
    }
    //获取数据的地方
    private static List<DemoDataOne> data() {
        List<DemoDataOne> list = new ArrayList<DemoDataOne>();
        for (int i = 0; i < 10; i++) {
            DemoDataOne data = new DemoDataOne();
            data.setString("字符串");
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}

