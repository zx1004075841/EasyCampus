-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.16-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 easy_campus 的数据库结构
CREATE DATABASE IF NOT EXISTS `easy_campus` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `easy_campus`;

-- 导出  表 easy_campus.activities 结构
CREATE TABLE IF NOT EXISTS `activities` (
  `activity_name` varchar(20) NOT NULL COMMENT '活动的名称',
  `activity_address` varchar(20) NOT NULL COMMENT '活动的地点',
  `activity_start_time` date NOT NULL COMMENT '活动的开始时间',
  `activity_end_time` date NOT NULL COMMENT '活动的结束时间',
  `activity_content` varchar(50) NOT NULL COMMENT '活动的内容',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表的主键',
  `club_id` char(32) NOT NULL COMMENT '所属club的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这个表是保存所有activity的表';

-- 正在导出表  easy_campus.activities 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;

-- 导出  表 easy_campus.clubs 结构
CREATE TABLE IF NOT EXISTS `clubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '这张表的主键',
  `club_name` varchar(50) NOT NULL COMMENT '社团名称',
  `club_id` char(32) NOT NULL COMMENT '社团id',
  `club_info` varchar(300) NOT NULL DEFAULT '' COMMENT '社团简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社团的表';

-- 正在导出表  easy_campus.clubs 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;

-- 导出  表 easy_campus.club_user 结构
CREATE TABLE IF NOT EXISTS `club_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '这张表的表示',
  `user_id` char(8) NOT NULL DEFAULT '0' COMMENT '用户的id',
  `club_id` char(32) DEFAULT '0' COMMENT 'club的id',
  `user_authority` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '用户的权限',
  `user_role` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '用户的角色',
  `activity` int(11) DEFAULT NULL COMMENT '是否参加活动',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和社团的关联表';

-- 正在导出表  easy_campus.club_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `club_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `club_user` ENABLE KEYS */;

-- 导出  表 easy_campus.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表的主键',
  `user_id` char(8) NOT NULL DEFAULT '0' COMMENT '这个商品拥有者的id',
  `goods_name` varchar(20) NOT NULL DEFAULT '0' COMMENT '商品名称',
  `goods_content` varchar(50) NOT NULL DEFAULT '0' COMMENT '商品简介',
  `goods_image` varchar(50) NOT NULL DEFAULT '0' COMMENT '商品的图片路径',
  `goods_price` float NOT NULL DEFAULT '0' COMMENT '商品的价格',
  `goods_user` varchar(20) NOT NULL DEFAULT '""' COMMENT '商品所有人',
  `goods_id` char(32) NOT NULL DEFAULT '""' COMMENT '商品的id',
  `goods_type` int(2) NOT NULL COMMENT '商品的类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这个表用来定义货物的表';

-- 正在导出表  easy_campus.goods 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- 导出  表 easy_campus.skills 结构
CREATE TABLE IF NOT EXISTS `skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '这张表的唯一标示',
  `skill_name` varchar(50) NOT NULL DEFAULT '0' COMMENT '技能的名称',
  `skill_type` int(2) NOT NULL DEFAULT '0' COMMENT '技能的分类',
  `skill_info` varchar(500) NOT NULL DEFAULT '0' COMMENT '技能的描述',
  `user_id` char(8) NOT NULL DEFAULT '0' COMMENT '拥有这个技能的用户',
  `skill_id` char(32) NOT NULL DEFAULT '0' COMMENT '技能的标示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这张表用来存储技能';

-- 正在导出表  easy_campus.skills 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;

-- 导出  表 easy_campus.skill_content 结构
CREATE TABLE IF NOT EXISTS `skill_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标示',
  `content_context` varchar(500) DEFAULT '0' COMMENT '评论的内容',
  `content_time` char(17) NOT NULL COMMENT '评论的时间',
  `user_id` char(8) NOT NULL COMMENT '用户的id',
  `user_focus` int(1) DEFAULT '0' COMMENT '用户是否关注这个活动',
  `skill_id` char(32) DEFAULT '0' COMMENT '被评论的技能的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技能评论';

-- 正在导出表  easy_campus.skill_content 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `skill_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_content` ENABLE KEYS */;

-- 导出  表 easy_campus.skill_type 结构
CREATE TABLE IF NOT EXISTS `skill_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标示',
  `skill_type` int(2) DEFAULT NULL COMMENT '技能的类型',
  `skill_type_name` varchar(50) NOT NULL COMMENT '技能类型的名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这张表存储技能的类型';

-- 正在导出表  easy_campus.skill_type 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `skill_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_type` ENABLE KEYS */;

-- 导出  表 easy_campus.teachers 结构
CREATE TABLE IF NOT EXISTS `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表的主键',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师姓名',
  `teacher_address` varchar(20) NOT NULL COMMENT '教师的地址',
  `teacher_info` varchar(100) NOT NULL COMMENT '教师简介',
  `teacher_id` char(32) NOT NULL COMMENT '教师的编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这个表主要包含所有竞赛老师的表';

-- 正在导出表  easy_campus.teachers 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;

-- 导出  表 easy_campus.users 结构
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '这张表的主键',
  `user_name` varchar(20) NOT NULL DEFAULT '0' COMMENT '用户名',
  `user_type` int(1) NOT NULL DEFAULT '0' COMMENT '用户类型 0为普通用户1为管理员',
  `password` varchar(20) NOT NULL DEFAULT '0' COMMENT '密码',
  `activity_status` int(1) NOT NULL DEFAULT '0' COMMENT '用户的是否激活',
  `name` varchar(20) NOT NULL DEFAULT '0' COMMENT '用户昵称',
  `image_path` varchar(50) NOT NULL DEFAULT '0' COMMENT '头像的路径',
  `email` varchar(50) NOT NULL DEFAULT '0' COMMENT '用户email',
  `brief_introduction` varchar(50) NOT NULL DEFAULT '0' COMMENT '个性签名',
  `user_id` char(8) NOT NULL DEFAULT '0' COMMENT '用户的唯一标示',
  PRIMARY KEY (`id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这个表用来存储用户信息';

-- 正在导出表  easy_campus.users 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
