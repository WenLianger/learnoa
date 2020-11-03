USE oasql;



DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) NOT NULL COMMENT '父菜单ID。一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `permission` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权标识。多个用逗号分隔，如：user:list,user:create',
  `type` tinyint(2) NULL DEFAULT NULL COMMENT '类型。0：目录；1：菜单；2：按钮；3：导航菜单',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `status` tinyint(2) NOT NULL DEFAULT 0 COMMENT '状态。0：正常；1：禁用',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序值。越小越靠前',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Compact;


-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, '', 0, 'fa fa-cogs', 0, 0, NULL, '2019-05-06 21:46:33');
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 'sys/user/index', 'sys:user:index', 1, NULL, 0, 0, NULL, '2019-05-06 21:46:47');
INSERT INTO `sys_menu` VALUES (3, 1, '菜单管理', 'sys/menu/index', 'sys:menu:index', 1, NULL, 0, 2, NULL, '2019-05-11 11:50:57');
INSERT INTO `sys_menu` VALUES (4, 1, '角色管理', 'sys/role/index', 'sys:role:index', 1, NULL, 0, 3, NULL, '2019-05-11 11:51:31');
INSERT INTO `sys_menu` VALUES (5, 1, '部门管理', 'sys/dept/index', 'sys:dept:index', 1, NULL, 0, 1, NULL, '2019-05-11 11:51:58');
INSERT INTO `sys_menu` VALUES (7, 0, '系统审计', NULL, '', 0, 'fa fa-industry', 0, 1, NULL, '2019-05-11 12:04:09');
INSERT INTO `sys_menu` VALUES (9, 7, '操作日志', 'sys/log/index', 'sys:log:index', 1, NULL, 0, 0, NULL, '2019-05-11 13:26:02');
INSERT INTO `sys_menu` VALUES (10, 2, '添加', NULL, 'sys:user:add', 2, NULL, 0, 0, NULL, '2019-05-07 21:25:46');
INSERT INTO `sys_menu` VALUES (11, 2, '删除', NULL, 'sys:user:del', 2, NULL, 0, 2, NULL, '2019-05-11 14:26:54');
INSERT INTO `sys_menu` VALUES (12, 2, '编辑', NULL, 'sys:user:edit', 2, NULL, 0, 1, NULL, '2019-05-11 14:28:06');
INSERT INTO `sys_menu` VALUES (13, 3, '添加', NULL, 'sys:menu:add', 2, NULL, 0, 0, NULL, '2019-05-11 14:28:59');
INSERT INTO `sys_menu` VALUES (14, 3, '编辑', NULL, 'sys:menu:edit', 2, NULL, 0, 1, NULL, '2019-05-11 14:29:35');
INSERT INTO `sys_menu` VALUES (15, 3, '删除', NULL, 'sys:menu:del', 2, NULL, 0, 2, NULL, '2019-05-11 14:29:55');
INSERT INTO `sys_menu` VALUES (16, 4, '添加', NULL, 'sys:role:add', 2, NULL, 0, 0, NULL, '2019-05-11 14:30:07');
INSERT INTO `sys_menu` VALUES (17, 4, '编辑', NULL, 'sys:role:edit', 2, NULL, 0, 1, NULL, '2019-05-11 14:30:28');
INSERT INTO `sys_menu` VALUES (18, 4, '删除', NULL, 'sys:role:del', 2, NULL, 0, 2, NULL, '2019-05-11 14:30:37');
INSERT INTO `sys_menu` VALUES (19, 4, '权限设置', NULL, 'sys:role:permission', 2, NULL, 0, 3, NULL, '2019-05-11 14:30:37');
INSERT INTO `sys_menu` VALUES (20, 5, '添加', NULL, 'sys:dept:add', 2, NULL, 0, 0, NULL, '2019-05-11 14:30:47');
INSERT INTO `sys_menu` VALUES (21, 5, '编辑', NULL, 'sys:dept:edit', 2, NULL, 0, 1, NULL, '2019-05-11 14:30:58');
INSERT INTO `sys_menu` VALUES (22, 5, '删除', NULL, 'sys:dept:del', 2, NULL, 0, 2, NULL, '2019-05-11 14:31:13');
INSERT INTO `sys_menu` VALUES (23, 2, '重置密码', NULL, 'sys:user:reset', 2, NULL, 0, 3, NULL, '2019-05-12 18:01:10');
INSERT INTO `sys_menu` VALUES (24, 0, 'Druid监控', 'druid/index.html', NULL, 3, 'fa fa-eye', 0, 0, NULL, '2019-05-20 22:43:09');
INSERT INTO `sys_menu` VALUES (25, 0, '代码生成', '', NULL, 0, 'fa fa-bolt', 0, 2, NULL, '2019-06-10 22:47:31');
INSERT INTO `sys_menu` VALUES (26, 25, '生成管理', 'generator/table/index', 'gen:table:index', 1, NULL, 0, 0, NULL, '2019-06-10 22:50:09');
INSERT INTO `sys_menu` VALUES (27, 1, '字典管理', 'sys/dict/index', 'sys:dict:index', 1, NULL, 0, 4, NULL, '2019-08-12 09:47:31');
INSERT INTO `sys_menu` VALUES (28, 27, '添加', NULL, 'sys:dict:add', 2, NULL, 0, 0, NULL, '2019-08-12 09:48:03');
INSERT INTO `sys_menu` VALUES (29, 27, '编辑', NULL, 'sys:dict:edit', 2, NULL, 0, 0, NULL, '2019-08-12 09:48:20');
INSERT INTO `sys_menu` VALUES (30, 27, '删除', NULL, 'sys:dict:del', 2, NULL, 0, 0, NULL, '2019-08-12 09:48:45');
INSERT INTO `sys_menu` VALUES (31, 1, '定时任务', 'schedule/job/index', 'schedule:job:index', 1, NULL, 0, 5, NULL, '2019-08-17 18:13:22');
INSERT INTO `sys_menu` VALUES (32, 31, '添加', NULL, 'schedule:job:add', 2, NULL, 0, 0, NULL, '2019-08-17 18:14:20');
INSERT INTO `sys_menu` VALUES (33, 31, '编辑', NULL, 'schedule:job:edit', 2, NULL, 0, 0, NULL, '2019-08-17 18:14:36');
INSERT INTO `sys_menu` VALUES (34, 31, '删除', NULL, 'schedule:job:del', 2, NULL, 0, 0, NULL, '2019-08-17 18:14:55');
INSERT INTO `sys_menu` VALUES (35, 31, '暂停', NULL, 'schedule:job:pause', 2, NULL, 0, 0, NULL, '2019-08-17 18:16:10');
INSERT INTO `sys_menu` VALUES (36, 31, '恢复', NULL, 'schedule:job:resume', 2, NULL, 0, 0, NULL, '2019-08-17 18:16:28');
INSERT INTO `sys_menu` VALUES (37, 0, '组件管理', NULL, NULL, 0, 'fa fa-th-large', 0, 3, NULL, '2020-03-31 11:14:02');
INSERT INTO `sys_menu` VALUES (38, 37, '富文本', 'sys/component/ueditor/index', 'component:ueditor:index', 1, NULL, 0, 1, NULL, '2020-03-31 11:17:55');
INSERT INTO `sys_menu` VALUES (39, 37, '图标库', 'sys/component/icons/index', 'component:icons:index', 1, NULL, 0, 0, NULL, '2020-03-31 11:22:09');


DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Compact;


-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 3, 7);
INSERT INTO `sys_role_menu` VALUES (2, 3, 9);
INSERT INTO `sys_role_menu` VALUES (3, 3, 1);
INSERT INTO `sys_role_menu` VALUES (4, 3, 2);
INSERT INTO `sys_role_menu` VALUES (5, 3, 10);
INSERT INTO `sys_role_menu` VALUES (6, 3, 12);
INSERT INTO `sys_role_menu` VALUES (7, 3, 11);
INSERT INTO `sys_role_menu` VALUES (8, 3, 23);
INSERT INTO `sys_role_menu` VALUES (9, 3, 5);
INSERT INTO `sys_role_menu` VALUES (10, 3, 20);
INSERT INTO `sys_role_menu` VALUES (11, 3, 21);
INSERT INTO `sys_role_menu` VALUES (12, 3, 22);
INSERT INTO `sys_role_menu` VALUES (13, 3, 3);
INSERT INTO `sys_role_menu` VALUES (14, 3, 13);
INSERT INTO `sys_role_menu` VALUES (15, 3, 14);
INSERT INTO `sys_role_menu` VALUES (16, 3, 15);
INSERT INTO `sys_role_menu` VALUES (17, 3, 4);
INSERT INTO `sys_role_menu` VALUES (18, 3, 16);
INSERT INTO `sys_role_menu` VALUES (19, 3, 17);
INSERT INTO `sys_role_menu` VALUES (20, 3, 18);
INSERT INTO `sys_role_menu` VALUES (21, 3, 19);
INSERT INTO `sys_role_menu` VALUES (22, 3, 24);
INSERT INTO `sys_role_menu` VALUES (23, 3, 25);
INSERT INTO `sys_role_menu` VALUES (24, 3, 26);
INSERT INTO `sys_role_menu` VALUES (25, 5, 1);
INSERT INTO `sys_role_menu` VALUES (26, 5, 2);
INSERT INTO `sys_role_menu` VALUES (27, 5, 5);
INSERT INTO `sys_role_menu` VALUES (28, 5, 3);
INSERT INTO `sys_role_menu` VALUES (29, 5, 4);
INSERT INTO `sys_role_menu` VALUES (30, 5, 7);
INSERT INTO `sys_role_menu` VALUES (31, 5, 25);
INSERT INTO `sys_role_menu` VALUES (32, 5, 26);
INSERT INTO `sys_role_menu` VALUES (33, 5, 24);
INSERT INTO `sys_role_menu` VALUES (34, 3, 27);
INSERT INTO `sys_role_menu` VALUES (35, 3, 30);
INSERT INTO `sys_role_menu` VALUES (36, 3, 28);
INSERT INTO `sys_role_menu` VALUES (37, 3, 29);
INSERT INTO `sys_role_menu` VALUES (38, 3, 31);
INSERT INTO `sys_role_menu` VALUES (39, 3, 32);
INSERT INTO `sys_role_menu` VALUES (40, 3, 33);
INSERT INTO `sys_role_menu` VALUES (41, 3, 34);
INSERT INTO `sys_role_menu` VALUES (42, 3, 35);
INSERT INTO `sys_role_menu` VALUES (43, 3, 36);
INSERT INTO `sys_role_menu` VALUES (44, 4, 7);
INSERT INTO `sys_role_menu` VALUES (45, 4, 9);
INSERT INTO `sys_role_menu` VALUES (46, 3, 37);
INSERT INTO `sys_role_menu` VALUES (47, 3, 39);
INSERT INTO `sys_role_menu` VALUES (48, 3, 38);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 3, '2019-05-09 22:06:16');
INSERT INTO `sys_user_role` VALUES (2, 2, 5, '2019-05-10 21:25:08');
INSERT INTO `sys_user_role` VALUES (3, 3, 4, '2019-05-10 21:25:08');

SELECT * FROM user;
INSERT INTO `user` VALUES (3,'test','123456','admin');
