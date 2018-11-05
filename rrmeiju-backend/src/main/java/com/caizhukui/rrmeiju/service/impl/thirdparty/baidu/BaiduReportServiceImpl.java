package com.caizhukui.rrmeiju.service.impl.thirdparty.baidu;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baidu.drapi.autosdk.core.ResHeader;
import com.baidu.drapi.autosdk.core.ResHeaderUtil;
import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.GetProfessionalReportIdData;
import com.baidu.drapi.autosdk.sms.service.GetProfessionalReportIdRequest;
import com.baidu.drapi.autosdk.sms.service.GetProfessionalReportIdResponse;
import com.baidu.drapi.autosdk.sms.service.GetRealTimeDataRequest;
import com.baidu.drapi.autosdk.sms.service.GetRealTimeDataResponse;
import com.baidu.drapi.autosdk.sms.service.GetRealTimePairDataRequest;
import com.baidu.drapi.autosdk.sms.service.GetRealTimePairDataResponse;
import com.baidu.drapi.autosdk.sms.service.GetRealTimeQueryDataRequest;
import com.baidu.drapi.autosdk.sms.service.GetRealTimeQueryDataResponse;
import com.baidu.drapi.autosdk.sms.service.GetReportFileUrlData;
import com.baidu.drapi.autosdk.sms.service.GetReportFileUrlRequest;
import com.baidu.drapi.autosdk.sms.service.GetReportFileUrlResponse;
import com.baidu.drapi.autosdk.sms.service.GetReportStateData;
import com.baidu.drapi.autosdk.sms.service.GetReportStateRequest;
import com.baidu.drapi.autosdk.sms.service.GetReportStateResponse;
import com.baidu.drapi.autosdk.sms.service.RealTimePairResultType;
import com.baidu.drapi.autosdk.sms.service.RealTimeQueryResultType;
import com.baidu.drapi.autosdk.sms.service.RealTimeResultType;
import com.baidu.drapi.autosdk.sms.service.ReportRequestType;
import com.baidu.drapi.autosdk.sms.service.ReportService;
import com.caizhukui.common.util.Assert;
import com.caizhukui.rrmeiju.service.impl.thirdparty.PerformanceEnum;
import com.caizhukui.rrmeiju.service.thirdparty.baidu.BaiduReportService;

/**
 * 推广效果详细报表服务实现类
 * 
 * @author caizhukui
 * @date 2018年7月5日
 */
@Service
public class BaiduReportServiceImpl extends BaiduServiceImpl implements BaiduReportService {
    
    private static final Logger logger = LoggerFactory.getLogger(BaiduReportServiceImpl.class);
    
    /** 全部返回数据类型 */
    private List<String> allPerformanceData;
    
    /** 常用必需返回数据类型 */
    private List<String> commonMustHavePerformanceData;
    
    /** 报告服务 */
    private ReportService reportService;
    
    public BaiduReportServiceImpl() throws ApiException {
        super();
        reportService = factory.getService(ReportService.class);
        Arrays.stream(PerformanceEnum.values()).forEach(item -> allPerformanceData.add(item.getValue()));
        commonMustHavePerformanceData = Arrays
                .asList(new String[] { PerformanceEnum.IMPRESSION.getValue(), PerformanceEnum.CLICK.getValue() });
    }

    @Override
    public List<RealTimeResultType> getRealTimeData(ReportRequestType type) throws ApiException {
        List<String> validPerformanceData = allPerformanceData;
        List<String> mustHavePerformanceData = commonMustHavePerformanceData;
        validatePerformanceData(type.getPerformanceData(), validPerformanceData, mustHavePerformanceData);
        GetRealTimeDataRequest request = new GetRealTimeDataRequest();
        request.setRealTimeRequestType(type);
        GetRealTimeDataResponse response = reportService.getRealTimeData(request);
        ResHeader header = ResHeaderUtil.getResHeader(reportService, true);
        List<RealTimeResultType> data = response.getData();
        logger.debug("getRealTimeData - header = {}, data = {}", header, data);
        if (isSuccess(header)) {
            
        }
        return data;
    }

    @Override
    public List<RealTimeQueryResultType> getRealTimeQueryData(ReportRequestType type) throws ApiException {
        List<String> validPerformanceData = Arrays.asList(new String[] { PerformanceEnum.IMPRESSION.getValue(),
                PerformanceEnum.CLICK.getValue(), PerformanceEnum.COST.getValue() });
        List<String> mustHavePerformanceData = commonMustHavePerformanceData;
        validatePerformanceData(type.getPerformanceData(), validPerformanceData, mustHavePerformanceData);
        GetRealTimeQueryDataRequest request = new GetRealTimeQueryDataRequest();
        request.setRealTimeQueryRequestType(type);
        GetRealTimeQueryDataResponse response = reportService.getRealTimeQueryData(request);
        ResHeader header = ResHeaderUtil.getResHeader(reportService, true);
        List<RealTimeQueryResultType> data = response.getData();
        logger.debug("getRealTimeQueryData - header = {}, data = {}", header, data);
        if (isSuccess(header)) {
            
        }
        return data;
    }
    
    @Override
    public List<RealTimePairResultType> getRealTimePairData(ReportRequestType type) throws ApiException {
        List<String> validPerformanceData = Arrays.asList(new String[] { PerformanceEnum.COST.getValue(),
                PerformanceEnum.CPC.getValue(), PerformanceEnum.CLICK.getValue(), PerformanceEnum.IMPRESSION.getValue(),
                PerformanceEnum.CTR.getValue(), PerformanceEnum.CPM.getValue(), PerformanceEnum.POSITION.getValue(),
                PerformanceEnum.CONVERSION.getValue() });
        List<String> mustHavePerformanceData = commonMustHavePerformanceData;
        validatePerformanceData(type.getPerformanceData(), validPerformanceData, mustHavePerformanceData);
        GetRealTimePairDataRequest request = new GetRealTimePairDataRequest();
        request.setRealTimePairRequestType(type);
        GetRealTimePairDataResponse response = reportService.getRealTimePairData(request);
        ResHeader header = ResHeaderUtil.getResHeader(reportService, true);
        List<RealTimePairResultType> data = response.getData();
        logger.debug("getRealTimePairData - header = {}, data = {}", header, data);
        if (isSuccess(header)) {
            
        }
        return data;
    }

    @Override
    public String getProfessionalReportId(ReportRequestType type) throws ApiException {
        List<String> validPerformanceData = allPerformanceData;
        List<String> mustHavePerformanceData = Arrays.asList(new String[] {});
        validatePerformanceData(type.getPerformanceData(), validPerformanceData, mustHavePerformanceData);
        GetProfessionalReportIdRequest request = new GetProfessionalReportIdRequest();
        request.setReportRequestType(type);
        GetProfessionalReportIdResponse response = reportService.getProfessionalReportId(request);
        ResHeader header = ResHeaderUtil.getResHeader(reportService, true);
        List<GetProfessionalReportIdData> data = response.getData();
        logger.debug("getProfessionalReportId - header = {}, data = {}", header, data);
        String reportId = null;
        if (isSuccess(header)) {
            reportId = data.get(0).getReportId();
        }
        return reportId;
    }

    @Override
    public ReportStateEnum getReportState(String reportId) throws ApiException {
        GetReportStateRequest request = new GetReportStateRequest();
        request.setReportId(reportId);
        GetReportStateResponse response = reportService.getReportState(request);
        ResHeader header = ResHeaderUtil.getResHeader(reportService, true);
        List<GetReportStateData> data = response.getData();
        logger.debug("getReportState - header = {}, data = {}", header, data);
        Integer reportStateValue = null;
        if (isSuccess(header)) {
            reportStateValue = data.get(0).getIsGenerated();
        }
        return ReportStateEnum.getByValue(reportStateValue);
    }

    @Override
    public String getReportFileUrl(String reportId) throws ApiException {
        GetReportFileUrlRequest request = new GetReportFileUrlRequest();
        request.setReportId(reportId);
        GetReportFileUrlResponse response = reportService.getReportFileUrl(request);
        ResHeader header = ResHeaderUtil.getResHeader(reportService, true);
        List<GetReportFileUrlData> data = response.getData();
        logger.debug("getReportFileUrl - header = {}, data = {}", header, data);
        String reportFileUrl = null;
        if (isSuccess(header)) {
            reportFileUrl = data.get(0).getReportFilePath();
        }
        return reportFileUrl;
    }

    private void validatePerformanceData(List<String> performanceData, List<String> validPerformanceData,
            List<String> mustHavePerformanceData) {
        Assert.isTrue(validPerformanceData.containsAll(performanceData)
                && performanceData.containsAll(mustHavePerformanceData), new PerformanceDataException());
    }

}
