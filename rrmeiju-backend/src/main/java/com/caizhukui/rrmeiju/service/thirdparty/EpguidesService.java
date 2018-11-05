package com.caizhukui.rrmeiju.service.thirdparty;

import java.util.List;

import com.caizhukui.rrmeiju.model.Serial;

/**
 * Epguides服务接口
 * 
 * @author caizhukui
 * @date 2018年4月25日
 */
public interface EpguidesService {
    
    /**
     * 
     * 
     * @param serialUuid 美剧系列UUID
     * @return List<String>
     * @author caizhukui
     * @date 2018年5月24日
     */
    List<String> getEpisodeInfosBySerialUuid(String serialUuid);
    
    /**
     * 
     * 
     * @param serial
     * @return List<String>
     * @author caizhukui
     * @date 2018年5月23日
     */
    List<String> getInsertScriptsBySerial(Serial serial);
    
    /**
     * 
     * 
     * @return List<String>
     * @author caizhukui
     * @date 2018年5月24日
     */
    List<String> getInsertScriptsOfAll();

}
