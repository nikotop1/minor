//package com.jiuyv.util;
//
//import com.alibaba.excel.ExcelReader;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.context.AnalysisContext;
//import com.alibaba.excel.event.AnalysisEventListener;
//import com.alibaba.excel.metadata.BaseRowModel;
//import com.alibaba.excel.metadata.Font;
//import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.metadata.TableStyle;
//import com.alibaba.excel.support.ExcelTypeEnum;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
// 
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
// 
// 
//public final class EasyExcelReadUtil {
// 
//    //log日志
//    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelReadUtil.class);
// 
//    private EasyExcelReadUtil() {
// 
//    }
// 
//    /**
//     * 模型解析监听器
//     */
//    private static class ModelExcelListener extends AnalysisEventListener {
// 
//        //自定义用于暂时存储data
//        //可以通过实例获取该值
//        private List<Object> datas = new ArrayList<>();
// 
//        /**
//         * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
//         * @param object
//         * @param context
//         */
//        @Override
//        public void invoke(Object object, AnalysisContext context) {
//            //数据存储到list，供批量处理，或后续自己业务逻辑处理。
//            datas.add(object);
//        }
// 
//        @Override
//        public void doAfterAllAnalysed(AnalysisContext context) {
//            // Do nothing because of X and Y.
//        }
// 
//        public List<Object> getDatas() {
//            return datas;
//        }
// 
//        public void setDatas(List<Object> datas) {
//            this.datas = datas;
//        }
//    }
// 
//    /**
//     * 使用模型来读取Excel（一个 sheet）
//     * @param inputStream Excel的输入流
//     * @param clazz 模型的类
//     * @param excelTypeEnum Excel的格式(XLS或XLSX)
//     * @return 返回模型的列表(为object列表, 需强转)
//     */
//    public static <T extends BaseRowModel> List<T> readExcelWithModel(InputStream inputStream, Class<T> clazz,
//            ExcelTypeEnum excelTypeEnum) {
//        // 解析每行结果在listener中处理
//        ModelExcelListener listener = new ModelExcelListener();
//        ExcelReader excelReader = new ExcelReader(inputStream, excelTypeEnum, null, listener);
//        if (excelReader == null) {
//            return new ArrayList<>();
//        }
//        //默认只有一列表头
//        excelReader.read(new Sheet(1, 1, clazz));
//        return BeanConvert.objectConvertBean(listener.getDatas(), clazz);
//    }
// 
//    /**
//     * 使用模型来读取Excel（多个 sheet）
//     * @param inputStream Excel的输入流
//     * @param clazz 模型的类
//     * @param excelTypeEnum Excel的格式(XLS或XLSX)
//     * @return 返回模型的列表(为object列表, 需强转)
//     */
//    public static <T extends BaseRowModel> List<T> readExcelWithModelSheet(InputStream inputStream, Class<T> clazz,
//            ExcelTypeEnum excelTypeEnum) {
//        // 解析每行结果在listener中处理
//        ModelExcelListener listener = new ModelExcelListener();
//        ExcelReader excelReader = new ExcelReader(inputStream, excelTypeEnum, null, listener);
//        if (excelReader == null) {
//            return new ArrayList<>();
//        }
//        for (Sheet sheet : excelReader.getSheets()) {
//            if (clazz != null) {
//                sheet.setClazz(clazz);
//            }
//            excelReader.read(sheet);
//        }
//        return BeanConvert.objectConvertBean(listener.getDatas(), clazz);
//    }
// 
// 
//
//    /**
//     * 得到流
//     * @param response 响应
//     * @param fileName 文件名
//     * @param excelTypeEnum excel类型
//     * @return
//     */
//    private static OutputStream getOutputStream(HttpServletResponse response, String fileName,
//            ExcelTypeEnum excelTypeEnum) {
//        try {
//            // 设置响应输出的头类型
//            if (Objects.equals(".xls", excelTypeEnum.getValue())) {
//                //导出xls格式
//                response.setContentType("application/vnd.ms-excel;charset=GBK");
//            } else if (Objects.equals(".xlsx", excelTypeEnum.getValue())) {
//                //导出xlsx格式
//                response.setContentType(
//                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=GBK");
//            }
//            // 设置下载文件名称(注意中文乱码)
//            response.addHeader("Content-Disposition",
//                    "attachment;filename=" + new String((fileName).getBytes("GB2312"), "ISO8859-1") + excelTypeEnum
//                            .getValue());
//            response.addHeader("Pragma", "No-cache");
//            response.addHeader("Cache-Control", "No-cache");
//            response.setCharacterEncoding("utf8");
//            return response.getOutputStream();
//        } catch (IOException e) {
//            LOGGER.error("EasyExcelUtil-->getOutputStream exception:", e);
//        }
//        return null;
//    }
// 
//    /**
//     * 设置表格样式
//     * @return
//     */
//    public static TableStyle createTableStyle() {
//        TableStyle tableStyle = new TableStyle();
//        Font headFont = new Font();
//        headFont.setBold(true);
//        headFont.setFontHeightInPoints((short) 20);
//        headFont.setFontName("楷体");
//        tableStyle.setTableHeadFont(headFont);
//        tableStyle.setTableHeadBackGroundColor(IndexedColors.LIGHT_GREEN);
// 
//        Font contentFont = new Font();
//        contentFont.setFontHeightInPoints((short) 12);
//        contentFont.setFontName("黑体");
//        tableStyle.setTableContentFont(contentFont);
//        return tableStyle;
//    }
// 
// 
//}