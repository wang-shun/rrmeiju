package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.SubtitleFileMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.SubtitleFile;
import com.caizhukui.rrmeiju.service.SubtitleFileService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 字幕文件服务实现
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
@Service
public class SubtitleFileServiceImpl extends BaseServiceImpl<SubtitleFile> implements SubtitleFileService {
	
	@Autowired
	private SubtitleFileMapper subtitleFileMapper;

	@Override
	public List<SubtitleFile> getBySubtitleUuid(String subtitleUuid) {
		List<SubtitleFile> subtitleFiles = subtitleFileMapper.getBySubtitleUuid(subtitleUuid);
		return CollectionUtils.emptyListInsteadOfNull(subtitleFiles);
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.SUBTITLE_FILE;
    }

    @Override
    protected BaseMapper<SubtitleFile> getMapper() {
        return subtitleFileMapper;
    }

}
