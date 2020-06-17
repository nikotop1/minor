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

## 第二周

### mybatis

------

#### mybatis-Generator

##### 问题

代码生成器会生成数据库中同名表的字段

##### 解决方法

添加

```xml
<property name="nullCatalogMeansCurrent" value="true"/>
```

```xml
<!--数据库链接URL，用户名、密码 -->
<jdbcConnection driverClass="${spring.datasource.driver-class-name}"
			    connectionURL="${spring.datasource.url}"
			    userId="${spring.datasource.username}"                                           password="${spring.datasource.password}">
			<property name="nullCatalogMeansCurrent" value="true"/>
</jdbcConnection>
```

# TODO

两句SQL,第一条成功，第二条失败，Spring进行回滚。

大事务中两个事务，第一个事务成功，第二个事务失败，回滚。