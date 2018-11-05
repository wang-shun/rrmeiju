-- 命名规范：
-- 主键约束：pk_{table_name}
-- 外键约束：fk_{column_name}
-- 唯一约束：uk_{column_name}
-- MySQL不支持在DEFAULT默认值中使用函数

DROP DATABASE IF EXISTS rrmeiju;
CREATE DATABASE rrmeiju CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci';
USE rrmeiju;

-- IP表
DROP TABLE IF EXISTS `ip`;
CREATE TABLE `ip`
(
	`ip_id` CHAR(32) NOT NULL COMMENT 'IP地址ID',
	`ip` VARCHAR(39) UNIQUE NOT NULL COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`country` VARCHAR(20) COMMENT '国家',
	`province` VARCHAR(8) COMMENT '省份',
	`city` VARCHAR(11) COMMENT '城市',
	`operator` VARCHAR(10) COMMENT '运营商',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_ip` PRIMARY KEY (ip_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- IP黑名单表
DROP TABLE IF EXISTS `ip_blacklist`;
CREATE TABLE `ip_blacklist`
(
	`ip_id` CHAR(32) NOT NULL COMMENT 'IP地址ID',
	`ip` VARCHAR(39) UNIQUE NOT NULL COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_ip_blacklist` PRIMARY KEY (ip_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 手机号码段表
DROP TABLE IF EXISTS `mobile_locale`;
CREATE TABLE `mobile_locale`
(
	`mobile_locale_id` CHAR(32) NOT NULL COMMENT '手机号码段ID',
	`mobile_segment` CHAR(7) UNIQUE NOT NULL COMMENT '手机号码段（手机号前7位）',
	`mobile_area` VARCHAR(50) COMMENT '卡号归属地',
	`province` VARCHAR(11) COMMENT '卡号归属省份',
	`city` VARCHAR(20) COMMENT '卡号归属城市',
	`mobile_type` VARCHAR(50) COMMENT '卡类型',
	`operator` CHAR(2) COMMENT '运营商',
	`area_code` VARCHAR(10) COMMENT '区号',
	`post_code` VARCHAR(10) COMMENT '邮编',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_mobile_locale` PRIMARY KEY (mobile_locale_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 国家表


-- 省份表
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`
(
	`province_id` CHAR(32) NOT NULL COMMENT '省份ID',
	`province_name_chinese` VARCHAR(50) UNIQUE NOT NULL COMMENT '省份中文名',
	`province_abbr_chinese` VARCHAR(50) UNIQUE NOT NULL COMMENT '省份中文简称',
	`province_name_english` VARCHAR(50) UNIQUE NOT NULL COMMENT '省份英文名',
	`province_abbr_english` VARCHAR(10) UNIQUE NOT NULL COMMENT '省份英文简称',
	`code` VARCHAR(10) COMMENT '省份代码',
	`capital_name_chinese` VARCHAR(50) UNIQUE NOT NULL COMMENT '省会城市中文名',
	`capital_name_english` VARCHAR(50) UNIQUE NOT NULL COMMENT '省会城市英文名',
	`country_name_chinese` VARCHAR(50) UNIQUE NOT NULL COMMENT '国家中文名',
	`country_name_english` VARCHAR(50) UNIQUE NOT NULL COMMENT '国家英文名',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_province` PRIMARY KEY (province_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 城市表
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`
(
	`city_id` CHAR(32) NOT NULL COMMENT '城市ID',
	`city_name` VARCHAR(11) UNIQUE NOT NULL COMMENT '城市名称',
	`level` CHAR(1) NOT NULL COMMENT '行政级别',
	`code` CHAR(4) UNIQUE NOT NULL COMMENT '城市编码',
	`province_id` CHAR(32) NOT NULL COMMENT '所属省份ID',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_city` PRIMARY KEY (city_id),
	CONSTRAINT `fk_province_id` FOREIGN KEY (province_id) REFERENCES province(province_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 邮箱表
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email`
(
	`email_id` CHAR(32) NOT NULL,
	`host` VARCHAR(100) NOT NULL, 
	`port` INTEGER NOT NULL DEFAULT 25,
	`username` VARCHAR(100),
	`password` VARCHAR(100),
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY `pk_email` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`user_name` VARCHAR(100) UNIQUE NOT NULL COMMENT '用户名',
	`qq_openid` CHAR(32) UNIQUE COMMENT 'QQ的openID',
	`weixin_openid` CHAR(28) UNIQUE COMMENT '微信的openID',
	`weibo_uid` VARCHAR(32) UNIQUE COMMENT '新浪微博的uid',
	`baidu_uid` VARCHAR(32) UNIQUE COMMENT '百度的uid',
	`password` VARCHAR(100) COMMENT '密码',
	`nickname` VARCHAR(100) COMMENT '昵称',
	`sex` BIT NOT NULL DEFAULT 0 COMMENT '性别 (0:未知，1:男，2:女)',
	`email` VARCHAR(100) UNIQUE COMMENT '邮箱',
	`mobile_number` VARCHAR(20) UNIQUE COMMENT '手机号',
	`avatar_url` VARCHAR(200) COMMENT '头像URL',
	`source` INTEGER COMMENT '注册来源 (11:PC Web端，12:移动Web端，21:APP安卓端，22:APP iOS端，31:微信公众号，32:微信小程序)',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
	`account_non_expired` BIT NOT NULL DEFAULT 1 COMMENT '账号是否已过期',
	`account_non_locked` BIT NOT NULL DEFAULT 1 COMMENT '账号是否被封禁',
	`credentials_non_expired` BIT NOT NULL DEFAULT 1 COMMENT '账号权限是否已过期',
	`enabled` BIT NOT NULL DEFAULT 1 COMMENT '账号是否已激活',
	CONSTRAINT `pk_user` PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户第三方OAuth表
DROP TABLE IF EXISTS `user_oauth`;
CREATE TABLE `user_oauth`
(
	`user_oauth_id` CHAR(32) NOT NULL COMMENT '用户第三方OAuth记录ID',
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`access_token` VARCHAR(100) NOT NULL COMMENT '授权的唯一票据',
	`refresh_token` VARCHAR(100) COMMENT '刷新授权的唯一票据',
	`expires_in` INTEGER COMMENT 'access_token的有效期，单位是秒',
	`grant_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '授权时间',
	`expire_time` TIMESTAMP COMMENT '授权自然失效时间',
	`source` INTEGER COMMENT '第三方OAuth来源 (1:QQ，2:微信，3:新浪微博，4:百度，5:豆瓣)',
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `pk_user_oauth` PRIMARY KEY (user_oauth_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 角色表
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
	`role_id` CHAR(32) NOT NULL COMMENT '角色ID',
	`role_name` VARCHAR(20) NOT NULL COMMENT '角色名称',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_role` PRIMARY KEY (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户角色关联表
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
	`user_id` CHAR(32) NOT NULL,
	`role_id` CHAR(32) NOT NULL,
	CONSTRAINT `pk_user_role` PRIMARY KEY (user_id, role_id),
	CONSTRAINT `fk_user_id` FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_role_id` FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户剧集关联表
DROP TABLE IF EXISTS `user_serial`;
CREATE TABLE `user_serial`
(
	`user_id` CHAR(32) NOT NULL,
	`serial_id` CHAR(32) NOT NULL,
	CONSTRAINT `pk_user_serial` PRIMARY KEY (user_id, serial_id),
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_serial_id` FOREIGN KEY (serial_id) REFERENCES serial(serial_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户字幕组关联表
DROP TABLE IF EXISTS `user_fansub`;
CREATE TABLE `user_fansub`
(
	`user_id` CHAR(32) NOT NULL,
	`fansub_id` CHAR(32) NOT NULL,
	CONSTRAINT `pk_user_fansub` PRIMARY KEY (user_id, fansub_id),
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (fansub_id) REFERENCES fansub(fansub_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 电视台表
DROP TABLE IF EXISTS `television`;
CREATE TABLE `television`
(
	`television_id` CHAR(32) NOT NULL,
	`television_name` VARCHAR(100) UNIQUE NOT NULL,
	`homepage_url` VARCHAR(200) COMMENT '电视台官网主页URL',
	`logo_url` VARCHAR(200) COMMENT '电视台标志URL',
	`television_info` TEXT COMMENT '电视台简介',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_television` PRIMARY KEY (television_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 剧集表
DROP TABLE IF EXISTS `serial`;
CREATE TABLE `serial`
(
	`id` UNSIGNED BIGINT AUTO_INCREMENT, gmt_create, gmt_modified
	`serial_id` CHAR(32) NOT NULL,
	`serial_name_english` VARCHAR(100) NOT NULL COMMENT '英文名',
	`serial_name_chinese` VARCHAR(100) NOT NULL COMMENT '中文名',
	`serial_name_pinyin` VARCHAR(100) NOT NULL COMMENT '中文名拼音',
	`serial_alias_chinese` VARCHAR(100) COMMENT '中文名的其它翻译',
	`serial_alias_pinyin` VARCHAR(100) COMMENT '中文名的其它翻译拼音',
	`serial_name_epguides` VARCHAR(100) COMMENT '剧集在epguides的英文名',
	`official_site` VARCHAR(200) COMMENT '剧集官网URL',
	`language_english` VARCHAR(100) COMMENT '剧集语言（英文）',
	`language_chinese` VARCHAR(100) COMMENT '剧集语言（中文）',
	`runtime` INTEGER COMMENT '剧集时长（单位：分钟）',
	`tvmaze_id` INTEGER COMMENT '剧集在TVmaze的ID',
	`tvmaze_summary` TEXT COMMENT '剧集在TVmaze的简介',
	`television_id` CHAR(32) NOT NULL,
	`serial_info` TEXT COMMENT '系列简介',
	`finished` BIT NOT NULL DEFAULT 0 COMMENT '系列是否完结，0：未完结，1：已完结',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	CONSTRAINT `pk_serial` PRIMARY KEY (serial_id),
	UNIQUE KEY `serial_name` (`serial_name_english`,`serial_name_chinese`),
	CONSTRAINT `fk_television_id` FOREIGN KEY (television_id) REFERENCES television(television_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

17798864070

-- 季表
DROP TABLE IF EXISTS `season`;
CREATE TABLE `season`
(
	`season_id` CHAR(32) NOT NULL,
	`season_name_english` VARCHAR(100) NOT NULL COMMENT '英文名',
	`season_name_chinese` VARCHAR(100) UNIQUE NOT NULL COMMENT '中文名',
	`season_index` INTEGER NOT NULL DEFAULT 1 COMMENT '第几季',
	`summary` TEXT COMMENT '简介',
	`directors` VARCHAR(200) COMMENT '导演，多个值之间用英文逗号分隔',
	`casts` VARCHAR(200) COMMENT '主演，多个值之间用英文逗号分隔',
	`countries` VARCHAR(100) COMMENT '制片国家/地区，多个值之间用英文逗号分隔'
	`genres` VARCHAR(100) COMMENT '类型，多个值之间用英文逗号分隔',
	`serial_id` CHAR(32) NOT NULL COMMENT '季ID',
	`premiere_date` DATE NOT NULL COMMENT '首播日期',
	`episode_count` INTEGER NOT NULL COMMENT '集数',
	`poster_url` VARCHAR(500) COMMENT '海报链接URL',
	`bg_pic_url` VARCHAR(500) COMMENT '背景图片URL',
	`finished` BIT NOT NULL DEFAULT 0 COMMENT '季是否完结，0：未完结，1：已完结',
	`douban_id` VARCHAR(10) COMMENT '季在豆瓣的ID',
	`douban_url` VARCHAR(100) COMMENT '豆瓣条目页URL',
	`douban_rating` FLOAT COMMENT '豆瓣评分',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
	CONSTRAINT `pk_season` PRIMARY KEY (season_id),
	CONSTRAINT `fk_serial_id` FOREIGN KEY (serial_id) REFERENCES serial(serial_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 集表
DROP TABLE IF EXISTS `episode`;
CREATE TABLE `episode`
(
	`episode_id` CHAR(32) NOT NULL,
	`episode_index` INTEGER NOT NULL COMMENT '第几集',
	`episode_name` VARCHAR(200) NOT NULL COMMENT '分集标题',
	`season_id` CHAR(32) NOT NULL COMMENT '季ID',
	`air_date` DATE COMMENT '播出日期',
	CONSTRAINT `pk_episode` PRIMARY KEY (episode_id),
	CONSTRAINT `uk_episode` UNIQUE (season_id, episode_index),
	CONSTRAINT `fk_season_id` FOREIGN KEY (season_id) REFERENCES season(season_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 字幕表
DROP TABLE IF EXISTS `subtitle`;
CREATE TABLE `subtitle`
(
	`subtitle_id` CHAR(32) NOT NULL COMMENT '字幕ID',
	`subtitle_title` VARCHAR(500) NOT NULL COMMENT '字幕文件标题',
	`subtitle_url` VARCHAR(500) NOT NULL COMMENT '字幕文件链接',
	`subtitle_lang` VARCHAR(100) NOT NULL COMMENT '字幕文件语言，多个值之间用英文逗号分隔',
	`file_format` VARCHAR(100) NOT NULL COMMENT '字幕文件格式，多个值之间用英文逗号分隔',
	`file_size` INTEGER NOT NULL COMMENT '字幕文件大小，单位字节',
	`file_md5` VARCHAR(32) UNIQUE NOT NULL COMMENT '字幕文件MD5值',
	`episode_id` CHAR(32) NOT NULL COMMENT '集ID',
	`season_id` CHAR(32) NOT NULL COMMENT '季度ID',
	`file_id` CHAR(32) NOT NULL COMMENT '文件ID', -- 将来在多个地方存储相同数据需要，暂时不需要
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`fansub_id` CHAR(32) NOT NULL COMMENT '字幕组ID',
	`remark` VARCHAR(500) COMMENT '附加说明',
	`download_count` INTEGER NOT NULL DEFAULT 0 COMMENT '下载次数',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
	`deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否已删除：0-否，1-是',
	CONSTRAINT `pk_subtitle` PRIMARY KEY (subtitle_id),
	CONSTRAINT `fk_episode_id` FOREIGN KEY (episode_id) REFERENCES episode(episode_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_season_id` FOREIGN KEY (season_id) REFERENCES season(season_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`file_id`) REFERENCES `file`(`file_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_fansub_id` FOREIGN KEY (fansub_id) REFERENCES fansub(fansub_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 美剧视频表
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`
(
	`video_id` CHAR(32) NOT NULL COMMENT '视频ID',
	`video_title` VARCHAR(500) NOT NULL COMMENT '视频文件名',
	`video_url` VARCHAR(500) COMMENT '视频文件链接',
	`subtitle_lang` VARCHAR(100) NOT NULL COMMENT '内嵌字幕语言，多个值之间用英文逗号分隔',
	`video_format` VARCHAR(10) COMMENT '视频文件格式',
	`video_source` VARCHAR(20) COMMENT '视频所在平台，如百度网盘、哔哩哔哩等',
	`episode_id` CHAR(32) NOT NULL COMMENT '集ID',
	`season_id` CHAR(32) NOT NULL COMMENT '季度ID',
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`fansub_id` CHAR(32) NOT NULL COMMENT '字幕组ID',
	`remark` VARCHAR(500) COMMENT '附加说明',
	`view_count` INTEGER NOT NULL DEFAULT 0 COMMENT '观看次数',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
	`deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否已删除：0-否，1-是',
	CONSTRAINT `pk_video` PRIMARY KEY (video_id),
	CONSTRAINT FOREIGN KEY (episode_id) REFERENCES episode(episode_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (season_id) REFERENCES season(season_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (fansub_id) REFERENCES fansub(fansub_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 电影视频表
DROP TABLE IF EXISTS `movie_video`;
CREATE TABLE `movie_video`
(
	`video_id` CHAR(32) NOT NULL COMMENT '电影视频ID',
	`video_title` VARCHAR(500) NOT NULL COMMENT '电影视频文件名',
	`video_url` VARCHAR(500) COMMENT '电影视频文件链接',
	`subtitle_lang` VARCHAR(100) NOT NULL COMMENT '内嵌字幕语言，多个值之间用英文逗号分隔',
	`video_format` VARCHAR(10) COMMENT '视频文件格式',
	`video_source` VARCHAR(20) COMMENT '视频所在平台，如百度网盘、哔哩哔哩等',
	`episode_id` CHAR(32) NOT NULL COMMENT '集ID',
	`season_id` CHAR(32) NOT NULL COMMENT '季度ID',
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`fansub_id` CHAR(32) NOT NULL COMMENT '字幕组ID',
	`remark` VARCHAR(500) COMMENT '附加说明',
	`view_count` INTEGER NOT NULL DEFAULT 0 COMMENT '观看次数',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
	`deleted` BIT NOT NULL DEFAULT 0 COMMENT '是否已删除：0-否，1-是',
	CONSTRAINT `pk_video` PRIMARY KEY (video_id),
	CONSTRAINT FOREIGN KEY (episode_id) REFERENCES episode(episode_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (season_id) REFERENCES season(season_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (fansub_id) REFERENCES fansub(fansub_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 字幕下载记录表
DROP TABLE IF EXISTS `subtitle_download`;
CREATE TABLE `subtitle_download`
(
	`subtitle_download_id` CHAR(32) NOT NULL COMMENT '字幕下载记录ID',
	`subtitle_id` CHAR(32) NOT NULL COMMENT '字幕ID',
	`user_id` CHAR(32) COMMENT '用户ID',
	`remote_ip` VARCHAR(39) COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`download_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下载时间',
	CONSTRAINT `pk_subtitle_download` PRIMARY KEY (subtitle_download_id),
	CONSTRAINT `fk_subtitle_id` FOREIGN KEY (`subtitle_id`) REFERENCES `subtitle`(`subtitle_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 字幕文件表
DROP TABLE IF EXISTS `subtitle_file`;
CREATE TABLE `subtitle_file`
(
	`file_id` CHAR(32) NOT NULL COMMENT '字幕文件ID',
	`file_name` VARCHAR(500) NOT NULL COMMENT '字幕文件名称',
	`file_size` INTEGER NOT NULL COMMENT '字幕文件大小，单位字节',
	`subtitle_id` CHAR(32) NOT NULL COMMENT '字幕ID',
	CONSTRAINT `pk_subtitle_file` PRIMARY KEY (file_id),
	CONSTRAINT FOREIGN KEY (`subtitle_id`) REFERENCES `subtitle`(`subtitle_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 字幕组表
DROP TABLE IF EXISTS `fansub`;
CREATE TABLE `fansub`
(
	`fansub_id` CHAR(32) NOT NULL COMMENT '字幕组ID',
	`fansub_name` VARCHAR(100) NOT NULL COMMENT '字幕组名称',
	`fansub_info` VARCHAR(1000) COMMENT '字幕组简介',
	`foundation_year` VARCHAR(10) COMMENT '字幕组成立年份',
	`logo_url` VARCHAR(200) COMMENT '字幕组徽标URL',
	`homepage_url` VARCHAR(200) COMMENT '字幕组官网主页URL',
	`weibo_url` VARCHAR(200) COMMENT '微博主页URL',
	`wechat` VARCHAR(20) COMMENT '微信公众号',
	`wechat_url` VARCHAR(200) COMMENT '微信公众号二维码图片URL',
	`bulletin` VARCHAR(1000) COMMENT '字幕组公告',
	CONSTRAINT `pk_fansub` PRIMARY KEY (fansub_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 资讯表
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`
(
	`news_id` CHAR(32) NOT NULL COMMENT '资讯ID',
	`news_title` VARCHAR(200) NOT NULL COMMENT '资讯标题',
	`news_content` TEXT NOT NULL COMMENT '资讯内容',
	`keywords` VARCHAR(200) COMMENT '关键词',
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`season_id` CHAR(32) COMMENT '季度ID',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT `pk_news` PRIMARY KEY (news_id),
	CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY (`season_id`) REFERENCES `season`(`season_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 文件表
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`
(
	`file_id` CHAR(32) NOT NULL COMMENT '文件ID',
	`file_name` VARCHAR(500) NOT NULL COMMENT '文件名', 
	`file_size` INTEGER NOT NULL COMMENT '文件大小',
	`file_object_key` VARCHAR(500) NOT NULL COMMENT '文件存储到云端的文件名',
	`file_local_url` VARCHAR(500) NOT NULL COMMENT '本地存储URL',
	`file_bos_url` VARCHAR(500) COMMENT '百度对象存储URL',
	`file_cos_url` VARCHAR(500) COMMENT '阿里巴巴对象存储URL',
	`file_oss_url` VARCHAR(500) COMMENT '阿里巴巴对象存储URL', 
	`file_qiniu_url` VARCHAR(500) COMMENT '七牛对象存储URL', 
	`file_upyun_url` VARCHAR(500) COMMENT '又拍对象存储URL',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT `pk_file` PRIMARY KEY (file_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 首页搜索记录表
DROP TABLE IF EXISTS `index_search_record`;
CREATE TABLE `index_search_record`
(
	`record_id` CHAR(32) NOT NULL COMMENT '首页搜索记录ID',
	`user_id` CHAR(32) COMMENT '用户ID',
	`remote_ip` VARCHAR(39) COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`keyword` VARCHAR(20) NOT NULL COMMENT '搜索关键字',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '搜索时间',
	CONSTRAINT `pk_index_search_record` PRIMARY KEY (record_id),
	CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 短信发送记录表
DROP TABLE IF EXISTS `sms_send_record`;
CREATE TABLE `sms_send_record`
(
	`record_id` CHAR(32) NOT NULL COMMENT '短信发送记录ID',
	`mobile_number` NOT NULL VARCHAR(20) COMMENT '手机号',
	`remote_ip` VARCHAR(39) COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`type` INTEGER COMMENT '短信发送类型 (1:用户注册，2:用户登录，3:重置密码)',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '搜索时间',
	CONSTRAINT `pk_sms_send_record` PRIMARY KEY (record_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户登录记录表
DROP TABLE IF EXISTS `user_login_record`;
CREATE TABLE `user_login_record`
(
	`record_id` CHAR(32) NOT NULL COMMENT '用户登录记录ID',
	`user_name` VARCHAR(100) COMMENT '用户名',
	`email` VARCHAR(100) COMMENT '邮箱',
	`mobile_number` VARCHAR(20) COMMENT '手机号',
	`qq_openid` CHAR(32) COMMENT 'QQ的openID',
	`weixin_openid` CHAR(28) COMMENT '微信的openID',
	`weibo_uid` VARCHAR(32) COMMENT '新浪微博的uid',
	`baidu_uid` VARCHAR(32) COMMENT '百度的uid',
	`remote_ip` VARCHAR(39) COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`login_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
	CONSTRAINT `pk_user_login_record` PRIMARY KEY (record_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 用户注册记录表
DROP TABLE IF EXISTS `user_register_record`;
CREATE TABLE `user_register_record`
(
	`record_id` CHAR(32) NOT NULL COMMENT '用户注册记录ID',
	`user_name` VARCHAR(100) COMMENT '用户名',
	`mobile_number` VARCHAR(20) COMMENT '手机号',
	`qq_openid` CHAR(32) COMMENT 'QQ的openID',
	`weixin_openid` CHAR(28) COMMENT '微信的openID',
	`weibo_uid` VARCHAR(32) COMMENT '新浪微博的uid',
	`baidu_uid` VARCHAR(32) COMMENT '百度的uid',
	`remote_ip` VARCHAR(39) COMMENT '客户端IP地址，IPv4格式地址最大长度为15，IPv6格式地址长度为39',
	`register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
	CONSTRAINT `pk_user_register_record` PRIMARY KEY (record_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 系列搜索记录表
DROP TABLE IF EXISTS `serial_search_record`;
CREATE TABLE `serial_search_record`
(
	`record_id` CHAR(32) NOT NULL COMMENT '搜索记录ID',
	`user_id` CHAR(32) NOT NULL COMMENT '用户ID',
	`keyword` VARCHAR(100) NOT NULL COMMENT '搜索关键字',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '搜索时间',
	CONSTRAINT `pk_serial_search_record` PRIMARY KEY (record_id),
	CONSTRAINT `fk_user_id` FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 首页背景图片文件表
DROP TABLE IF EXISTS `idx_bg_pic`;
CREATE TABLE `idx_bg_pic`
(
	`file_id` CHAR(32) NOT NULL COMMENT '文件ID',
	`file_url` CHAR(500) COMMENT '文件链接',
	CONSTRAINT `pk_file` PRIMARY KEY (file_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 公共的序列表（模拟Oracle的sequence）
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence`
(
	`name` VARCHAR(50) NOT NULL COMMENT '序列名',
	`current_value` BIGINT NOT NULL COMMENT '当前值',
	`increment` INT NOT NULL DEFAULT 1 COMMENT '步长，默认为1',
	CONSTRAINT `pk_sequence` PRIMARY KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 获取当前序列的值
DROP FUNCTION IF EXISTS `func_currval`;
DELIMITER $$
CREATE FUNCTION func_currval (seq_name varchar(50))
RETURNS INTEGER
BEGIN
	DECLARE `currval` INTEGER;
	SET `currval` = 0;
	SELECT current_value INTO `currval`
	FROM `sequence`
	WHERE name = seq_name;
	RETURN `currval`;
END$$

-- 获取序列中下一个可用的值
DROP FUNCTION IF EXISTS `func_nextval`;
DELIMITER $$
CREATE FUNCTION `func_nextval` (seq_name VARCHAR(50))
RETURNS INTEGER
CONTAINS SQL
BEGIN
	UPDATE `sequence`
	SET current_value = current_value + `increment`
	WHERE name = seq_name;
	RETURN func_currval(seq_name);
END$$

-- role表生成UUID主键
DELIMITER $$
CREATE TRIGGER role_uuid BEFORE INSERT ON role 
FOR EACH ROW 
BEGIN
  IF NEW.role_id = NULL THEN 
    SET NEW.role_id = LOWER(REPLACE(UUID(), '-', ''));
  END IF;
END$$

新浪微博appKey=195146174,appSercet=530b935d5facf595ea9e00923e0a9601

CURRENT_TIMESTAMP
