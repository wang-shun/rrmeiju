package com.caizhukui.rrmeiju.bo;

import lombok.Data;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年10月19日
 */
@Data
public class CriteriaBO {
	
	/** 选择字段，默认全字段 */
	private String selectedFields;

	/** 可能为null，无过滤条件 */
	private String filterCondition;
	
	/** 可能为null，无排序条件 */
	private String sortCondition;
		
	/**  */
	private int pageSize;
	
	/**  */
	private int startIndex;
	
}
