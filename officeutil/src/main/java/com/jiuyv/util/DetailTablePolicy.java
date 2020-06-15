package com.jiuyv.util;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.policy.DynamicTableRenderPolicy;
import com.deepoove.poi.policy.MiniTableRenderPolicy;
import com.deepoove.poi.util.TableTools;


public class DetailTablePolicy extends DynamicTableRenderPolicy {

    // 货品填充数据所在行数
    int goodsStartRow = 3;
 

    @Override
    public void render(XWPFTable table, Object data) {
        if (null == data) { return;}
        DetailData detailData = (DetailData) data;

        List<RowRenderData> goods = detailData.getGoods();
        
        if (null != goods) {
            table.removeRow(goodsStartRow);
            for (int i = 0; i < goods.size(); i++) {
                XWPFTableRow insertNewTableRow = table.insertNewTableRow(goodsStartRow);
                for (int j = 0; j < 6; j++) {
                	insertNewTableRow.createCell();
                }
                MiniTableRenderPolicy.Helper.renderRow(table, goodsStartRow, goods.get(i));
            }
        }
    }

}