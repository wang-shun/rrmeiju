-- 角色表
INSERT INTO role(role_id, role_name) VALUES(UPPER(REPLACE(UUID(), '-', '')), 'ADMIN');
INSERT INTO role(role_id, role_name) VALUES(UPPER(REPLACE(UUID(), '-', '')), 'USER');
-- 用户表
INSERT INTO user(user_id, user_name, password, mobile_number)
VALUES(UPPER(REPLACE(UUID(), '-', '')), 'caizhukui', MD5('123456'), '13626270072');
-- 用户角色关联表
INSERT INTO user_role(user_id, role_id) VALUES('447758059F2911E6ACE500163E0521C8', 'DCC65BFA9F2811E6ACE500163E0521C8');
INSERT INTO user_role(user_id, role_id) VALUES('447758059F2911E6ACE500163E0521C8', 'DCCBC62E9F2811E6ACE500163E0521C8');