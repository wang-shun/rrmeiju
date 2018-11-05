package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.UserDTO;
import com.caizhukui.rrmeiju.model.User;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月10日
 */
@Component
public class UserConvert implements Convert<User, UserDTO> {

    @Override
    public UserDTO model2Dto(User model) {
        UserDTO dto = null;
        if (model != null) {
            dto = new UserDTO();
            dto.setUuid(model.getUuid());
            dto.setUserName(model.getUserName());
            dto.setQqOpenId(model.getQqOpenId());
            dto.setWeixinOpenId(model.getWeixinOpenId());
            dto.setWeiboUid(model.getWeiboUid());
            dto.setBaiduUid(model.getBaiduUid());
            // 查询用户信息的时候不返回password
            // dto.setPassword(model.getPassword());
            dto.setNickname(model.getNickname());
            dto.setSex(model.getSex());
            dto.setEmail(model.getEmail());
            dto.setMobileNumber(model.getMobileNumber());
            dto.setAvatarUrl(model.getAvatarUrl());
            dto.setSource(model.getSource());
            dto.setCreateTime(model.getCreateTime());
            dto.setAccountNonExpired(model.isAccountNonExpired());
            dto.setAccountNonLocked(model.isAccountNonLocked());
            dto.setCredentialsNonExpired(model.isCredentialsNonExpired());
            dto.setEnabled(model.isEnabled());
            dto.setCreateTime(model.getCreateTime());
        }
        return dto;
    }

    @Override
    public User dto2Model(UserDTO dto) {
        User model = null;
        if (dto != null) {
            model = new User();
            model.setUuid(dto.getUuid());
            model.setUserName(dto.getUserName());
            model.setQqOpenId(dto.getQqOpenId());
            model.setWeixinOpenId(dto.getWeixinOpenId());
            model.setWeiboUid(dto.getWeiboUid());
            model.setBaiduUid(dto.getBaiduUid());
            model.setPassword(dto.getPassword());
            model.setNickname(dto.getNickname());
            model.setSex(dto.getSex());
            model.setEmail(dto.getEmail());
            model.setMobileNumber(dto.getMobileNumber());
            model.setAvatarUrl(dto.getAvatarUrl());
            model.setSource(dto.getSource());
            model.setAccountNonExpired(dto.isAccountNonExpired());
            model.setAccountNonLocked(dto.isAccountNonLocked());
            model.setCredentialsNonExpired(dto.isCredentialsNonExpired());
            model.setEnabled(model.isEnabled());
            model.setCreateTime(dto.getCreateTime());
        }
        return model;
    }

}
