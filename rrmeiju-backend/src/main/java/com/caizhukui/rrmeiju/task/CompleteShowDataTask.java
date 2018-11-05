package com.caizhukui.rrmeiju.task;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.common.util.StringUtils;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.service.CommonServiceFacade;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年1月19日
 */
//@Component
public class CompleteShowDataTask implements ScheduledTask {
    
    private static final Logger logger = LoggerFactory.getLogger(CompleteShowDataTask.class);
    
    @Autowired
    private ServiceFacade serviceFacade;
    
    @Autowired
    private CommonServiceFacade commonServiceFacade;
    
    @Scheduled(cron = "${cron.completeShowData}")
    public void completeShowData() throws Exception {
        int pageSize = 50, pageIndex = 1;
        List<Serial> serials = null;
        do {
            serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
            for (Serial serial : serials) {
                String englishSummary = serial.getEnglishSummary();
                if (StringUtils.isNotBlank(englishSummary)) {
                    String chineseSummary = commonServiceFacade.getTranslationService().translate(englishSummary);
                    logger.info("completeShowData - chineseSummary = {}", chineseSummary);
                    if (StringUtils.isNotBlank(chineseSummary)) {
                        serial.setChineseSummary(chineseSummary);
                        serial.setGmtModified(new Date());
                        serviceFacade.getSerialService().updateByUuid(serial);
                    }
                }
            }
        } while (CollectionUtils.isNotEmpty(serials));
    }

}
