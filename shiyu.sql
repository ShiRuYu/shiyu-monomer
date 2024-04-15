-- --------------------------------------------------------
-- 主机:                           124.222.20.152
-- 服务器版本:                        8.2.0 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 shiyu 的数据库结构
CREATE DATABASE IF NOT EXISTS `shiyu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shiyu`;

-- 导出  表 shiyu.shi_yu_menu 结构
CREATE TABLE IF NOT EXISTS `shi_yu_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT (now()) COMMENT '更新时间',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '上级id，根节点：0',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '菜单名',
  `type` smallint NOT NULL DEFAULT (0) COMMENT '类型(1:目录,2:菜单,3:按钮,4:状态)',
  `uri` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '路径',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT 'code',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '图标',
  `status` smallint NOT NULL DEFAULT (0) COMMENT '0：正常  ',
  `del_status` smallint NOT NULL DEFAULT '1' COMMENT '0：删除  1：正常  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1748561092298760194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='菜单';

-- 正在导出表  shiyu.shi_yu_menu 的数据：~14 rows (大约)
INSERT INTO `shi_yu_menu` (`id`, `create_time`, `update_time`, `parent_id`, `name`, `type`, `uri`, `code`, `icon`, `status`, `del_status`) VALUES
	(1748559898163634177, '2024-01-20 04:16:22', '2024-01-20 04:16:22', 0, '首页', 0, '/', '', '', 0, 1),
	(1748560041617219586, '2024-01-20 04:16:56', '2024-01-20 04:16:56', 0, '用户管理', 0, '/user', '', '', 0, 1),
	(1748560118788218882, '2024-01-20 04:17:14', '2024-01-20 04:17:14', 1748560041617219586, '用户添加', 0, '/user/add', '', '', 0, 1),
	(1748560157543587842, '2024-01-20 04:17:23', '2024-01-20 04:17:23', 1748560041617219586, '用户删除', 0, '/user/del', '', '', 0, 1),
	(1748560195573342209, '2024-01-20 04:17:33', '2024-01-20 04:17:33', 1748560041617219586, '用户列表', 0, '/user/list', '', '', 0, 1),
	(1748560328125931522, '2024-01-20 04:18:04', '2024-01-20 04:18:04', 0, '角色管理', 0, '/role', '', '', 0, 1),
	(1748560390163881986, '2024-01-20 04:18:19', '2024-01-20 04:18:19', 0, '菜单管理', 0, '/menu', '', '', 0, 1),
	(1748560466286305282, '2024-01-20 04:18:37', '2024-01-20 04:18:37', 1748560390163881986, '菜单添加', 0, '/menu/add', '', '', 0, 1),
	(1748560500717346818, '2024-01-20 04:18:45', '2024-01-20 04:18:45', 1748560390163881986, '菜单删除', 0, '/menu/del', '', '', 0, 1),
	(1748560574088306690, '2024-01-20 04:19:03', '2024-01-20 04:19:03', 1748560390163881986, '菜单列表', 0, '/menu/list', '', '', 0, 1),
	(1748560630296174593, '2024-01-20 04:19:16', '2024-01-20 04:19:16', 1748560390163881986, '菜单树形列表', 0, '/menu/list/tree', '', '', 0, 1),
	(1748561030462136321, '2024-01-20 04:20:52', '2024-01-20 04:20:52', 1748560328125931522, '角色添加', 0, '/role/add', '', '', 0, 1),
	(1748561051911806978, '2024-01-20 04:20:57', '2024-01-20 04:20:57', 1748560328125931522, '角色添加', 0, '/role/del', '', '', 0, 1),
	(1748561092298760193, '2024-01-20 04:21:06', '2024-01-20 04:21:06', 1748560328125931522, '角色列表', 0, '/role/list', '', '', 0, 1);

-- 导出  表 shiyu.shi_yu_role 结构
CREATE TABLE IF NOT EXISTS `shi_yu_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT (now()) COMMENT '更新时间',
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名',
  `code` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'code',
  `status` smallint DEFAULT '0' COMMENT '0：正常  ',
  `del_status` smallint DEFAULT '1' COMMENT '0：删除  1：正常  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1748571743490498562 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色';

-- 正在导出表  shiyu.shi_yu_role 的数据：~4 rows (大约)
INSERT INTO `shi_yu_role` (`id`, `create_time`, `update_time`, `name`, `code`, `status`, `del_status`) VALUES
	(1748543648091955202, '2024-01-20 03:11:48', '2024-01-20 03:11:48', '超级管理员', 'superAdmin', 0, 1),
	(1748571313100382209, '2024-01-20 05:01:43', '2024-01-20 05:01:43', '管理员', 'admin', 0, 1),
	(1748571349695684609, '2024-01-20 05:01:52', '2024-01-20 05:01:52', '用户', 'user', 0, 1),
	(1748571743490498561, '2024-01-20 05:03:26', '2024-01-20 05:03:26', '游客', 'visitor', 0, 1);

-- 导出  表 shiyu.shi_yu_role_menu 结构
CREATE TABLE IF NOT EXISTS `shi_yu_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色菜单关联ID',
  `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT (now()) COMMENT '更新时间',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  `del_status` smallint DEFAULT '1' COMMENT '0：删除  1：正常  ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1748586787796242465 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色菜单关联';

-- 正在导出表  shiyu.shi_yu_role_menu 的数据：~20 rows (大约)
INSERT INTO `shi_yu_role_menu` (`id`, `create_time`, `update_time`, `role_id`, `menu_id`, `del_status`) VALUES
	(1748586787796242445, '2024-01-20 06:22:33', '2024-01-20 06:22:33', 2, 4, 1),
	(1748586787796242446, '2024-01-20 06:22:33', '2024-01-20 06:22:33', 2, 2, 1),
	(1748586787796242447, '2024-01-20 06:23:05', '2024-01-20 06:23:05', 2, 1, 1),
	(1748586787796242448, '2024-01-21 05:29:30', '2024-01-21 05:29:30', 2, 1748559898163634177, 1),
	(1748586787796242449, '2024-01-21 05:29:30', '2024-01-21 05:29:30', 2, 1748560041617219586, 1),
	(1748586787796242450, '2024-01-21 05:29:30', '2024-01-21 05:29:30', 2, 1748560118788218882, 1),
	(1748586787796242451, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748559898163634177, 1),
	(1748586787796242452, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560041617219586, 1),
	(1748586787796242453, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560118788218882, 1),
	(1748586787796242454, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560157543587842, 1),
	(1748586787796242455, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560195573342209, 1),
	(1748586787796242456, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560328125931522, 1),
	(1748586787796242457, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560390163881986, 1),
	(1748586787796242458, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560466286305282, 1),
	(1748586787796242459, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560500717346818, 1),
	(1748586787796242460, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560574088306690, 1),
	(1748586787796242461, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748560630296174593, 1),
	(1748586787796242462, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748561030462136321, 1),
	(1748586787796242463, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748561051911806978, 1),
	(1748586787796242464, '2024-01-21 06:01:57', '2024-01-21 06:01:57', 1748543648091955202, 1748561092298760193, 1);

-- 导出  表 shiyu.shi_yu_user 结构
CREATE TABLE IF NOT EXISTS `shi_yu_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `nick_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  `addr` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `gender` smallint DEFAULT '0' COMMENT '性别 0：保密 1：男 2：女',
  `signature` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '个性签名',
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `ext_info` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '其他信息',
  `status` smallint DEFAULT '0' COMMENT '0:活跃',
  `del_status` smallint DEFAULT '1' COMMENT '0：删除 1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户';

-- 正在导出表  shiyu.shi_yu_user 的数据：~1 rows (大约)
INSERT INTO `shi_yu_user` (`id`, `create_time`, `update_time`, `nick_name`, `avatar_url`, `phone`, `email`, `birthday`, `addr`, `gender`, `signature`, `password`, `ext_info`, `status`, `del_status`) VALUES
	(1, '2024-01-07 05:46:12', '2024-01-13 07:33:36', 'shiyu', NULL, '18236362319', '876703634@qq.com', NULL, NULL, 0, NULL, '123456', NULL, 1, 1);

-- 导出  表 shiyu.shi_yu_user_role 结构
CREATE TABLE IF NOT EXISTS `shi_yu_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户角色关联ID',
  `create_time` timestamp NOT NULL DEFAULT (now()) COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT (now()) COMMENT '更新时间',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `del_status` smallint DEFAULT '1' COMMENT '0：删除  1：正常  ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1748592251326021636 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色关联';

-- 正在导出表  shiyu.shi_yu_user_role 的数据：~1 rows (大约)
INSERT INTO `shi_yu_user_role` (`id`, `create_time`, `update_time`, `user_id`, `role_id`, `del_status`) VALUES
	(1748592251326021634, '2024-01-20 06:24:55', '2024-01-20 06:24:55', 1, 1748543648091955202, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
