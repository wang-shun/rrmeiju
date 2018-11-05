

USE rrmeiju;
INSERT INTO user(user_id, user_name, password, nickname, source)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'yanyufeng', '$2a$10$ejyLT8tbdE0obHsALtm0qOVkHDru.6Dr2gF.zxtNXl2RiH924SVYi', '最初最后的骑士', 11);
INSERT INTO user(user_id, user_name, password, nickname, source)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'yangjinping', '$2a$10$ejyLT8tbdE0obHsALtm0qOVkHDru.6Dr2gF.zxtNXl2RiH924SVYi', '兔子洞的爱丽丝', 11);
INSERT INTO user(user_id, user_name, password, nickname, source)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'chenchangqin', '$2a$10$ejyLT8tbdE0obHsALtm0qOVkHDru.6Dr2gF.zxtNXl2RiH924SVYi', '傲娇的宅小二', 11);
--------------------------------------------------------------------------------------------------------------------------Fansubs
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'YYeTs字幕组', '2005', 'http://weibo.com/yyets');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'FIX字幕组', '2014', 'http://subhd.com');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '电波字幕组', '2012', 'http://dbfansub.com', 'http://weibo.com/dbfansub');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'EF字幕组', '2012', '', 'http://weibo.com/p/1005053924780121');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '药丸字幕组', '2012', '', 'http://weibo.com/p/1005055992892322');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '深影字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, fansub_info, foundation_year, homepage_url, weibo_url, bulletin) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '迪幻字幕组', '', '2012', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'SSK字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '不着调字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '大家字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'Orange字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'UnIon字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '翻托邦字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '树屋字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'X字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '蓝血字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '冰冰字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '伊甸园字幕组', '2004', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '空白页字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '衣柜字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '天天美剧字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '擦枪字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'GA字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '风骨字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '闪电字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'H-SGDK字幕组', '2012', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '原版字幕', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '官方译本', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '圣城家园SCG字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'CMCT字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '图南字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'LOT译者联盟', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'Classic字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '玄字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '校订翻译', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '个人原创翻译', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '其它来源', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '耐卡字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '觉醒字幕组', '', 'http://www.awaker.cn/', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '远鉴字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '盛夏堂字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '漫游字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '破烂熊字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '火星字幕组', '', '', '');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), '波旁姐妹花字幕组', '', '', 'http://weibo.com/u/3674900941');
INSERT INTO fansub(fansub_id, fansub_name, foundation_year, homepage_url, weibo_url) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'TLF字幕组', '', '', '');
-------------------------------------------------------------------------------------------------------------------------- Subtitles
INSERT INTO subtitle(subtitle_id, subtitle_title, subtitle_url, subtitle_lang, file_format, episode_index, episode_id, uuid, user_id, fansub_id, remark)
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'The.Walking.Dead.S07E10.720p.HDTV.x264-AVS', 'http://ustvseries.oss-cn-shanghai.aliyuncs.com/subtitle/the-walking-dead/s7/e10/dd67c4bda226dbfa329a3cc1cb560a5b.rar', '双语,繁体,简体,英文', 'SRT,ASS', 10, '', '', '447758059f2911e6ace500163e0521c8', 'b222dc7fe21611e6913800163e0521c8', '');
INSERT INTO subtitle(subtitle_id, subtitle_title, subtitle_url, subtitle_lang, file_format, episode_index, episode_id, uuid, user_id, fansub_id, remark)
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'Grimm.S06E03.720p.HDTV.x264-FLEET', 'http://ustvseries.oss-cn-shanghai.aliyuncs.com/subtitle/grimm/s6/e3/11c4c0c4d918750664c7c714e06cca13.zip', '双语,繁体,简体,英文', 'SRT,ASS', 3, '7191269be11e11e6913800163e0521c8', 'df93d96cdc5f11e6ace500163e0521c8', '447758059f2911e6ace500163e0521c8', 'b222dc7fe21611e6913800163e0521c8', '');
INSERT INTO subtitle(subtitle_id, subtitle_title, subtitle_url, subtitle_lang, file_format, episode_index, episode_id, uuid, user_id, fansub_id, remark)
VALUES (LOWER(REPLACE(UUID(), '-', '')), '格林.Grimm.S06E02.REPACK.720p.HDTV.x264-AVS', 'http://ustvseries.oss-cn-shanghai.aliyuncs.com/subtitle/2017-01-20/font-awesome-4.6.3.zip', '双语,简体,英文', 'SRT,ASS', 2, '718ba5e7e11e11e6913800163e0521c8', 'df93d96cdc5f11e6ace500163e0521c8', '447758059f2911e6ace500163e0521c8', 'b222dc7fe21611e6913800163e0521c8', '');
INSERT INTO subtitle(subtitle_id, subtitle_title, subtitle_url, subtitle_lang, file_format, episode_index, episode_id, uuid, user_id, fansub_id, remark)
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'Grimm.S06E02.HDTV.x264-FLEET', 'http://ustvseries.oss-cn-shanghai.aliyuncs.com/subtitle/2017-01-20/font-awesome-4.6.3.zip', '简体,繁体,英文', 'SRT,ASS', 2, '718ba5e7e11e11e6913800163e0521c8', 'df93d96cdc5f11e6ace500163e0521c8', '447758059f2911e6ace500163e0521c8', 'b2282bdde21611e6913800163e0521c8', '');
INSERT INTO subtitle(subtitle_id, subtitle_title, subtitle_url, subtitle_lang, file_format, episode_index, episode_id, uuid, user_id, fansub_id, remark)
VALUES (LOWER(REPLACE(UUID(), '-', '')), '格林.Grimm.S06E01.REPACK.720p.HDTV.x264-AVS', 'http://ustvseries.oss-cn-shanghai.aliyuncs.com/subtitle/2017-01-20/font-awesome-4.6.3.zip', '双语,简体,英文', 'SRT,ASS', 1, '71863c1ee11e11e6913800163e0521c8', 'df93d96cdc5f11e6ace500163e0521c8', '447758059f2911e6ace500163e0521c8', 'b222dc7fe21611e6913800163e0521c8', '');
INSERT INTO subtitle(subtitle_id, subtitle_title, subtitle_url, subtitle_lang, file_format, episode_index, episode_id, uuid, user_id, fansub_id, remark)
VALUES (LOWER(REPLACE(UUID(), '-', '')), 'Grimm.S06E01.HDTV.x264-FLEET', 'http://ustvseries.oss-cn-shanghai.aliyuncs.com/subtitle/2017-01-20/font-awesome-4.6.3.zip', '简体,繁体,英文', 'SRT,ASS', 1, '71863c1ee11e11e6913800163e0521c8', 'df93d96cdc5f11e6ace500163e0521c8', '447758059f2911e6ace500163e0521c8', 'b2282bdde21611e6913800163e0521c8', '');
-------------------------------------------------------------------------------------------------------------------------- Seasons
-- Tyrant
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Tyrant: Season 1', '暴君 第一季', 1, '7550d6d2eea811e6beeb00163e0521c8', '2014-06-24', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Tyrant: Season 2', '暴君 第二季', 2, '7550d6d2eea811e6beeb00163e0521c8', '2015-06-16', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Tyrant: Season 3', '暴君 第三季', 3, '7550d6d2eea811e6beeb00163e0521c8', '2016-07-06', 10);
-- Modern Family
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 1', '摩登家庭 第一季', 1, '8905ad2dc98811e6ace500163e0521c8', '2009-09-23', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 2', '摩登家庭 第二季', 2, '8905ad2dc98811e6ace500163e0521c8', '2010-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 3', '摩登家庭 第三季', 3, '8905ad2dc98811e6ace500163e0521c8', '2011-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 4', '摩登家庭 第四季', 4, '8905ad2dc98811e6ace500163e0521c8', '2012-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 5', '摩登家庭 第五季', 5, '8905ad2dc98811e6ace500163e0521c8', '2013-09-25', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 6', '摩登家庭 第六季', 6, '8905ad2dc98811e6ace500163e0521c8', '2014-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 7', '摩登家庭 第七季', 7, '8905ad2dc98811e6ace500163e0521c8', '2015-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 8', '摩登家庭 第八季', 8, '8905ad2dc98811e6ace500163e0521c8', '2016-09-21', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Modern Family: Season 9', '摩登家庭 第九季', 9, '8905ad2dc98811e6ace500163e0521c8', '2017-09-27', 22);
-- Crisis in Six Scenes
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Crisis in Six Scenes: Season 1', '六场危事 第一季', 1, '06a1a1a2eea611e6beeb00163e0521c8', '2016-09-30', 6);
-- Divorce
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Divorce: Season 1', '离婚 第一季', 1, '41354a76eea411e6beeb00163e0521c8', '2016-10-09', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Divorce: Season 2', '离婚 第二季', 2, '41354a76eea411e6beeb00163e0521c8', '2018-01-14', 8);
-- Eyewitness
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Eyewitness: Season 1', '目击证人 第一季', 1, 'c68eb496eea311e6beeb00163e0521c8', '2016-10-16', 10);
-- Shooter
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shooter: Season 1', '生死狙击 第一季', 1, '58d147adeea111e6beeb00163e0521c8', '2016-11-15', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shooter: Season 2', '生死狙击 第二季', 2, '58d147adeea111e6beeb00163e0521c8', '2017-07-18', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shooter: Season 3', '生死狙击 第三季', 3, '58d147adeea111e6beeb00163e0521c8', '2018-06-21', 13);
-- The OA
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The OA: Season 1', '先见之明 第一季', 1, 'd0334a06ee9f11e6beeb00163e0521c8', '2016-12-16', 8);
-- The Man in the High Castle
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Man in the High Castle: Season 1', '高堡奇人 第一季', 1, 'd0334a06ee9f11e6beeb00163e0521c8', '2016-12-16', 10);
-- Insecure
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Insecure: Season 1', '不安感 第一季', 1, '84b2ebda700811e798eb00163e0521c8', '2016-10-09', 8);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Insecure: Season 2', '不安感 第二季', 2, '84b2ebda700811e798eb00163e0521c8', '2017-07-23', 10);
-- Pose
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Pose: Season 1', '姿态 第一季', 1, '0e2202f23ec311e88c7800163e04e7ff', '2018-06-03', 8);
-- In the Long Run
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'In the Long Run: Season 1', '来日方长 第一季', 1, '8a3cc8604f3a11e88c7800163e04e7ff', '2018-03-29', 6);
-- Elementary
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Elementary: Season 1', '福尔摩斯：基本演绎法 第一季', 1, '50acc5fdc98711e6ace500163e0521c8', '2012-09-27', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Elementary: Season 2', '福尔摩斯：基本演绎法 第二季', 2, '50acc5fdc98711e6ace500163e0521c8', '2013-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Elementary: Season 3', '福尔摩斯：基本演绎法 第三季', 3, '50acc5fdc98711e6ace500163e0521c8', '2014-10-30', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Elementary: Season 4', '福尔摩斯：基本演绎法 第四季', 4, '50acc5fdc98711e6ace500163e0521c8', '2015-11-05', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Elementary: Season 5', '福尔摩斯：基本演绎法 第五季', 5, '50acc5fdc98711e6ace500163e0521c8', '2016-10-02', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Elementary: Season 6', '福尔摩斯：基本演绎法 第六季', 6, '50acc5fdc98711e6ace500163e0521c8', '2018-04-30', 21);
-- 2 Broke Girls
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '2 Broke Girls: Season 1', '破产姐妹 第一季', 1, '50833085c98711e6ace500163e0521c8', '2011-09-19', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '2 Broke Girls: Season 2', '破产姐妹 第二季', 2, '50833085c98711e6ace500163e0521c8', '2012-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '2 Broke Girls: Season 3', '破产姐妹 第三季', 3, '50833085c98711e6ace500163e0521c8', '2013-09-23', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '2 Broke Girls: Season 4', '破产姐妹 第四季', 4, '50833085c98711e6ace500163e0521c8', '2014-10-27', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '2 Broke Girls: Season 5', '破产姐妹 第五季', 5, '50833085c98711e6ace500163e0521c8', '2015-11-12', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '2 Broke Girls: Season 6', '破产姐妹 第六季', 6, '50833085c98711e6ace500163e0521c8', '2016-10-10', 22);
-- Stan Against Evil
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Stan Against Evil: Season 1', '降魔警探 第一季', 1, '70031f49b23711e789a000163e05314b', '2016-10-31', 8);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Stan Against Evil: Season 2', '降魔警探 第二季', 2, '70031f49b23711e789a000163e05314b', '2017-11-01', 8);
-- Good Behavior
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Good Behavior: Season 1', '一善之差 第一季', 1, '1117342feea111e6beeb00163e0521c8', '2016-11-15', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Good Behavior: Season 2', '一善之差 第二季', 2, '1117342feea111e6beeb00163e0521c8', '2017-10-15', 10);
-- Bates Motel
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bates Motel: Season 1', '贝茨旅馆 第一季', 1, '3d2f24a4cb2f11e6ace500163e0521c8', '2013-03-18', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bates Motel: Season 2', '贝茨旅馆 第二季', 2, '3d2f24a4cb2f11e6ace500163e0521c8', '2014-03-03', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bates Motel: Season 3', '贝茨旅馆 第三季', 3, '3d2f24a4cb2f11e6ace500163e0521c8', '2015-03-09', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bates Motel: Season 4', '贝茨旅馆 第四季', 4, '3d2f24a4cb2f11e6ace500163e0521c8', '2016-03-07', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bates Motel: Season 5', '贝茨旅馆 第五季', 5, '3d2f24a4cb2f11e6ace500163e0521c8', '2017-02-20', 10);
-- Fringe
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fringe: Season 1', '危机边缘 第一季', 1, 'b1ee1b60ee6511e6beeb00163e0521c8', '2008-09-23', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fringe: Season 2', '危机边缘 第二季', 2, 'b1ee1b60ee6511e6beeb00163e0521c8', '2009-09-17', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fringe: Season 3', '危机边缘 第三季', 3, 'b1ee1b60ee6511e6beeb00163e0521c8', '2010-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fringe: Season 4', '危机边缘 第四季', 4, 'b1ee1b60ee6511e6beeb00163e0521c8', '2011-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fringe: Season 5', '危机边缘 第五季', 5, 'b1ee1b60ee6511e6beeb00163e0521c8', '2012-09-28', 13);
-- Lost
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost: Season 1', '迷失 第一季', 1, 'd5a0b1a6c98711e6ace500163e0521c8', '2004-09-22', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost: Season 2', '迷失 第二季', 2, 'd5a0b1a6c98711e6ace500163e0521c8', '2005-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost: Season 3', '迷失 第三季', 3, 'd5a0b1a6c98711e6ace500163e0521c8', '2006-10-04', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost: Season 4', '迷失 第四季', 4, 'd5a0b1a6c98711e6ace500163e0521c8', '2008-01-31', 14);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost: Season 5', '迷失 第五季', 5, 'd5a0b1a6c98711e6ace500163e0521c8', '2009-01-21', 17);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost: Season 6', '迷失 第六季', 6, 'd5a0b1a6c98711e6ace500163e0521c8', '2010-02-02', 18);
-- Six
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Six: Season 1', '海豹六队 第一季', 1, '0353498aee0d11e6beeb00163e0521c8', '2017-01-18', 8);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Six: Season 2', '海豹六队 第二季', 2, '0353498aee0d11e6beeb00163e0521c8', '2018-05-30', 10);
-- The Night Of
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Night Of: Season 1', '罪夜之奔 第一季', 1, '2379c5d4ee0211e6beeb00163e0521c8', '2016-07-10', 8);
-- Conviction
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Conviction: Season 1', '定罪 第一季', 1, '609d6d03ee0011e6beeb00163e0521c8', '2016-10-03', 13);
-- Body of Proof
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Body of Proof: Season 1', '逝者之证 第一季', 1, '609d6d03ee0011e6beeb00163e0521c8', '2011-01-25', 9);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Body of Proof: Season 2', '逝者之证 第二季', 2, '609d6d03ee0011e6beeb00163e0521c8', '2011-09-20', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Body of Proof: Season 3', '逝者之证 第三季', 3, '609d6d03ee0011e6beeb00163e0521c8', '2013-02-19', 13);
-- Sanctuary
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sanctuary: Season 1', '异形庇护所 第一季', 1, '303e50d7c8fe11e6ace500163e0521c8', '2008-10-03', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sanctuary: Season 2', '异形庇护所 第二季', 2, '303e50d7c8fe11e6ace500163e0521c8', '2009-10-09', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sanctuary: Season 3', '异形庇护所 第三季', 3, '303e50d7c8fe11e6ace500163e0521c8', '2010-10-15', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sanctuary: Season 4', '异形庇护所 第四季', 4, '303e50d7c8fe11e6ace500163e0521c8', '2011-10-07', 13);
-- 90210
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '90210: Season 1', '新飞越比弗利 第一季', 1, '33c6e384cbd611e6ace500163e0521c8', '2008-09-02', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '90210: Season 2', '新飞越比弗利 第二季', 2, '33c6e384cbd611e6ace500163e0521c8', '2009-09-08', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '90210: Season 3', '新飞越比弗利 第三季', 3, '33c6e384cbd611e6ace500163e0521c8', '2010-09-13', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '90210: Season 4', '新飞越比弗利 第四季', 4, '33c6e384cbd611e6ace500163e0521c8', '2011-09-13', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '90210: Season 5', '新飞越比弗利 第五季', 5, '33c6e384cbd611e6ace500163e0521c8', '2012-10-08', 23);
-- Shameless
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 1', '无耻之徒(美版) 第一季', 1, '215bae15cbf011e6ace500163e0521c8', '2011-01-09', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 2', '无耻之徒(美版) 第二季', 2, '215bae15cbf011e6ace500163e0521c8', '2012-01-08', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 3', '无耻之徒(美版) 第三季', 3, '215bae15cbf011e6ace500163e0521c8', '2013-01-13', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 4', '无耻之徒(美版) 第四季', 4, '215bae15cbf011e6ace500163e0521c8', '2014-01-12', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 5', '无耻之徒(美版) 第五季', 5, '215bae15cbf011e6ace500163e0521c8', '2015-01-11', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 6', '无耻之徒(美版) 第六季', 6, '215bae15cbf011e6ace500163e0521c8', '2016-01-10', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 7', '无耻之徒(美版) 第七季', 7, '215bae15cbf011e6ace500163e0521c8', '2016-10-02', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 8', '无耻之徒(美版) 第八季', 8, '215bae15cbf011e6ace500163e0521c8', '2017-11-05', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Shameless: Season 9', '无耻之徒(美版) 第九季', 9, '215bae15cbf011e6ace500163e0521c8', '2018-09-09', 14);
-- Daredevil
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Daredevil: Season 1', '夜魔侠 第一季', 1, '1ce7d3b8812a11e6b5f2a0d3c1483ed9', '2015-04-10', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Daredevil: Season 2', '夜魔侠 第二季', 2, '1ce7d3b8812a11e6b5f2a0d3c1483ed9', '2016-03-18', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Daredevil: Season 3', '夜魔侠 第三季', 3, '1ce7d3b8812a11e6b5f2a0d3c1483ed9', '2018-10-19', 13);
-- Lost Girl
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost Girl: Season 1', '妖女迷行 第一季', 1, '864227dfcb7f11e6ace500163e0521c8', '2010-09-12', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost Girl: Season 2', '妖女迷行 第二季', 2, '864227dfcb7f11e6ace500163e0521c8', '2011-09-04', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost Girl: Season 3', '妖女迷行 第三季', 3, '864227dfcb7f11e6ace500163e0521c8', '2013-01-06', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost Girl: Season 4', '妖女迷行 第四季', 4, '864227dfcb7f11e6ace500163e0521c8', '2013-11-10', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lost Girl: Season 5', '妖女迷行 第五季', 5, '864227dfcb7f11e6ace500163e0521c8', '2014-12-07', 16);
-- Sleepy Hollow
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sleepy Hollow: Season 1', '沉睡谷 第一季', 1, 'ac461bc3cb8011e6ace500163e0521c8', '2013-09-16', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sleepy Hollow: Season 2', '沉睡谷 第二季', 2, 'ac461bc3cb8011e6ace500163e0521c8', '2014-09-22', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sleepy Hollow: Season 3', '沉睡谷 第三季', 3, 'ac461bc3cb8011e6ace500163e0521c8', '2015-10-01', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sleepy Hollow: Season 4', '沉睡谷 第四季', 4, 'ac461bc3cb8011e6ace500163e0521c8', '2017-01-06', 13);
-- Colony
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Colony: Season 1', '殖民地 第一季', 1, '748b0a5fea9f11e68b8500163e0521c8', '2016-01-14', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Colony: Season 2', '殖民地 第二季', 2, '748b0a5fea9f11e68b8500163e0521c8', '2017-01-12', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Colony: Season 3', '殖民地 第三季', 3, '748b0a5fea9f11e68b8500163e0521c8', '2018-05-03', 12);
-- The Great Indoors
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Great Indoors: Season 1', '室内奇兵 第一季', 1, 'dca0356de2a611e6913800163e0521c8', '2016-10-27', 6);
-- Pure Genius
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Pure Genius: Season 1', '天才医院 第一季', 1, '6ee9e59be2a611e6913800163e0521c8', '2016-10-27', 13);
-- Blue Bloods
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 1', '警察世家 第一季', 1, 'c23f6f14e2a411e6913800163e0521c8', '2010-09-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 2', '警察世家 第二季', 2, 'c23f6f14e2a411e6913800163e0521c8', '2011-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 3', '警察世家 第三季', 3, 'c23f6f14e2a411e6913800163e0521c8', '2012-09-28', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 4', '警察世家 第四季', 4, 'c23f6f14e2a411e6913800163e0521c8', '2013-09-27', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 5', '警察世家 第五季', 5, 'c23f6f14e2a411e6913800163e0521c8', '2014-09-26', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 6', '警察世家 第六季', 6, 'c23f6f14e2a411e6913800163e0521c8', '2015-09-25', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 7', '警察世家 第七季', 7, 'c23f6f14e2a411e6913800163e0521c8', '2016-09-23', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Blue Bloods: Season 8', '警察世家 第八季', 8, 'c23f6f14e2a411e6913800163e0521c8', '2017-09-29', 20);
-- How to Get Away with Murder
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How to Get Away with Murder: Season 1', '逍遥法外 第一季', 1, '16f68982e2a411e6913800163e0521c8', '2014-09-25', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How to Get Away with Murder: Season 2', '逍遥法外 第二季', 2, '16f68982e2a411e6913800163e0521c8', '2015-09-24', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How to Get Away with Murder: Season 3', '逍遥法外 第三季', 3, '16f68982e2a411e6913800163e0521c8', '2016-09-22', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How to Get Away with Murder: Season 4', '逍遥法外 第四季', 4, '16f68982e2a411e6913800163e0521c8', '2017-09-28', 15);
-- Nashville
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nashville: Season 1', '音乐之乡 第一季', 1, '677cf8d2e2a311e6913800163e0521c8', '2012-10-10', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nashville: Season 2', '音乐之乡 第二季', 2, '677cf8d2e2a311e6913800163e0521c8', '2013-09-25', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nashville: Season 3', '音乐之乡 第三季', 3, '677cf8d2e2a311e6913800163e0521c8', '2014-09-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nashville: Season 4', '音乐之乡 第四季', 4, '677cf8d2e2a311e6913800163e0521c8', '2015-09-23', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nashville: Season 5', '音乐之乡 第五季', 5, '677cf8d2e2a311e6913800163e0521c8', '2016-12-15', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nashville: Season 6', '音乐之乡 第六季', 6, '677cf8d2e2a311e6913800163e0521c8', '2018-01-04', 22);
-- The Affair
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Affair: Season 1', '婚外情事 第一季', 1, '38905a21e2a211e6913800163e0521c8', '2014-10-12', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Affair: Season 2', '婚外情事 第二季', 2, '38905a21e2a211e6913800163e0521c8', '2015-10-04', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Affair: Season 3', '婚外情事 第三季', 3, '38905a21e2a211e6913800163e0521c8', '2016-11-20', 10);
-- Man with a Plan
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Man with a Plan: Season 1', '老爸有招 第一季', 1, '50bdfa7bc98711e6ace500163e0521c8', '2016-10-24', 19);
-- 集数未知
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Man with a Plan: Season 2', '老爸有招 第二季', 2, '50bdfa7bc98711e6ace500163e0521c8', '2017-11-13', 19);
-- Dr. Ken
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dr. Ken: Season 1', '肯恩医生 第一季', 1, '87522534e0a611e6913800163e0521c8', '2015-10-02', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dr. Ken: Season 2', '肯恩医生 第二季', 2, '87522534e0a611e6913800163e0521c8', '2016-09-23', 22);
-- Major Crimes
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Major Crimes: Season 1', '重案组 第一季', 1, 'a68f0dfee05111e6913800163e0521c8', '2012-08-13', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Major Crimes: Season 2', '重案组 第二季', 2, 'a68f0dfee05111e6913800163e0521c8', '2013-06-10', 19);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Major Crimes: Season 3', '重案组 第三季', 3, 'a68f0dfee05111e6913800163e0521c8', '2014-06-09', 19);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Major Crimes: Season 4', '重案组 第四季', 4, 'a68f0dfee05111e6913800163e0521c8', '2015-06-08', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Major Crimes: Season 5', '重案组 第五季', 5, 'a68f0dfee05111e6913800163e0521c8', '2016-06-13', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Major Crimes: Season 6', '重案组 第六季', 6, 'a68f0dfee05111e6913800163e0521c8', '2017-10-31', 13);
-- This Is Us
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'This Is Us: Season 1', '我们这一天 第一季', 1, '586914B4E04D11E6913800163E0521C8', '2016-09-20', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'This Is Us: Season 2', '我们这一天 第二季', 2, '586914b4e04d11e6913800163e0521c8', '2017-09-26', 18);
-- West World
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Westworld: Season 1', '西部世界 第一季', 1, '3ee7fdd88d0711e6a2eca0d3c1483ed9', '2016-10-02', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Westworld: Season 2', '西部世界 第二季', 2, '3ee7fdd88d0711e6a2eca0d3c1483ed9', '2018-04-22', 10);
-- Once Upon a Time
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 1', '童话镇 第一季', '8911251ec98811e6ace500163e0521c8', '2011-10-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 2', '童话镇 第二季', '8911251ec98811e6ace500163e0521c8', '2012-09-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 3', '童话镇 第三季', '8911251ec98811e6ace500163e0521c8', '2013-09-29', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 4', '童话镇 第四季', '8911251ec98811e6ace500163e0521c8', '2014-09-28', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 5', '童话镇 第五季', '8911251ec98811e6ace500163e0521c8', '2015-09-27', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 6', '童话镇 第六季', '8911251ec98811e6ace500163e0521c8', '2016-09-25', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 7', '童话镇 第七季', 7, '8911251ec98811e6ace500163e0521c8', '2017-10-06', 22);
-- 集数未知
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Once Upon a Time: Season 7', '童话镇 第七季', '8911251ec98811e6ace500163e0521c8', '2017-10-06', 22);
-- Masters of Sex
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Masters of Sex: Season 1', '性爱大师 第一季', 1, '2c2bf26aeea711e6beeb00163e0521c8', '2013-09-17', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Masters of Sex: Season 2', '性爱大师 第二季', 2, '2c2bf26aeea711e6beeb00163e0521c8', '2014-07-13', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Masters of Sex: Season 3', '性爱大师 第三季', 3, '2c2bf26aeea711e6beeb00163e0521c8', '2015-07-12', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Masters of Sex: Season 4', '性爱大师 第四季', 4, '2c2bf26aeea711e6beeb00163e0521c8', '2016-09-11', 10);
-- The Good Place
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Place: Season 1', '善地 第一季', 1, 'b78e59c870d611e798eb00163e0521c8', '2016-09-19', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Place: Season 2', '善地 第二季', 2, 'b78e59c870d611e798eb00163e0521c8', '2017-09-20', 13);
-- Supernatural
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 1', '邪恶力量 第一季', '18B5B976C92F11E6ACE500163E0521C8', '2005-09-13', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 2', '邪恶力量 第二季', '18B5B976C92F11E6ACE500163E0521C8', '2006-09-28', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 3', '邪恶力量 第三季', '18B5B976C92F11E6ACE500163E0521C8', '2007-10-04', 16);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 4', '邪恶力量 第四季', '18B5B976C92F11E6ACE500163E0521C8', '2008-10-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 5', '邪恶力量 第五季', '18B5B976C92F11E6ACE500163E0521C8', '2009-09-10', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 6', '邪恶力量 第六季', '18B5B976C92F11E6ACE500163E0521C8', '2010-09-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 7', '邪恶力量 第七季', '18B5B976C92F11E6ACE500163E0521C8', '2011-09-23', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 8', '邪恶力量 第八季', '18B5B976C92F11E6ACE500163E0521C8', '2012-10-03', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 9', '邪恶力量 第九季', '18B5B976C92F11E6ACE500163E0521C8', '2013-10-08', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 10', '邪恶力量 第十季', '18B5B976C92F11E6ACE500163E0521C8', '2014-10-07', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 11', '邪恶力量 第十一季', '18B5B976C92F11E6ACE500163E0521C8', '2015-10-07', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 12', '邪恶力量 第十二季', '18B5B976C92F11E6ACE500163E0521C8', '2016-10-13', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 13', '邪恶力量 第十三季', 13, '18b5b976c92f11e6ace500163e0521c8', '2017-10-12', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Supernatural: Season 14', '邪恶力量 第十四季', 14, '18b5b976c92f11e6ace500163e0521c8', '2018-10-11', 20);
-- Yellowstone
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Yellowstone: Season 1', '黄石公园 第一季', 1, '338ae032782911e88c7800163e04e7ff', '2018-06-20', 10);
-- Hawaii Five-0
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 1', '夏威夷特勤组 第一季', 1, 'c943ad1de2a511e6913800163e0521c8', '2010-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 2', '夏威夷特勤组 第二季', 2, 'c943ad1de2a511e6913800163e0521c8', '2011-09-19', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 3', '夏威夷特勤组 第三季', 3, 'c943ad1de2a511e6913800163e0521c8', '2012-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 4', '夏威夷特勤组 第四季', 4, 'c943ad1de2a511e6913800163e0521c8', '2013-09-27', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 5', '夏威夷特勤组 第五季', 5, 'c943ad1de2a511e6913800163e0521c8', '2014-09-26', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 6', '夏威夷特勤组 第六季', 6, 'c943ad1de2a511e6913800163e0521c8', '2015-09-25', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 7', '夏威夷特勤组 第七季', 7, 'c943ad1de2a511e6913800163e0521c8', '2016-09-23', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hawaii Five-0: Season 8', '夏威夷特勤组 第八季', 8, 'c943ad1de2a511e6913800163e0521c8', '2017-09-29', 25);
-- Mom
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Mom: Season 1', '极品老妈 第一季', 1, 'a82259afeea111e6beeb00163e0521c8', '2013-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Mom: Season 2', '极品老妈 第二季', 2, 'a82259afeea111e6beeb00163e0521c8', '2014-10-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Mom: Season 3', '极品老妈 第三季', 3, 'a82259afeea111e6beeb00163e0521c8', '2015-11-05', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Mom: Season 4', '极品老妈 第四季', 4, 'a82259afeea111e6beeb00163e0521c8', '2016-10-27', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Mom: Season 5', '极品老妈 第五季', 5, 'a82259afeea111e6beeb00163e0521c8', '2017-11-02', 15);
-- The Vampire Diaries
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 1', '吸血鬼日记 第一季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2009-09-10', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 2', '吸血鬼日记 第二季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2010-09-09', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 3', '吸血鬼日记 第三季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2011-09-15', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 4', '吸血鬼日记 第四季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2012-10-11', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 5', '吸血鬼日记 第五季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2013-10-03', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 6', '吸血鬼日记 第六季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2014-10-02', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 7', '吸血鬼日记 第七季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2015-10-08', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Vampire Diaries: Season 8', '吸血鬼日记 第八季', '12D27F368D0611E6A2ECA0D3C1483ED9', '2016-10-21', 16);
-- Arrow
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Arrow: Season 1', '绿箭侠 第一季', '12BC80978D0611E6A2ECA0D3C1483ED9', '2012-10-09', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Arrow: Season 2', '绿箭侠 第二季', '12BC80978D0611E6A2ECA0D3C1483ED9', '2013-10-09', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Arrow: Season 3', '绿箭侠 第三季', '12BC80978D0611E6A2ECA0D3C1483ED9', '2014-10-08', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Arrow: Season 4', '绿箭侠 第四季', '12BC80978D0611E6A2ECA0D3C1483ED9', '2015-10-07', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Arrow: Season 5', '绿箭侠 第五季', '12BC80978D0611E6A2ECA0D3C1483ED9', '2016-10-05', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Arrow: Season 6', '绿箭侠 第六季', 6, '12bc80978d0611e6a2eca0d3c1483ed9', '2017-10-12', 23);
-- Heroes
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Heroes: Season 1', '英雄 第一季', '045149B1CB8111E6ACE500163E0521C8', '2006-07-22', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Heroes: Season 2', '英雄 第二季', '045149B1CB8111E6ACE500163E0521C8', '2007-09-24', 11);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Heroes: Season 3', '英雄 第三季', '045149B1CB8111E6ACE500163E0521C8', '2008-09-22', 25);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Heroes: Season 4', '英雄 第四季', '045149B1CB8111E6ACE500163E0521C8', '2009-09-21', 19);
-- Chance
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chance: Season 1', '钱斯医生 第一季', 1, '4f6f6563eea311e6beeb00163e0521c8', '2016-10-19', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chance: Season 2', '钱斯医生 第二季', 2, '4f6f6563eea311e6beeb00163e0521c8', '2017-10-11', 10);
-- Lucifer
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lucifer: Season 1', '路西法 第一季', 1, 'c45b3739e29c11e6913800163e0521c8', '2016-01-25', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lucifer: Season 2', '路西法 第二季', 2, 'c45b3739e29c11e6913800163e0521c8', '2016-09-19', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lucifer: Season 3', '路西法 第三季', 3, 'c45b3739e29c11e6913800163e0521c8', '2017-10-02', 22);
-- Santa Clarita Diet
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Santa Clarita Diet: Season 1', '返生餐单 第一季', 1, 'c4e39c0cea9e11e68b8500163e0521c8', '2017-02-03', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Santa Clarita Diet: Season 2', '返生餐单 第二季', 2, 'c4e39c0cea9e11e68b8500163e0521c8', '2018-03-23', 10);
-- Criminal Minds
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 1', '犯罪心理 第一季', '24AAF9617F3E11E69977A0D3C1483ED9', '2005-09-22', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 2', '犯罪心理 第二季', '24AAF9617F3E11E69977A0D3C1483ED9', '2006-09-20', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 3', '犯罪心理 第三季', '24AAF9617F3E11E69977A0D3C1483ED9', '2007-09-26', 20);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 4', '犯罪心理 第四季', '24AAF9617F3E11E69977A0D3C1483ED9', '2008-09-24', 26);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 5', '犯罪心理 第五季', '24AAF9617F3E11E69977A0D3C1483ED9', '2009-09-23', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 6', '犯罪心理 第六季', '24AAF9617F3E11E69977A0D3C1483ED9', '2010-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 7', '犯罪心理 第七季', '24AAF9617F3E11E69977A0D3C1483ED9', '2011-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 8', '犯罪心理 第八季', '24AAF9617F3E11E69977A0D3C1483ED9', '2012-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 9', '犯罪心理 第九季', '24AAF9617F3E11E69977A0D3C1483ED9', '2013-09-25', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 10', '犯罪心理 第十季', '24AAF9617F3E11E69977A0D3C1483ED9', '2014-10-01', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 11', '犯罪心理 第十一季', '24AAF9617F3E11E69977A0D3C1483ED9', '2015-09-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 12', '犯罪心理 第十二季', '24AAF9617F3E11E69977A0D3C1483ED9', '2016-09-28', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 13', '犯罪心理 第十三季', 13, '24aaf9617f3e11e69977a0d3c1483ed9', '2017-09-27', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Season 14', '犯罪心理 第十四季', 14, '24aaf9617f3e11e69977a0d3c1483ed9', '2018-09-26', 15);
-- Criminal Minds: Beyond Borders
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Criminal Minds: Beyond Borders: Season 2', '犯罪心理：穿越国界 第二季', 2, '509e4ff1c98711e6ace500163e0521c8', '2017-03-08', 13);
-- The Exorcist
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Exorcist: Season 1', '驱魔人 第一季', 1, '55b9a588ee9f11e6beeb00163e0521c8', '2016-09-23', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Exorcist: Season 2', '驱魔人 第二季', 2, '55b9a588ee9f11e6beeb00163e0521c8', '2017-09-29', 10);
-- The Big Bang Theory
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 1', '生活大爆炸 第一季', '249E422B7F3E11E69977A0D3C1483ED9', '2007-09-24', 17);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 2', '生活大爆炸 第二季', '249E422B7F3E11E69977A0D3C1483ED9', '2008-09-22', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 3', '生活大爆炸 第三季', '249E422B7F3E11E69977A0D3C1483ED9', '2009-09-21', 23);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 4', '生活大爆炸 第四季', '249E422B7F3E11E69977A0D3C1483ED9', '2010-09-23', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 5', '生活大爆炸 第五季', '249E422B7F3E11E69977A0D3C1483ED9', '2011-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 6', '生活大爆炸 第六季', '249E422B7F3E11E69977A0D3C1483ED9', '2012-09-27', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 7', '生活大爆炸 第七季', '249E422B7F3E11E69977A0D3C1483ED9', '2013-09-27', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 8', '生活大爆炸 第八季', '249E422B7F3E11E69977A0D3C1483ED9', '2014-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 9', '生活大爆炸 第九季', '249E422B7F3E11E69977A0D3C1483ED9', '2015-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 10', '生活大爆炸 第十季', '249E422B7F3E11E69977A0D3C1483ED9', '2016-09-19', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Big Bang Theory: Season 11', '生活大爆炸 第十一季', 11, '249e422b7f3e11e69977a0d3c1483ed9', '2017-09-25', 24);
-- The Walking Dead
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 1', '行尸走肉 第一季', '715190788D0511E6A2ECA0D3C1483ED9', '2010-10-31', 6);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 2', '行尸走肉 第二季', '715190788D0511E6A2ECA0D3C1483ED9', '2011-10-16', 13);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 3', '行尸走肉 第三季', '715190788D0511E6A2ECA0D3C1483ED9', '2012-10-14', 16);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 4', '行尸走肉 第四季', '715190788D0511E6A2ECA0D3C1483ED9', '2013-10-13', 16);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 5', '行尸走肉 第五季', '715190788D0511E6A2ECA0D3C1483ED9', '2014-10-12', 16);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 6', '行尸走肉 第六季', '715190788D0511E6A2ECA0D3C1483ED9', '2015-10-12', 16);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 7', '行尸走肉 第七季', '715190788D0511E6A2ECA0D3C1483ED9', '2016-10-23', 16);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Walking Dead: Season 8', '行尸走肉 第八季', '715190788d0511e6a2eca0d3c1483ed9', '2017-10-21', 16);
-- Person of Interest
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Person Of Interest: Season 1', '疑犯追踪 第一季', 1, 'ce21c5557f3c11e69977a0d3c1483ed9', '2011-09-22', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Person Of Interest: Season 2', '疑犯追踪 第二季', 2, 'ce21c5557f3c11e69977a0d3c1483ed9', '2012-09-27', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Person Of Interest: Season 3', '疑犯追踪 第三季', 3, 'ce21c5557f3c11e69977a0d3c1483ed9', '2013-09-24', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Person Of Interest: Season 4', '疑犯追踪 第四季', 4, 'ce21c5557f3c11e69977a0d3c1483ed9', '2014-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Person Of Interest: Season 5', '疑犯追踪 第五季', 5, 'ce21c5557f3c11e69977a0d3c1483ed9', '2016-05-03', 13);
-- Narcos
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Narcos: Season 1', '毒枭 第一季', 1, '797dc8b07d7f11e69cf6a0d3c1483ed9', '2015-08-28', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Narcos: Season 2', '毒枭 第二季', 2, '797dc8b07d7f11e69cf6a0d3c1483ed9', '2016-09-02', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Narcos: Season 3', '毒枭 第三季', 3, '797dc8b07d7f11e69cf6a0d3c1483ed9', '2017-09-01', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Cult', '美国恐怖故事：邪教 第七季', '0046d0b87ed811e69977a0d3c1483ed9', '2017-09-05', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Roanoke', '美国恐怖故事：罗亚诺克 第六季', '0046D0B87ED811E69977A0D3C1483ED9', '2016-09-14', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Hotel', '美国恐怖故事：旅馆 第五季', '0046D0B87ED811E69977A0D3C1483ED9', '2015-10-07', 12);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Murder House', '美国恐怖故事：谋杀屋 第一季', '0046D0B87ED811E69977A0D3C1483ED9', '2011-10-05', 12);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Asylum', '美国恐怖故事：精神病院 第二季', '0046D0B87ED811E69977A0D3C1483ED9', '2012-10-17', 13);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Coven', '美国恐怖故事：女巫集会 第三季', '0046D0B87ED811E69977A0D3C1483ED9', '2013-10-09', 13);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'American Horror Story: Freak Show', '美国恐怖故事：畸形秀 第四季', '0046D0B87ED811E69977A0D3C1483ED9', '2014-10-08', 13);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Stranger Things: Season 1', '怪奇物语 第一季', '1CE0038C812A11E6B5F2A0D3C1483ED9', '2016-07-15', 8);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Stranger Things: Season 2', '怪奇物语 第二季', '1CE0038C812A11E6B5F2A0D3C1483ED9', '2017-07-15', 9);
-- Game of Thrones
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 1', '权力的游戏 第一季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2011-04-17', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 2', '权力的游戏 第二季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2012-04-01', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 3', '权力的游戏 第三季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2013-03-31', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 4', '权力的游戏 第四季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2014-04-06', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 5', '权力的游戏 第五季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2015-04-12', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 6', '权力的游戏 第六季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2016-04-24', 10);
INSERT INTO season(uuid, english_name, chinese_name, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Game of Thrones: Season 7', '权力的游戏 第七季', '3ef3f8298d0711e6a2eca0d3c1483ed9', '2017-07-16', 7);
-- Bones
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 1', '识骨寻踪 第一季', 1, '03248B70CBF111E6ACE500163E0521C8', '2005-09-13', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 2', '识骨寻踪 第二季', 2, '03248B70CBF111E6ACE500163E0521C8', '2006-08-30', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 3', '识骨寻踪 第三季', 3, '03248B70CBF111E6ACE500163E0521C8', '2007-09-25', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 4', '识骨寻踪 第四季', 4, '03248B70CBF111E6ACE500163E0521C8', '2008-09-03', 26);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 5', '识骨寻踪 第五季', 5, '03248B70CBF111E6ACE500163E0521C8', '2009-09-17', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 6', '识骨寻踪 第六季', 6, '03248B70CBF111E6ACE500163E0521C8', '2010-09-23', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 7', '识骨寻踪 第七季', 7, '03248B70CBF111E6ACE500163E0521C8', '2011-11-03', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 8', '识骨寻踪 第八季', 8, '03248B70CBF111E6ACE500163E0521C8', '2012-09-17', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 9', '识骨寻踪 第九季', 9, '03248B70CBF111E6ACE500163E0521C8', '2013-09-16', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 10', '识骨寻踪 第十季', 10, '03248B70CBF111E6ACE500163E0521C8', '2014-09-25', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 11', '识骨寻踪 第十一季', 11, '03248B70CBF111E6ACE500163E0521C8', '2015-10-01', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Bones: Season 12', '识骨寻踪 第十二季', 12, '03248B70CBF111E6ACE500163E0521C8', '2017-01-04', 12);
-- Gossip Girl
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gossip Girl: Season 1', '绯闻女孩 第一季', 1, '0617F4ECC8FF11E6ACE500163E0521C8', '2007-09-19', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gossip Girl: Season 2', '绯闻女孩 第二季', 2, '0617F4ECC8FF11E6ACE500163E0521C8', '2008-09-01', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gossip Girl: Season 3', '绯闻女孩 第三季', 3, '0617F4ECC8FF11E6ACE500163E0521C8', '2009-09-14', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gossip Girl: Season 4', '绯闻女孩 第四季', 4, '0617F4ECC8FF11E6ACE500163E0521C8', '2010-09-13', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gossip Girl: Season 5', '绯闻女孩 第五季', 5, '0617F4ECC8FF11E6ACE500163E0521C8', '2011-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gossip Girl: Season 6', '绯闻女孩 第六季', 6, '0617F4ECC8FF11E6ACE500163E0521C8', '2012-10-08', 10);
-- Lethal Weapon
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lethal Weapon: Season 1', '致命武器 第一季', 1, '664037d0ec3011e68b8500163e0521c8', '2016-09-21', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Lethal Weapon: Season 2', '致命武器 第二季', 2, '664037d0ec3011e68b8500163e0521c8', '2017-09-26', 22);
-- Imposters
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Imposters: Season 1', '假面真情 第一季', 1, '7cd04a89ee6311e6beeb00163e0521c8', '2017-02-07', 9);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Imposters: Season 2', '假面真情 第二季', 2, '7cd04a89ee6311e6beeb00163e0521c8', '2018-04-05', 10);
-- Cloak & Dagger
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Cloak & Dagger: Season 1', '斗篷与匕首 第一季', 1, '405f8efa6c8b11e88c7800163e04e7ff', '2018-06-07', 10);
-- A Series of Unfortunate Event
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'A Series of Unfortunate Event: Season 1', '雷蒙·斯尼奇的不幸历险 第一季', 1, '0c9b1adbdbf911e6ace500163e0521c8', '2017-01-13', 8);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'A Series of Unfortunate Event: Season 2', '雷蒙·斯尼奇的不幸历险 第二季', 2, '0c9b1adbdbf911e6ace500163e0521c8', '2018-03-31', 8);
-- Queer Eye
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Queer Eye: Season 1', '粉雄救兵 第一季', 1, 'dcbf526c654b11e88c7800163e04e7ff', '2018-02-07', 8);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Queer Eye: Season 2', '粉雄救兵 第二季', 2, 'dcbf526c654b11e88c7800163e04e7ff', '2018-06-15', 8);
-- Luke Cage
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Luke Cage: Season 1', '卢克·凯奇 第一季', 1, 'cd5f33cacc1511e6ace500163e0521c8', '2016-09-30', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Luke Cage: Season 2', '卢克·凯奇 第二季', 2, 'cd5f33cacc1511e6ace500163e0521c8', '2018-06-22', 13);
-- Agents of S.H.I.E.L.D.
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Agents of S.H.I.E.L.D.: Season 1', '神盾局特工 第一季', 1, '891cbb3dc98811e6ace500163e0521c8', '2013-09-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Agents of S.H.I.E.L.D.: Season 2', '神盾局特工 第二季', 2, '891cbb3dc98811e6ace500163e0521c8', '2014-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Agents of S.H.I.E.L.D.: Season 3', '神盾局特工 第三季', 3, '891cbb3dc98811e6ace500163e0521c8', '2015-09-29', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Agents of S.H.I.E.L.D.: Season 4', '神盾局特工 第四季', 4, '891cbb3dc98811e6ace500163e0521c8', '2016-09-20', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Agents of S.H.I.E.L.D.: Season 5', '神盾局特工 第五季', 5, '891cbb3dc98811e6ace500163e0521c8', '2017-12-01', 22);
-- Dexter
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 1', '嗜血法医 第一季', 1, '09D2A0FECB8011E6ACE500163E0521C8', '2006-10-01', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 2', '嗜血法医 第二季', 2, '09D2A0FECB8011E6ACE500163E0521C8', '2007-09-30', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 3', '嗜血法医 第三季', 3, '09D2A0FECB8011E6ACE500163E0521C8', '2008-08-21', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 4', '嗜血法医 第四季', 4, '09D2A0FECB8011E6ACE500163E0521C8', '2009-09-27', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 5', '嗜血法医 第五季', 5, '09D2A0FECB8011E6ACE500163E0521C8', '2010-09-27', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 6', '嗜血法医 第六季', 6, '09D2A0FECB8011E6ACE500163E0521C8', '2011-10-02', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 7', '嗜血法医 第七季', 7, '09D2A0FECB8011E6ACE500163E0521C8', '2012-09-30', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Dexter: Season 8', '嗜血法医 第八季', 8, '09D2A0FECB8011E6ACE500163E0521C8', '2013-06-30', 12);
-- Helix
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Helix: Season 1', '双螺旋 第一季', 1, '0E19E3C2CBD611E6ACE500163E0521C8', '2014-01-11', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Helix: Season 2', '双螺旋 第二季', 2, '0E19E3C2CBD611E6ACE500163E0521C8', '2015-01-16', 13);
-- The Strain
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Strain: Season 1', '血族 第一季', 1, 'E3F9EF8ECBD511E6ACE500163E0521C8', '2014-07-13', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Strain: Season 2', '血族 第二季', 2, 'E3F9EF8ECBD511E6ACE500163E0521C8', '2015-07-12', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Strain: Season 3', '血族 第三季', 3, 'E3F9EF8ECBD511E6ACE500163E0521C8', '2016-08-28', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Strain: Season 4', '血族 第四季', 4, 'e3f9ef8ecbd511e6ace500163e0521c8', '2017-07-16', 10);
-- The Flash
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Flash: Season 1', '闪电侠 第一季', 1, '12B112EF8D0611E6A2ECA0D3C1483ED9', '2014-10-07', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Flash: Season 2', '闪电侠 第二季', 2, '12B112EF8D0611E6A2ECA0D3C1483ED9', '2015-10-06', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Flash: Season 3', '闪电侠 第三季', 3, '12B112EF8D0611E6A2ECA0D3C1483ED9', '2016-10-04', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Flash: Season 4', '闪电侠 第四季', 4, '12b112ef8d0611e6a2eca0d3c1483ed9', '2017-10-10', 23);
-- Quantico
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Quantico: Season 1', '谍网 第一季', 1, '0d87fb68e29e11e6913800163e0521c8', '2015-09-27', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Quantico: Season 2', '谍网 第二季', 2, '0d87fb68e29e11e6913800163e0521c8', '2016-09-25', 22);
-- Gotham
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gotham: Season 1', '哥谭 第一季', 1, '19F4B045CB8211E6ACE500163E0521C8', '2014-09-22', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gotham: Season 2', '哥谭 第二季', 2, '19F4B045CB8211E6ACE500163E0521C8', '2015-09-21', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gotham: Season 3', '哥谭 第三季', 3, '19F4B045CB8211E6ACE500163E0521C8', '2016-09-19', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gotham: Season 4', '哥谭 第四季', 4, '19f4b045cb8211e6ace500163e0521c8', '2017-09-28', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Gotham: Season 5', '哥谭 第五季', 5, '19f4b045cb8211e6ace500163e0521c8', '2019-01-03', 12);
-- Vikings
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Vikings: Season 1', '维京传奇 第一季', 1, 'cb174a05c92e11e6ace500163e0521c8', '2013-03-03', 9);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Vikings: Season 2', '维京传奇 第二季', 2, 'cb174a05c92e11e6ace500163e0521c8', '2014-02-27', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Vikings: Season 3', '维京传奇 第三季', 3, 'cb174a05c92e11e6ace500163e0521c8', '2015-02-19', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Vikings: Season 4', '维京传奇 第四季', 4, 'cb174a05c92e11e6ace500163e0521c8', '2016-02-18', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Vikings: Season 5', '维京传奇 第五季', 5, 'cb174a05c92e11e6ace500163e0521c8', '2017-11-29', 20);
-- Grimm
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grimm: Season 1', '格林 第一季', 1, 'EB00221E8D0711E6A2ECA0D3C1483ED9', '2011-10-28', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grimm: Season 2', '格林 第二季', 2, 'EB00221E8D0711E6A2ECA0D3C1483ED9', '2012-08-14', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grimm: Season 3', '格林 第三季', 3, 'EB00221E8D0711E6A2ECA0D3C1483ED9', '2013-10-25', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grimm: Season 4', '格林 第四季', 4, 'EB00221E8D0711E6A2ECA0D3C1483ED9', '2014-10-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grimm: Season 5', '格林 第五季', 5, 'EB00221E8D0711E6A2ECA0D3C1483ED9', '2015-10-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grimm: Season 6', '格林 第六季', 6, 'EB00221E8D0711E6A2ECA0D3C1483ED9', '2017-01-06', 13);
-- Broadwalk Empire
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Broadwalk Empire: Season 1', '大西洋帝国 第一季', 1, '68d740d4c98e11e6ace500163e0521c8', '2010-09-19', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Broadwalk Empire: Season 2', '大西洋帝国 第二季', 2, '68d740d4c98e11e6ace500163e0521c8', '2011-09-25', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Broadwalk Empire: Season 3', '大西洋帝国 第三季', 3, '68d740d4c98e11e6ace500163e0521c8', '2012-09-16', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Broadwalk Empire: Season 4', '大西洋帝国 第四季', 4, '68d740d4c98e11e6ace500163e0521c8', '2013-09-08', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Broadwalk Empire: Season 5', '大西洋帝国 第五季', 5, '68d740d4c98e11e6ace500163e0521c8', '2014-09-07', 8);
-- Grey's Anthony
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 1', '实习医生格蕾 第一季', 1, 'd5aeaf63c98711e6ace500163e0521c8', '2005-03-27', 9);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 2', '实习医生格蕾 第二季', 2, 'd5aeaf63c98711e6ace500163e0521c8', '2005-09-25', 27);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 3', '实习医生格蕾 第三季', 3, 'd5aeaf63c98711e6ace500163e0521c8', '2006-09-21', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 4', '实习医生格蕾 第四季', 4, 'd5aeaf63c98711e6ace500163e0521c8', '2007-09-27', 17);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 5', '实习医生格蕾 第五季', 5, 'd5aeaf63c98711e6ace500163e0521c8', '2008-09-25', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 6', '实习医生格蕾 第六季', 6, 'd5aeaf63c98711e6ace500163e0521c8', '2009-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 7', '实习医生格蕾 第七季', 7, 'd5aeaf63c98711e6ace500163e0521c8', '2010-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 8', '实习医生格蕾 第八季', 8, 'd5aeaf63c98711e6ace500163e0521c8', '2011-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 9', '实习医生格蕾 第九季', 9, 'd5aeaf63c98711e6ace500163e0521c8', '2012-09-27', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 10', '实习医生格蕾 第十季', 10, 'd5aeaf63c98711e6ace500163e0521c8', '2013-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 11', '实习医生格蕾 第十一季', 11, 'd5aeaf63c98711e6ace500163e0521c8', '2014-09-25', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 12', '实习医生格蕾 第十二季', 12, 'd5aeaf63c98711e6ace500163e0521c8', '2015-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 13', '实习医生格蕾 第十三季', 13, 'd5aeaf63c98711e6ace500163e0521c8', '2016-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Grey\'s Anthony: Season 14', '实习医生格蕾 第十四季', 14, 'd5aeaf63c98711e6ace500163e0521c8', '2017-09-28', 23);
-- Desperate Housewives
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 1', '绝望主妇 第一季', 1, 'd5a6b759c98711e6ace500163e0521c8', '2004-10-03', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 2', '绝望主妇 第二季', 2, 'd5a6b759c98711e6ace500163e0521c8', '2005-09-25', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 3', '绝望主妇 第三季', 3, 'd5a6b759c98711e6ace500163e0521c8', '2006-09-24', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 4', '绝望主妇 第四季', 4, 'd5a6b759c98711e6ace500163e0521c8', '2007-09-30', 17);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 5', '绝望主妇 第五季', 5, 'd5a6b759c98711e6ace500163e0521c8', '2008-09-28', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 6', '绝望主妇 第六季', 6, 'd5a6b759c98711e6ace500163e0521c8', '2009-09-27', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 7', '绝望主妇 第七季', 7, 'd5a6b759c98711e6ace500163e0521c8', '2010-09-27', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Desperate Housewives: Season 8', '绝望主妇 第八季', 8, 'd5a6b759c98711e6ace500163e0521c8', '2011-09-25', 23);
-- The X-Files
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 1', 'X档案 第一季', 1, 'e36d5f0dcbf111e6ace500163e0521c8', '1993-09-10', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 2', 'X档案 第二季', 2, 'e36d5f0dcbf111e6ace500163e0521c8', '1994-09-16', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 3', 'X档案 第三季', 3, 'e36d5f0dcbf111e6ace500163e0521c8', '1995-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 4', 'X档案 第四季', 4, 'e36d5f0dcbf111e6ace500163e0521c8', '1996-10-04', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 5', 'X档案 第五季', 5, 'e36d5f0dcbf111e6ace500163e0521c8', '1997-11-02', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 6', 'X档案 第六季', 6, 'e36d5f0dcbf111e6ace500163e0521c8', '1998-11-08', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 7', 'X档案 第七季', 7, 'e36d5f0dcbf111e6ace500163e0521c8', '1999-11-07', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 8', 'X档案 第八季', 8, 'e36d5f0dcbf111e6ace500163e0521c8', '2000-11-05', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 9', 'X档案 第九季', 9, 'e36d5f0dcbf111e6ace500163e0521c8', '2001-11-11', 19);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 10', 'X档案 第十季', 10, 'e36d5f0dcbf111e6ace500163e0521c8', '2016-01-24', 6);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The X-Files: Season 11', 'X档案 第十一季', 11, 'e36d5f0dcbf111e6ace500163e0521c8', '2018-01-03', 10);
-- Warehouse 13
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Warehouse 13: Season 1', '十三号仓库 第一季', 1, 'f8ddb8f1c8fd11e6ace500163e0521c8', '2009-07-07', 13);
-- 首播日期天不准确
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Warehouse 13: Season 2', '十三号仓库 第二季', 2, 'f8ddb8f1c8fd11e6ace500163e0521c8', '2010-07-07', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Warehouse 13: Season 3', '十三号仓库 第三季', 3, 'f8ddb8f1c8fd11e6ace500163e0521c8', '2011-07-11', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Warehouse 13: Season 4', '十三号仓库 第四季', 4, 'f8ddb8f1c8fd11e6ace500163e0521c8', '2012-07-24', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Warehouse 13: Season 5', '十三号仓库 第五季', 5, 'f8ddb8f1c8fd11e6ace500163e0521c8', '2014-04-15', 6);
-- Nip/Tuck
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nip/Tuck: Season 1', '整容室 第一季', 1, 'd9e1e36c852711e6b53fa0d3c1483ed9', '2003-07-22', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nip/Tuck: Season 2', '整容室 第二季', 2, 'd9e1e36c852711e6b53fa0d3c1483ed9', '2004-06-22', 16);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nip/Tuck: Season 3', '整容室 第三季', 3, 'd9e1e36c852711e6b53fa0d3c1483ed9', '2005-09-20', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nip/Tuck: Season 4', '整容室 第四季', 4, 'd9e1e36c852711e6b53fa0d3c1483ed9', '2006-09-05', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nip/Tuck: Season 5', '整容室 第五季', 5, 'd9e1e36c852711e6b53fa0d3c1483ed9', '2007-10-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Nip/Tuck: Season 6', '整容室 第六季', 6, 'd9e1e36c852711e6b53fa0d3c1483ed9', '2009-10-14', 19);
-- New Girl
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 1', '杰茜驾到 第一季', 1, '6760b8e0cbd611e6ace500163e0521c8', '2011-09-10', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 2', '杰茜驾到 第二季', 2, '6760b8e0cbd611e6ace500163e0521c8', '2012-09-25', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 3', '杰茜驾到 第三季', 3, '6760b8e0cbd611e6ace500163e0521c8', '2013-09-17', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 4', '杰茜驾到 第四季', 4, '6760b8e0cbd611e6ace500163e0521c8', '2014-09-16', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 5', '杰茜驾到 第五季', 5, '6760b8e0cbd611e6ace500163e0521c8', '2016-01-05', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 6', '杰茜驾到 第六季', 6, '6760b8e0cbd611e6ace500163e0521c8', '2016-09-20', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'New Girl: Season 7', '杰茜驾到 第七季', 7, '6760b8e0cbd611e6ace500163e0521c8', '2018-04-10', 8);
-- How I Met Your Mother
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 1', '老爸老妈的浪漫史 第一季', 1, '714f8ad9cbf211e6ace500163e0521c8', '2005-09-19', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 2', '老爸老妈的浪漫史 第二季', 2, '714f8ad9cbf211e6ace500163e0521c8', '2006-09-18', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 3', '老爸老妈的浪漫史 第三季', 3, '714f8ad9cbf211e6ace500163e0521c8', '2007-09-24', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 4', '老爸老妈的浪漫史 第四季', 4, '714f8ad9cbf211e6ace500163e0521c8', '2008-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 5', '老爸老妈的浪漫史 第五季', 5, '714f8ad9cbf211e6ace500163e0521c8', '2009-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 6', '老爸老妈的浪漫史 第六季', 6, '714f8ad9cbf211e6ace500163e0521c8', '2010-09-20', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 7', '老爸老妈的浪漫史 第七季', 7, '714f8ad9cbf211e6ace500163e0521c8', '2011-09-19', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 8', '老爸老妈的浪漫史 第八季', 8, '714f8ad9cbf211e6ace500163e0521c8', '2012-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'How I Met Your Mother: Season 9', '老爸老妈的浪漫史 第九季', 9, '714f8ad9cbf211e6ace500163e0521c8', '2013-09-23', 24);
-- 24
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 1', '24小时 第一季', 1, '78fb58b5cbf111e6ace500163e0521c8', '2001-11-06', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 2', '24小时 第二季', 2, '78fb58b5cbf111e6ace500163e0521c8', '2002-10-29', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 3', '24小时 第三季', 3, '78fb58b5cbf111e6ace500163e0521c8', '2003-10-28', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 4', '24小时 第四季', 4, '78fb58b5cbf111e6ace500163e0521c8', '2005-01-09', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 5', '24小时 第五季', 5, '78fb58b5cbf111e6ace500163e0521c8', '2006-01-15', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 6', '24小时 第六季', 6, '78fb58b5cbf111e6ace500163e0521c8', '2007-01-14', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Season 7', '24小时 第七季', 7, '78fb58b5cbf111e6ace500163e0521c8', '2009-01-11', 24);
-- 24: Legacy
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), '24: Legacy: Season 1', '24小时：遗产 第一季', 1, '788a62cdee7a11e6beeb00163e0521c8', '2017-02-05', 12);
-- Salem
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Salem: Season 1', '塞勒姆 第一季', 1, '8a501df8cb7e11e6ace500163e0521c8', '2014-04-20', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Salem: Season 2', '塞勒姆 第二季', 2, '8a501df8cb7e11e6ace500163e0521c8', '2015-04-05', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Salem: Season 3', '塞勒姆 第三季', 3, '8a501df8cb7e11e6ace500163e0521c8', '2016-11-02', 10);
-- Under the Dome
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Under the Dome: Season 1', '穹顶之下 第一季', 1, '8ec492fccb8111e6ace500163e0521c8', '2013-06-24', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Under the Dome: Season 2', '穹顶之下 第二季', 2, '8ec492fccb8111e6ace500163e0521c8', '2014-06-30', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Under the Dome: Season 3', '穹顶之下 第三季', 3, '8ec492fccb8111e6ace500163e0521c8', '2015-06-25', 13);
-- Friends
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 1', '老友记 第一季', 1, 'aa137a8dcbf111e6ace500163e0521c8', '1994-09-22', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 2', '老友记 第二季', 2, 'aa137a8dcbf111e6ace500163e0521c8', '1995-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 3', '老友记 第三季', 3, 'aa137a8dcbf111e6ace500163e0521c8', '1996-09-16', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 4', '老友记 第四季', 4, 'aa137a8dcbf111e6ace500163e0521c8', '1997-09-25', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 5', '老友记 第五季', 5, 'aa137a8dcbf111e6ace500163e0521c8', '1998-09-24', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 6', '老友记 第六季', 6, 'aa137a8dcbf111e6ace500163e0521c8', '1999-09-23', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 7', '老友记 第七季', 7, 'aa137a8dcbf111e6ace500163e0521c8', '2000-10-12', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 8', '老友记 第八季', 8, 'aa137a8dcbf111e6ace500163e0521c8', '2001-09-27', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 9', '老友记 第九季', 9, 'aa137a8dcbf111e6ace500163e0521c8', '2002-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Friends: Season 10', '老友记 第十季', 10, 'aa137a8dcbf111e6ace500163e0521c8', '2003-09-25', 18);
-- Orange is the New Black
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Orange is the New Black: Season 1', '女子监狱 第一季', 1, '9e1d5b7ecbf011e6ace500163e0521c8', '2013-07-11', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Orange is the New Black: Season 2', '女子监狱 第二季', 2, '9e1d5b7ecbf011e6ace500163e0521c8', '2014-06-06', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Orange is the New Black: Season 3', '女子监狱 第三季', 3, '9e1d5b7ecbf011e6ace500163e0521c8', '2015-06-12', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Orange is the New Black: Season 4', '女子监狱 第四季', 4, '9e1d5b7ecbf011e6ace500163e0521c8', '2016-06-17', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Orange is the New Black: Season 5', '女子监狱 第五季', 5, '9e1d5b7ecbf011e6ace500163e0521c8', '2017-06-09', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Orange is the New Black: Season 6', '女子监狱 第六季', 6, '9e1d5b7ecbf011e6ace500163e0521c8', '2018-07-27', 13);
-- Reign
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Reign: Season 1', '风中的女王 第一季', 1, 'ce53f336c93011e6ace500163e0521c8', '2013-10-17', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Reign: Season 2', '风中的女王 第二季', 2, 'ce53f336c93011e6ace500163e0521c8', '2014-10-02', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Reign: Season 3', '风中的女王 第三季', 3, 'ce53f336c93011e6ace500163e0521c8', '2015-10-09', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Reign: Season 4', '风中的女王 第四季', 4, 'ce53f336c93011e6ace500163e0521c8', '2017-02-10', 16);
-- Hannibal
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hannibal: Season 1', '汉尼拔 第一季', 1, '5aa91ca6cb2f11e6ace500163e0521c8', '2013-04-04', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hannibal: Season 2', '汉尼拔 第二季', 2, '5aa91ca6cb2f11e6ace500163e0521c8', '2014-02-28', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Hannibal: Season 3', '汉尼拔 第三季', 3, '5aa91ca6cb2f11e6ace500163e0521c8', '2015-06-04', 13);
-- The Americans
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Americans: Season 1', '美国谍梦 第一季', 1, '5ab68ea0cb2f11e6ace500163e0521c8', '2013-01-30', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Americans: Season 2', '美国谍梦 第二季', 2, '5ab68ea0cb2f11e6ace500163e0521c8', '2014-02-26', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Americans: Season 3', '美国谍梦 第三季', 3, '5ab68ea0cb2f11e6ace500163e0521c8', '2015-01-28', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Americans: Season 4', '美国谍梦 第四季', 4, '5ab68ea0cb2f11e6ace500163e0521c8', '2016-03-16', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Americans: Season 5', '美国谍梦 第五季', 5, '5ab68ea0cb2f11e6ace500163e0521c8', '2017-03-07', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Americans: Season 6', '美国谍梦 第六季', 6, '5ab68ea0cb2f11e6ace500163e0521c8', '2018-03-28', 10);
-- The Good Wife
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 1', '傲骨贤妻 第一季', 1, '1BE1B8E4CBF111E6ACE500163E0521C8', '2009-09-22', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 2', '傲骨贤妻 第二季', 2, '1BE1B8E4CBF111E6ACE500163E0521C8', '2010-09-28', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 3', '傲骨贤妻 第三季', 3, '1BE1B8E4CBF111E6ACE500163E0521C8', '2011-09-25', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 4', '傲骨贤妻 第四季', 4, '1BE1B8E4CBF111E6ACE500163E0521C8', '2012-09-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 5', '傲骨贤妻 第五季', 5, '1BE1B8E4CBF111E6ACE500163E0521C8', '2013-09-29', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 6', '傲骨贤妻 第六季', 6, '1BE1B8E4CBF111E6ACE500163E0521C8', '2014-09-21', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Good Wife: Season 7', '傲骨贤妻 第七季', 7, '1BE1B8E4CBF111E6ACE500163E0521C8', '2015-10-04', 22);
-- House of Cards
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House of Cards: Season 1', '纸牌屋 第一季', 1, '4472cc53cb7e11e6ace500163e0521c8', '2013-02-01', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House of Cards: Season 2', '纸牌屋 第二季', 2, '4472cc53cb7e11e6ace500163e0521c8', '2014-02-14', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House of Cards: Season 3', '纸牌屋 第三季', 3, '4472cc53cb7e11e6ace500163e0521c8', '2015-02-27', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House of Cards: Season 4', '纸牌屋 第四季', 4, '4472cc53cb7e11e6ace500163e0521c8', '2016-03-04', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House of Cards: Season 5', '纸牌屋 第五季', 5, '4472cc53cb7e11e6ace500163e0521c8', '2017-02-24', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House of Cards: Season 6', '纸牌屋 第六季', 6, '4472cc53cb7e11e6ace500163e0521c8', '2018-11-02', 8);
-- Fargo
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fargo: Season 1', '冰血暴 第一季', 1, '7f9ed606dde411e6ace500163e0521c8', '2014-04-15', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fargo: Season 2', '冰血暴 第二季', 2, '7f9ed606dde411e6ace500163e0521c8', '2015-10-12', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Fargo: Season 3', '冰血暴 第三季', 3, '7f9ed606dde411e6ace500163e0521c8', '2017-04-19', 10);
-- House M.D.
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 1', '豪斯医生 第一季', 1, 'B2E0AC23CBF211E6ACE500163E0521C8', '2004-11-16', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 2', '豪斯医生 第二季', 2, 'B2E0AC23CBF211E6ACE500163E0521C8', '2005-09-13', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 3', '豪斯医生 第三季', 3, 'B2E0AC23CBF211E6ACE500163E0521C8', '2006-09-05', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 4', '豪斯医生 第四季', 4, 'B2E0AC23CBF211E6ACE500163E0521C8', '2007-09-25', 16);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 5', '豪斯医生 第五季', 5, 'B2E0AC23CBF211E6ACE500163E0521C8', '2008-09-16', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 6', '豪斯医生 第六季', 6, 'B2E0AC23CBF211E6ACE500163E0521C8', '2009-09-21', 21);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 7', '豪斯医生 第七季', 7, 'B2E0AC23CBF211E6ACE500163E0521C8', '2010-09-20', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'House M.D.: Season 8', '豪斯医生 第八季', 8, 'B2E0AC23CBF211E6ACE500163E0521C8', '2011-10-03', 22);
-- Teen Wolf
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Teen Wolf: Season 1', '少狼 第一季', 1, 'EB0B3FB38D0711E6A2ECA0D3C1483ED9', '2011-06-05', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Teen Wolf: Season 2', '少狼 第二季', 2, 'EB0B3FB38D0711E6A2ECA0D3C1483ED9', '2012-06-03', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Teen Wolf: Season 3', '少狼 第三季', 3, 'EB0B3FB38D0711E6A2ECA0D3C1483ED9', '2013-06-03', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Teen Wolf: Season 4', '少狼 第四季', 4, 'EB0B3FB38D0711E6A2ECA0D3C1483ED9', '2014-06-23', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Teen Wolf: Season 5', '少狼 第五季', 5, 'EB0B3FB38D0711E6A2ECA0D3C1483ED9', '2015-06-29', 20);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Teen Wolf: Season 6', '少狼 第六季', 6, 'EB0B3FB38D0711E6A2ECA0D3C1483ED9', '2016-11-15', 10);
-- Homeland
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 1', '国土安全 第一季', 1, 'fbe54dd0cbef11e6ace500163e0521c8', '2011-10-02', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 2', '国土安全 第二季', 2, 'fbe54dd0cbef11e6ace500163e0521c8', '2012-09-30', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 3', '国土安全 第三季', 3, 'fbe54dd0cbef11e6ace500163e0521c8', '2013-09-29', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 4', '国土安全 第四季', 4, 'fbe54dd0cbef11e6ace500163e0521c8', '2014-10-05', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 5', '国土安全 第五季', 5, 'fbe54dd0cbef11e6ace500163e0521c8', '2015-10-04', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 6', '国土安全 第六季', 6, 'fbe54dd0cbef11e6ace500163e0521c8', '2017-01-15', 12);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Homeland: Season 7', '国土安全 第七季', 7, 'fbe54dd0cbef11e6ace500163e0521c8', '2018-02-11', 12);
-- Sneaky Pete
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sneaky Pete: Season 1', '诈欺担保人 第一季', 1, '07702f1ee0a911e6913800163e0521c8', '2017-01-13', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Sneaky Pete: Season 2', '诈欺担保人 第二季', 2, '07702f1ee0a911e6913800163e0521c8', '2018-03-09', 10);
-- The Last Ship
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Last Ship: Season 1', '末日孤舰 第一季', 1, 'f2bdec27cb8111e6ace500163e0521c8', '2014-06-22', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Last Ship: Season 2', '末日孤舰 第二季', 2, 'f2bdec27cb8111e6ace500163e0521c8', '2015-06-21', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Last Ship: Season 3', '末日孤舰 第三季', 3, 'f2bdec27cb8111e6ace500163e0521c8', '2016-06-19', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Last Ship: Season 4', '末日孤舰 第四季', 4, 'f2bdec27cb8111e6ace500163e0521c8', '2017-08-20', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The Last Ship: Season 5', '末日孤舰 第五季', 5, 'f2bdec27cb8111e6ace500163e0521c8', '2018-09-09', 10);
-- Black Sails
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Black Sails: Season 1', '黑帆 第一季', 1, '1df64e7dcb2f11e6ace500163e0521c8', '2014-01-25', 8);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Black Sails: Season 2', '黑帆 第二季', 2, '1df64e7dcb2f11e6ace500163e0521c8', '2015-01-24', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Black Sails: Season 3', '黑帆 第三季', 3, '1df64e7dcb2f11e6ace500163e0521c8', '2016-01-23', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Black Sails: Season 4', '黑帆 第四季', 4, '1df64e7dcb2f11e6ace500163e0521c8', '2017-01-29', 10);
-- The 100
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The 100: Season 1', '地球百子 第一季', 1, 'ce421032c93011e6ace500163e0521c8', '2014-03-19', 13);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The 100: Season 2', '地球百子 第二季', 2, 'ce421032c93011e6ace500163e0521c8', '2014-10-22', 16);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The 100: Season 3', '地球百子 第三季', 3, 'ce421032c93011e6ace500163e0521c8', '2016-01-21', 16);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'The 100: Season 4', '地球百子 第四季', 4, 'ce421032c93011e6ace500163e0521c8', '2017-02-01', 13);
-- Will & Grace
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 1', '威尔和格蕾丝 第一季', 1, '2ed58e0ee04c11e6913800163e0521c8', '1998-09-21', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 2', '威尔和格蕾丝 第二季', 2, '2ed58e0ee04c11e6913800163e0521c8', '1999-09-21', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 3', '威尔和格蕾丝 第三季', 3, '2ed58e0ee04c11e6913800163e0521c8', '2000-10-12', 25);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 4', '威尔和格蕾丝 第四季', 4, '2ed58e0ee04c11e6913800163e0521c8', '2001-09-27', 27);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 5', '威尔和格蕾丝 第五季', 5, '2ed58e0ee04c11e6913800163e0521c8', '2002-09-26', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 6', '威尔和格蕾丝 第六季', 6, '2ed58e0ee04c11e6913800163e0521c8', '2003-09-25', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 7', '威尔和格蕾丝 第七季', 7, '2ed58e0ee04c11e6913800163e0521c8', '2004-09-16', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 8', '威尔和格蕾丝 第八季', 8, '2ed58e0ee04c11e6913800163e0521c8', '2005-09-29', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Will & Grace: Season 9', '威尔和格蕾丝 第九季', 9, '2ed58e0ee04c11e6913800163e0521c8', '2017-09-28', 12);
-- Frequency
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Frequency: Season 1', '黑洞频率 第一季', 1, '3EFF2C9FE0B111E6913800163E0521C8', '2016-10-05', 13);
-- Mosaic
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Mosaic: Season 1', '马赛克 第一季', 1, '7b21678affe411e78c7800163e04e7ff', '2018-01-22', 6);
-- Timeless
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Timeless: Season 1', '穿越时间线 第一季', 1, '5c14770ce29b11e6913800163e0521c8', '2016-10-03', 16);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Timeless: Season 2', '穿越时间线 第二季', 2, '5c14770ce29b11e6913800163e0521c8', '2018-03-11', 10);
-- Ghost Whisperer
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Ghost Whisperer: Season 1', '鬼语者 第一季', 1, '3f893639eaa111e68b8500163e0521c8', '2005-09-23', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Ghost Whisperer: Season 2', '鬼语者 第二季', 2, '3f893639eaa111e68b8500163e0521c8', '2006-09-22', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Ghost Whisperer: Season 3', '鬼语者 第三季', 3, '3f893639eaa111e68b8500163e0521c8', '2007-09-28', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Ghost Whisperer: Season 4', '鬼语者 第四季', 4, '3f893639eaa111e68b8500163e0521c8', '2008-10-03', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Ghost Whisperer: Season 5', '鬼语者 第五季', 5, '3f893639eaa111e68b8500163e0521c8', '2009-09-25', 22);
-- Madam Secretary
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Madam Secretary: Season 1', '国务卿女士 第一季', 1, '97b3c1d9ec2c11e68b8500163e0521c8', '2014-09-21', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Madam Secretary: Season 2', '国务卿女士 第二季', 2, '97b3c1d9ec2c11e68b8500163e0521c8', '2015-10-04', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Madam Secretary: Season 3', '国务卿女士 第三季', 3, '97b3c1d9ec2c11e68b8500163e0521c8', '2016-10-02', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Madam Secretary: Season 4', '国务卿女士 第四季', 4, '97b3c1d9ec2c11e68b8500163e0521c8', '2017-10-08', 22);
-- Chicago P.D.
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago P.D.: Season 1', '芝加哥警署 第一季', 1, 'de1c4767e0a911e6913800163e0521c8', '2014-01-08', 15);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago P.D.: Season 2', '芝加哥警署 第二季', 2, 'de1c4767e0a911e6913800163e0521c8', '2014-09-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago P.D.: Season 3', '芝加哥警署 第三季', 3, 'de1c4767e0a911e6913800163e0521c8', '2015-09-30', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago P.D.: Season 4', '芝加哥警署 第四季', 4, 'de1c4767e0a911e6913800163e0521c8', '2016-09-21', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago P.D.: Season 5', '芝加哥警署 第五季', 5, 'de1c4767e0a911e6913800163e0521c8', '2017-09-25', 22);
-- Aggretsuko
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Aggretsuko: Season 1', '职场小烈 第一季', 1, 'cdf9398880e911e88c7800163e04e7ff', '2018-04-20', 10);
-- Chicago Med
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Med: Season 1', '芝加哥急救 第一季', 1, 'ddfe716be0a911e6913800163e0521c8', '2015-11-17', 18);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Med: Season 2', '芝加哥急救 第二季', 2, 'ddfe716be0a911e6913800163e0521c8', '2016-09-22', 18);
-- 首播日期不对
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Med: Season 3', '芝加哥急救 第三季', 3, 'ddfe716be0a911e6913800163e0521c8', '2017-11-21', 13);
-- Chicago Fire
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Fire: Season 1', '芝加哥烈焰 第一季', 1, 'de14f132e0a911e6913800163e0521c8', '2012-10-10', 24);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Fire: Season 2', '芝加哥烈焰 第二季', 2, 'de14f132e0a911e6913800163e0521c8', '2013-09-24', 22);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Fire: Season 3', '芝加哥烈焰 第三季', 3, 'de14f132e0a911e6913800163e0521c8', '2014-09-23', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Fire: Season 4', '芝加哥烈焰 第四季', 4, 'de14f132e0a911e6913800163e0521c8', '2015-10-13', 23);
-- 疑问：第五季多少集
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Fire: Season 5', '芝加哥烈焰 第五季', 5, 'de14f132e0a911e6913800163e0521c8', '2016-10-11', 23);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Chicago Fire: Season 6', '芝加哥烈焰 第六季', 6, 'de14f132e0a911e6913800163e0521c8', '2017-09-28', 23);
-- Spartacus
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Spartacus: Blood and Sand', '斯巴达克斯：血与沙 第一季', 1, '1DECDB47CB2F11E6ACE500163E0521C8', '2010-01-22', 13);
-- 这部属于外传性质
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Spartacus: Gods of the Arena', '斯巴达克斯：竞技场之神', 0, '1DECDB47CB2F11E6ACE500163E0521C8', '2011-01-21', 6);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Spartacus: Vengeance', '斯巴达克斯：复仇 第二季', 2, '1DECDB47CB2F11E6ACE500163E0521C8', '2012-01-27', 10);
INSERT INTO season(uuid, english_name, chinese_name, season_index, serial_uuid, premiere_date, episode_count)
VALUES(LOWER(REPLACE(UUID(), '-', '')), 'Spartacus: War of the Damned', '斯巴达克斯：诅咒者之战 第三季', 3, '1DECDB47CB2F11E6ACE500163E0521C8', '2013-01-25', 10);
-------------------------------------------------------------------------------------------------------------------------- Episodes

-- Fargo
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'The Law of Vacant Places', 'e6c924bf262911e7beeb00163e0521c8');
-- Harlots
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, '', 'd81d456fff5611e6beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, '', 'd81d456fff5611e6beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, '', 'd81d456fff5611e6beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, '', 'd81d456fff5611e6beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, '', 'd81d456fff5611e6beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, '', 'd81d456fff5611e6beeb00163e0521c8');
-- American Horror Story
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'Checking In', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, 'Chutes and Ladders', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, 'Mommy', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, 'Devil''s Night', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, 'Room Service', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, 'Room 33', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 7, 'Flicker', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 8, 'The Ten Commandments Killer', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 9, 'She Wants Revenge', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 10, 'She Gets Revenge', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 11, 'Battle Royale', '8E5EC67A7F3811E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 12, 'Be Our Guest', '8E5EC67A7F3811E69977A0D3C1483ED9');

INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'Free at Last', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, 'Cambalache', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, 'Our Man in Madrid', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, 'The Good, The Bad, and The Dead', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, 'The Enemies of my Enemy', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, 'Los Pepes', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 7, 'Deutschland 93', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 8, 'Exit El Patrón', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 9, 'Nuestra Finca', '17DF5E747D8011E69CF6A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 10, 'Al Fin Cayó!', '17DF5E747D8011E69CF6A0D3C1483ED9');
-- Stranger Things: Season 1
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'The Vanishing of Will Byers', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, 'The Weirdo on Maple Street', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, 'Holly, Jolly', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, 'The Body', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, 'The Flea and the Acrobat', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, 'The Monster', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 7, 'The Bathtub', 'A4D7FB01D8A811E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 8, 'The Upside Down', 'A4D7FB01D8A811E6ACE500163E0521C8');
-- Stranger Things: Season 2
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'Madmax', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, 'The Boy Who Came Back to Life', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, 'The Pumpking Path', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, 'The Palace', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, 'The Storm', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, 'The Pollywog', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 7, 'The Secret Cabin', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 8, 'The Brain', '6F63A1FAD8A911E6ACE500163E0521C8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 9, 'The Lost Brother', '6F63A1FAD8A911E6ACE500163E0521C8');
-- Person of Interest: Season 1
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'Pilot', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, 'Ghosts', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, 'Mission Creep', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, 'Cura Te Ipsum', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, 'Judgement', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, 'The Fix', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 7, 'Witness', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 8, 'Foe', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 9, 'Get Carter', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 10, 'Number Crunch', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 11, 'Super', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 12, 'Legacy', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 13, 'Root Cause', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 14, 'Wolf and Cub', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 15, 'Blue Code', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 16, 'Risk', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 17, 'Baby Blue', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 18, 'Identity Crisis', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 19, 'Flesh and Blood', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 20, 'Matsya Nyaya', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 21, 'Many Happy Returns', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 22, 'No Good Deed', '1D1EFFE67F3D11E69977A0D3C1483ED9');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 23, 'Firewall', '1D1EFFE67F3D11E69977A0D3C1483ED9');
-- Bull
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 12, 'Stockholm Syndrome', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 13, 'The Fall', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 14, 'It\'s Classified', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 15, 'What\'s Your Number?', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 16, 'Free Fall', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 17, 'Name Game', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 18, 'Dressed to Kill', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 19, 'Bring It On', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 20, 'Make Me', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 21, 'Welcome Back, Dr. Bull', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 22, 'Dirty Little Secrets', '18698144105b11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 23, 'Benevolent Deception', '18698144105b11e7beeb00163e0521c8');
-- iZombie
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 1, 'Heaven Just Got a Little Bit Smoother', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 2, 'Zombie Knows Best', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 3, 'Eat, Pray, Liv', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 4, 'Wag the Tongue Slowly', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 5, 'Spanking The Zombie', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 6, 'Some Like It Hot Mess', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 7, 'Dirt Nap Time', '2c09f6032a7111e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES(LOWER(REPLACE(UUID(), '-', '')), 8, 'Eat a Knievel', '2c09f6032a7111e7beeb00163e0521c8');
-- The Get Down
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Unfold Your Own Myth', '63b668cd200511e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'The Beat Says, This Is the Way', '63b668cd200511e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 9, 'One by One, Into the Dark', '63b668cd200511e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 10, 'Gamble Everything', '63b668cd200511e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 11, 'Only from Exile Can We Come Home', '63b668cd200511e7beeb00163e0521c8');
-- Loaded
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Lawsuit', 'dc42cf9c3a2811e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Leons Teacher', 'dc42cf9c3a2811e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Josh\'s Mum and Dad', 'dc42cf9c3a2811e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Watto\'s Mum', 'dc42cf9c3a2811e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'The Boat', 'dc42cf9c3a2811e7beeb00163e0521c8');
-- White Gold
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Salesmen Are Like Vampires', '411d61284f2d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Sexy Rollercoaster', '411d61284f2d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Close Encounters', '411d61284f2d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'The Widow Maker', '411d61284f2d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Smell the Weakness', '411d61284f2d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'The Secret of Sales', '411d61284f2d11e798eb00163e0521c8');
-- Poldark
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Episode 1', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Episode 2', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Episode 5', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Episode 6', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Episode 7', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Episode 8', 'c4f3abfd4f2c11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 9, 'Episode 9', 'c4f3abfd4f2c11e798eb00163e0521c8');
-- I Love Dick
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Pilot', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'The Conceptual Fuck', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Scenes from a Marriage', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Ilinx', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'A Short History of Weird Girls', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'This is Not a Love Letter', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'The Barter Economy', 'd953331f45bd11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Cowboys and Nomads', 'd953331f45bd11e7beeb00163e0521c8');
-- The Jinx: The Life and Deaths of Robert Durst
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'A Body in the Bay', '0c7bce99472c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Poor Little Rich Boy', '0c7bce99472c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'The Gangster\'s Daughter', '0c7bce99472c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'The State of Texas vs. Robert Durst', '0c7bce99472c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Family Values', '0c7bce99472c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'What the Hell Did I Do?', '0c7bce99472c11e7beeb00163e0521c8');
-- Wet Hot American Summer: First Day of Camp
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Campers Arrive', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Lunch', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Activities', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Auditions', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Dinner', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Electro City', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Staff Party', '3e2acf0e5ad511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Day is Done', '3e2acf0e5ad511e798eb00163e0521c8');
-- Castlevania
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Witchbottle', 'b111984a637b11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Necropolis', 'b111984a637b11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Labyrinth', 'b111984a637b11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Monument', 'b111984a637b11e798eb00163e0521c8');
-- Foyle's War
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'The German Woman', '92d34c5f638711e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'The White Feather', '92d34c5f638711e798eb00163e0521c8');
-- Max and Paddy's Road to Nowhere
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Episode 1', 'f1f3853763a111e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Episode 2', 'f1f3853763a111e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', 'f1f3853763a111e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', 'f1f3853763a111e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Episode 5', 'f1f3853763a111e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Episode 6', 'f1f3853763a111e798eb00163e0521c8');
-- Will
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'The Play\'s the Thing', '03e61b5461ff11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Cowards Die Many Times', '03e61b5461ff11e798eb00163e0521c8');
-- Animal Kingdom
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Cry Havoc', '641a12274b6011e7beeb00163e0521c8');
-- Vice
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 15, 'Future of Firearms & Russia "Wins" Climate Change', '51fcc3da12d011e7beeb00163e0521c8');
-- Suits
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Skin in the Game', '12c3f8e3682d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'The Statue', '12c3f8e3682d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Specter Litt', '12c3f8e3682d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Divide and Conquer', '12c3f8e3682d11e798eb00163e0521c8');
-- Friends From College
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Welcome to New York', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Connecticut House', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'All-Nighter', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Mission Impossible', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Party Bus', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Second Wedding', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Grand Cayman', '7a1af4ba3f8c11e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'A Night of Surprises', '7a1af4ba3f8c11e7beeb00163e0521c8');
-- Riviera
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Episode 1', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Episode 2', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Episode 5', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Episode 6', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Episode 7', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Episode 8', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 9, 'Episode 9', '02e4a6136a8a11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 10, 'Episode 10', '02e4a6136a8a11e798eb00163e0521c8');
-- Jamestown
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Episode 1', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Episode 2', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Episode 5', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Episode 6', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Episode 7', '525ae6b16c4011e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Episode 8', '525ae6b16c4011e798eb00163e0521c8');
-- The Good Karma Hospital
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Solar Scare', 'dcd86ce6cbff11e789a000163e05314b');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Good Finds', 'dcd86ce6cbff11e789a000163e05314b');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', '70a6987963a511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', '70a6987963a511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Episode 5', '70a6987963a511e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Episode 6', '70a6987963a511e798eb00163e0521c8');
-- TURN
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Nightmare', '0ae78d6a2f0411e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'Quarry', '0ae78d6a2f0411e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Belly of the Beast', '0ae78d6a2f0411e7beeb00163e0521c8');
-- The Fosters
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Exterminate Her', 'c6c646b2053611e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Too Fast, Too Furious', 'c6c646b2053611e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Telling', 'c6c646b2053611e7beeb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Welcome to the Jungler', 'c6c646b2053611e7beeb00163e0521c8');
-- Will
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'The Two Gentlemen', '03e61b5461ff11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Brave New World', '03e61b5461ff11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'The Marriage of True Minds', '03e61b5461ff11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Something Wicked This Way Comes', '03e61b5461ff11e798eb00163e0521c8');
-- 临时
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 0, '', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 1, 'Episode 1', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'Episode 2', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Episode 5', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Episode 6', '8fa5a31ff2c811e78c7800163e04e7ff');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'We\'re Off to Kill the Wizard', 'c4959bf4639f11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 8, 'Death Takes a Curtain Call', 'c4959bf4639f11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 9, 'Death Casts a Spell', 'c4959bf4639f11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 10, 'Capitol Offense', 'c4959bf4639f11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 11, '11:11', 'd6b635608f8311e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 12, 'Welcome Back, Glinda', 'd6b635608f8311e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 13, 'Go For Kansas', 'd6b635608f8311e798eb00163e0521c8');||||||| .r329
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', '1a1193df780011e798eb00163e0521c8');
VALUES (LOWER(REPLACE(UUID(), '-', '')), 2, 'On Your Mark', '8f71f4637efb11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 3, 'Episode 3', '8f71f4637efb11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 4, 'Episode 4', '31b0e1b17c9d11e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 5, 'Shabbos Goy', 'c397fef87bd411e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 6, 'Shelley Duvall', 'c397fef87bd411e798eb00163e0521c8');
INSERT INTO episode(episode_id, episode_index, episode_name, uuid) 
VALUES (LOWER(REPLACE(UUID(), '-', '')), 7, 'If I Should Fall From Grace With God', 'c397fef87bd411e798eb00163e0521c8');>>>>>>> .r330

