package com.zayn.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class ExcelListener extends AnalysisEventListener<User> {
    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
