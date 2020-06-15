package com.jiuyv.controller;

import java.awt.image.BufferedImage;
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

import org.springframework.beans.factory.annotation.Value;
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
import com.jiuyv.util.ResultVOUtil;
import com.jiuyv.vo.ResultVO;


@RestController
@RequestMapping("/poiWord")
public class PoiTlWordController {
	@PostMapping("/new")
	public ResultVO<Map<String, String>> create() {

		String filePath = "C:/tmp";

		XWPFTemplate template;
		try {

			template = XWPFTemplate.compile("src/main/resources/template.docx")

					.render(new HashMap<String, Object>() {
						{
							put("name", "Sayi");

							put("author", new TextRenderData("000000", "Sayi"));

							// 超链接
							put("link", new HyperLinkTextRenderData("website", "http://deepoove.com"));

							// 锚点
							put("anchor", new HyperLinkTextRenderData("anchortxt", "anchor:appendix1"));

							// 本地图片
							put("local", new PictureRenderData(80, 100, "src/main/resources/logo.png"));

							// 图片流
							put("localbyte", new PictureRenderData(80, 100, ".png",
									new FileInputStream("src/main/resources/logo.png")));

							// 网络图片
							put("urlpicture", new PictureRenderData(50, 50, ".png",
									BytePictureUtils.getUrlBufferedImage("http://deepoove.com/images/icecream.png")));

							// java 图片
							put("bufferimage", new PictureRenderData(80, 100, ".png",
									ImageIO.read(new File("src/main/resources/aaa.jpg"))));

							// 表格
							RowRenderData header = RowRenderData.build(new TextRenderData("ff9800", "姓名"),
									new TextRenderData("学历", "center"));
							RowRenderData row0 = RowRenderData.build("张三", "研究生");
							RowRenderData row1 = RowRenderData.build("李四", "博士");
							RowRenderData row2 = RowRenderData.build("王五", "小学生");
							put("table", new MiniTableRenderData(header, Arrays.asList(row0, row1, row2)));

							// 列表
							put("list", new NumbericRenderData(new ArrayList<TextRenderData>() {
								{
									add(new TextRenderData("Plug-in function, define your own function"));
									add(new TextRenderData("Supports word text, header..."));
									add(new TextRenderData("Not just templates, but also style templates"));
								}
							}));
							;

						}
					});

			FileOutputStream out;
			out = new FileOutputStream(filePath + File.separator + "output.doc");
			template.write(out);
			out.flush();
			out.close();
			template.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		Map<String, String> map = new HashMap<>();
		map.put("rs", "success");

		return ResultVOUtil.success(map);
	}
}
