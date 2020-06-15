# 总结

## 第一周

### officeutil

##### wordutil

技术点：poi-fl



------

问题：使用poi-fl远比freemarker方便，不用将模板转为xml格式，可以直接编辑模板。



------



##### excelutil

技术点：easyexcel



------

将单元格设置成文本格式，解决excel将长度大于13的数字转为科学计数法。

```java
// 内容的策略
WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
// 把单元格设置成文本格式	    
contentWriteCellStyle.setDataFormat((short)49);
```

------

问题：使用Swagger测试生成文件时，文件内容乱码。改为使用postman,测试正常。

------



##### pdfutil

技术点：freemarker itext

------

问题：

------

