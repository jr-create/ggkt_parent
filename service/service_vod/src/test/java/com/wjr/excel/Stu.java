package com.wjr.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 29375-wjr
 * @Package: com.wjr.excel
 * @ClassName: User
 * @create 2022-08-01 22:07
 * @Description:
 */
@Data
public class Stu {
    //设置表头名称
    //设置列对应的属性
    @ExcelProperty(value = "学生编号",index = 0)
    private int sno;
    //设置表头名称
    //设置列对应的属性
    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;


}
