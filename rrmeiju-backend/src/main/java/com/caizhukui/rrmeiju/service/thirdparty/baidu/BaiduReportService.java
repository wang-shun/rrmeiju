package com.caizhukui.rrmeiju.service.thirdparty.baidu;

import java.util.List;

import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.RealTimePairResultType;
import com.baidu.drapi.autosdk.sms.service.RealTimeQueryResultType;
import com.baidu.drapi.autosdk.sms.service.RealTimeResultType;
import com.baidu.drapi.autosdk.sms.service.ReportRequestType;
import com.caizhukui.rrmeiju.service.impl.thirdparty.ReportStateEnum;

/**
 * 推广效果详细报表服务接口<br>
 * 报告分为实时报告和异步报告两种类型<br>
 * 实时报告返回条数有限制，但实时响应性强，适用于小量、移动推广客户端等<br>
 * 异步报告需要从获取的链接进行报告下载<br>
 * 分小时报告支持账户、计划、单元、关键词、创意各层级<br>
 * 搜索词报告数据非完全实时，系统无法提供3个小时以内的结果
 * 
 * @author caizhukui
 * @date 2018年7月5日
 */
public interface BaiduReportService {
    
    /**
     * 获取实时报告，包含账户、计划、单元、关键词keywordid、关键词wordid、创意、地域等7种绩效数据报告
     * 
     * @param type 报告查询条件
     * @return List<RealTimeResultType>
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    List<RealTimeResultType> getRealTimeData(ReportRequestType type) throws ApiException;
    
    /**
     * 
     * 
     * @param type 报告查询条件
     * @return List<RealTimeQueryResultType>
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    List<RealTimeQueryResultType> getRealTimeQueryData(ReportRequestType type) throws ApiException;
    
    /**
     * 
     * 
     * @param type 报告查询条件
     * @return List<RealTimePairResultType>
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    List<RealTimePairResultType> getRealTimePairData(ReportRequestType type) throws ApiException;
    
    /**
     * 请求绩效数据异步报告
     * 
     * @param type 报告查询条件
     * @return String 生成的报告ID
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月5日
     */
    String getProfessionalReportId(ReportRequestType type) throws ApiException;
    
    /**
     * 查询报告生成状态
     * 
     * @param reportId 报告ID
     * @return ReportStateEnum 报告生成状态
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月5日
     */
    ReportStateEnum getReportState(String reportId) throws ApiException;
    
    /**
     * 获取异步报告下载地址
     * 
     * @param reportId 报告ID
     * @return String 异步报告下载地址
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月5日
     */
    String getReportFileUrl(String reportId) throws ApiException;

}
