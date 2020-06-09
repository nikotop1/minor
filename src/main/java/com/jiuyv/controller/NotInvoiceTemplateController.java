package com.jiuyv.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.HyperLinkTextRenderData;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.util.BytePictureUtils;
import com.jiuyv.util.PaymentExample;
import com.jiuyv.util.ResultVOUtil;
import com.jiuyv.vo.ResultVO;

@RequestMapping("/NotInvoiceTemplate")
@RestController
public class NotInvoiceTemplateController {

	@PostMapping("new")
	public ResultVO<Map<String, String>> create(){		
	PaymentExample p =new PaymentExample();
	try {
		p.testPaymentExample();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Map<String, String> map = new HashMap<>();
    map.put("rs", "success");

    return ResultVOUtil.success(map);
	}
}
