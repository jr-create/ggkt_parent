package com.wjr.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 29375-wjr
 * @Package: com.wjr.excel
 * @ClassName: ExcelListener
 * @create 2022-08-01 22:16
 * @Description:
 */
public class ExcelListener extends AnalysisEventListener<Stu> {
    //创建list集合封装最终的数据
    List<Stu> list = new ArrayList<>();

    //一行一行去读取excle内容
    @Override
    public void invoke(Stu user, AnalysisContext analysisContext) {
        System.out.println("***" + user);
        list.add(user);
    }

    //读取excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息：" + headMap);
    }

    //读取完成后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}
