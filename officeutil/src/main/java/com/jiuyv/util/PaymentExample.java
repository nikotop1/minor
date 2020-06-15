package com.jiuyv.util;
import java.io.File;
import java.util.Arrays;
import java.util.List;


import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.data.style.TableStyle;


public class PaymentExample {
	String resource = "src/main/resources/notInvoice-template.docx";
	String filePath="C:/tmp";
    PaymentData datas = new PaymentData(); 
    
    public void testPaymentExample() throws Exception {	
    	Style headTextStyle = new Style();
        TableStyle headStyle = new TableStyle();
        TableStyle rowStyle = new TableStyle();
        headTextStyle.setFontFamily("Hei");
        headTextStyle.setFontSize(9);
        headTextStyle.setColor("7F7F7F");
        headStyle.setBackgroundColor("F2F2F2");
        headStyle.setAlign(STJc.CENTER);
        rowStyle = new TableStyle();
        rowStyle.setAlign(STJc.CENTER);

        datas.setInvoiceDate("2020-04-30");
        datas.setInvoiceNo("763447202004012" );
        datas.setCustomerName("宝钢德盛不锈钢有限公司");
        datas.setTaxPrice("17,782.47 CNY");
        datas.setExTaxPrice("16,775.92 CNY");
        datas.setTaxAmount("1,006.55 CNY");
        datas.setApplyComments("sad");
        datas.setReviewUser("王宝雁 ");
        datas.setApplyUser("徐静");
      

        DetailData detailTable = new DetailData();
        RowRenderData good1 = RowRenderData.build("1", "公司本部", "通用线", "176344720040000000171", "其他鉴定", "1,476.00 CNY");
        RowRenderData good2 = RowRenderData.build("2", "公司本部", "石油化工品", "176344720040000000159", "分成费", "2,000.02 CNY");
        RowRenderData good3 = RowRenderData.build("3", "公司本部", "通用线", "176344720040000000172", "其他检验", "14,306.45 CNY");
        good1.setRowStyle(rowStyle);
        good2.setRowStyle(rowStyle);
        good3.setRowStyle(rowStyle);
        List<RowRenderData> goods = Arrays.asList(good3, good2, good1);
        detailTable.setGoods(goods);
        datas.setDetailTable(detailTable);
        
        Configure config = Configure.newBuilder().bind("detail_table", new DetailTablePolicy()).build();
        XWPFTemplate template = XWPFTemplate.compile(resource, config).render(datas);
        
		template.writeToFile(filePath+File.separator+"out_example_payment.docx");
    }
 
    
}
