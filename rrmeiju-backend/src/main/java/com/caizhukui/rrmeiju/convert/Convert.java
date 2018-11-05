package com.caizhukui.rrmeiju.convert;

import java.util.ArrayList;
import java.util.List;

import com.caizhukui.common.util.CollectionUtils;

/**
 * Model和DTO的转换接口
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
public interface Convert<Model, DTO> {
    
    /**
     * 把Model转换成DTO
     * 
     * @param model
     * @return DTO
     * @author caizhukui
     * @date 2018年5月24日
     */
    DTO model2Dto(Model model);
    
    /**
     * 把DTO转换成Model
     * 
     * @param dto
     * @return Model
     * @author caizhukui
     * @date 2018年5月24日
     */
    Model dto2Model(DTO dto);
    
    /**
     * 把Model转换成DTO
     * 
     * @param models
     * @return List<DTO>
     * @author caizhukui
     * @date 2018年5月24日
     */
    default List<DTO> model2Dto(List<Model> models) {
        if (CollectionUtils.isEmpty(models)) {
            return null;
        }
        List<DTO> dtos = new ArrayList<>(models.size());
        models.forEach(model -> dtos.add(model2Dto(model)));
        return dtos;
    }
    
    /**
     * 把DTO转换成Model
     * 
     * @param dtos
     * @return List<Model>
     * @author caizhukui
     * @date 2018年5月24日
     */
    default List<Model> dto2Model(List<DTO> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return null;
        }
        List<Model> models = new ArrayList<>(dtos.size());
        dtos.forEach(dto -> models.add(dto2Model(dto)));
        return models;
    }

}
