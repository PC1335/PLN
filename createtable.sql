CREATE TABLE `soap` (
  `cmsID` varchar(25) DEFAULT NULL COMMENT '上游ID',
  `sopID` varchar(25) DEFAULT NULL COMMENT '自己ID',
  `correlateID` varchar(40) DEFAULT NULL COMMENT '消息ID  唯一',
  `cmdFileURL` varchar(225) DEFAULT NULL COMMENT '存放URL  XML读取地址',
  `now` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `channel` (
  `c_contentid` varchar(36) NOT NULL,
  `Name` varchar(14) DEFAULT NULL,
  `c_channelnumber` varchar(3) DEFAULT NULL,
  `c_name` varchar(64) DEFAULT NULL,
  `c_callsign` varchar(10) DEFAULT NULL,
  `c_timeshift` varchar(1) DEFAULT NULL,
  `c_type` varchar(1) DEFAULT NULL,
  `c_status` varchar(1) DEFAULT NULL,
  `c_starttime` varchar(4) DEFAULT NULL,
  `c_endtime` varchar(4) DEFAULT NULL,
  `c_tags` varchar(32) DEFAULT NULL,
  `c_cpcontentid` varchar(128) DEFAULT NULL,
  `c_storageduration` varchar(9) DEFAULT NULL,
  `c_timeshiftduration` varchar(9) DEFAULT NULL,
  `c_description` varchar(1024) DEFAULT NULL,
  `c_country` varchar(128) DEFAULT NULL,
  `c_state` varchar(128) DEFAULT NULL,
  `c_city` varchar(128) DEFAULT NULL,
  `c_zipcode` varchar(10) DEFAULT NULL,
  `c_url` varchar(500) DEFAULT NULL,
  `c_subtype` varchar(1) DEFAULT NULL,
  `c_language` varchar(128) DEFAULT NULL,
  `c_macrovision` varchar(1) DEFAULT NULL,
  `c_videotype` varchar(10) DEFAULT NULL,
  `c_audiotype` varchar(10) DEFAULT NULL,
  `c_streamtype` varchar(1) DEFAULT NULL,
  `c_bilingual` varchar(1) DEFAULT NULL,
  `c_hotdegree` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`c_contentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `mapping` (
  `parenttype` varchar(30) DEFAULT NULL,
  `elementtype` varchar(30) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  `elementid` varchar(32) DEFAULT NULL,
  `parentcode` varchar(128) DEFAULT NULL,
  `elementcode` varchar(128) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `sequence` varchar(3) DEFAULT NULL,
  `validstart` varchar(14) DEFAULT NULL,
  `validend` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `physicalchannel` (
  `p_contentid` varchar(32) NOT NULL,
  `p_destcasttype` varchar(9) DEFAULT NULL,
  `p_srccasttype` varchar(9) DEFAULT NULL,
  `p_bitratetype` varchar(1) DEFAULT NULL,
  `p_tags` varchar(32) DEFAULT NULL,
  `p_cpcontentid` varchar(128) DEFAULT NULL,
  `p_multicastip` varchar(64) DEFAULT NULL,
  `p_multicastport` varchar(5) DEFAULT NULL,
  `p_unicasturl` varchar(1024) DEFAULT NULL,
  `p_videotype` varchar(5) DEFAULT NULL,
  `p_audiotype` varchar(3) DEFAULT NULL,
  `p_resolution` varchar(7) DEFAULT NULL,
  `p_videoprofile` varchar(16) DEFAULT NULL,
  `p_systemlayer` varchar(3) DEFAULT NULL,
  `p_domain` varchar(10) DEFAULT NULL,
  `p_hotdegree` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`p_contentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `picture` (
  `p_contentid` varchar(32) NOT NULL,
  `p_fileurl` varchar(1024) DEFAULT NULL,
  `p_type` varchar(1) DEFAULT NULL,
  `p_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`p_contentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `schedulerecord` (
  `s_contentid` varchar(32) NOT NULL,
  `s_physicalchannelid` varchar(32) DEFAULT NULL,
  `s_name` varchar(128) DEFAULT NULL,
  `s_startdate` varchar(8) DEFAULT NULL,
  `s_starttime` varchar(6) DEFAULT NULL,
  `s_duration` varchar(6) DEFAULT NULL,
  `s_cpcontentid` varchar(128) DEFAULT NULL,
  `s_description` varchar(1024) DEFAULT NULL,
  `s_domain` varchar(32) DEFAULT NULL,
  `s_hotdegree` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`s_contentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
