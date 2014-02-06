package config;import java.sql.Connection;import java.sql.Statement;import com.jfinal.plugin.c3p0.C3p0Plugin;public class DataInitUtil {	public static void init(C3p0Plugin cp) {		try {			cp.start();			Connection conn = cp.getDataSource().getConnection();			Statement stmt = conn.createStatement();			// 登陆及授权的3个表			stmt.executeUpdate("create table if not exists user_login(id bigint auto_increment PRIMARY KEY, user_name VARCHAR(50) not null, password VARCHAR(50) not null, password_hint VARCHAR(255));");			stmt.executeUpdate("create table if not exists user_roles(id bigint auto_increment PRIMARY KEY, user_name VARCHAR(50) not null, role_name VARCHAR(255) not null, remark VARCHAR(255));");			stmt.executeUpdate("create table if not exists role_permissions(id bigint auto_increment PRIMARY KEY, role_name VARCHAR(50) not null, role_permission VARCHAR(50), remark VARCHAR(255));");			stmt.executeUpdate("insert into user_login(user_name, password, password_hint) values('d_user2', '123456', '1-6');");			stmt.executeUpdate("create table if not exists leads(id bigint auto_increment PRIMARY KEY, "			        + "title VARCHAR(255), priority varchar(50), create_date TIMESTAMP, creator varchar(50), status varchar(50),"			        + "type varchar(50), region varchar(50), addr varchar(256), "			        + "intro varchar(5120), remark VARCHAR(5120), lowest_price DECIMAL(20, 2), agent_fee DECIMAL(20, 2), "			        + "introducer varchar(256), sales varchar(256), follower varchar(50), follower_phone varchar(50),"			        + "owner varchar(50), owner_phone varchar(50), area decimal(10,2), total decimal(10,2), customer_source varchar(50), building_name varchar(255), building_no varchar(50), room_no varchar(50) );");			// alter table leads add(priority varchar(50),customer_source			// varchar(50), building_name varchar(255), building_no varchar(50),			// room_no varchar(50)); 2-6			stmt.executeUpdate("create table if not exists support_case(id bigint auto_increment PRIMARY KEY, title VARCHAR(255), type varchar(50), create_date TIMESTAMP, creator varchar(50), status varchar(50), case_desc VARCHAR(5120), note VARCHAR(5120));");			String propertySql = "insert into leads(title, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, customer_source, building_name, building_no, room_no) values("			        + "'%d 初始测试数据-老香洲两盘', CURRENT_TIMESTAMP(), 'jason', '出租', " + "'1房', '老香洲', "			        + "'本月均价8260元/㎡，环比上月 ↑0.22 ，同比去年 ↑14.67 ，查看房价详情>>二 手 房50 套 所在区域香洲 老香洲小区地址香洲珠海市香洲区老香洲为农街为农市场地图>>建筑年代1995-01-01',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'jason', '13509871234',"			        + "'张生', '0756-12345678-123', '58自来客', '五洲花城2期', '2', '1320');";			// for (int i = 0; i < 50; i++) {			// String newPropertySql = String.format(propertySql, i);			// stmt.executeUpdate(newPropertySql);			// }			stmt.executeUpdate("insert into leads(title, priority, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, area, total, customer_source, building_name, building_no, room_no) values("			        + "'初始测试数据-老香洲楼盘', '1重要紧急', CURRENT_TIMESTAMP(), 'jason', '出租', " + "'1房', '老香洲', " + "'老香洲楼盘 2房2卫',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'jason', '13509871234',"			        + "'张生', '0756-12345678-123', 36, 1200, '58自来客', '五洲花城2期', '2', '1320');");			stmt.executeUpdate("insert into leads(title, priority, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, area, total, customer_source, building_name, building_no, room_no) values("			        + "'初始测试数据-新香洲楼盘', '1重要紧急', CURRENT_TIMESTAMP(), 'jason', '出售', " + "'2房', '新香洲', " + "'新香洲楼盘 2房2卫',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'jason', '13509871234',"			        + "'张生', '0756-12345678-123', 78, 56, '58自来客', '五洲花城2期', '2', '1320');");			stmt.executeUpdate("insert into leads(title, priority, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, area, total, customer_source, building_name, building_no, room_no) values("			        + "'初始测试数据-老香洲楼盘', '2重要不紧急', CURRENT_TIMESTAMP(), 'jason', '已租', " + "'3房', '老香洲', "			        + "'本月均价8260元/㎡，环比上月 ↑0.22 ，同比去年 ↑14.67 ，查看房价详情>>二 手 房50 套 所在区域香洲 老香洲小区地址香洲珠海市香洲区老香洲为农街为农市场地图>>建筑年代1995-01-01',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'jason', '13509871234',"			        + "'张生', '0756-12345678-123', 92, 2300, '58自来客', '五洲花城2期', '2', '1320');");			stmt.executeUpdate("insert into leads(title, priority, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, area, total, customer_source, building_name, building_no, room_no) values("			        + "'初始测试数据-拱北楼盘', '2重要不紧急', CURRENT_TIMESTAMP(), 'jason', '已售', " + "'4房', '拱北', "			        + "'本月均价8260元/㎡，环比上月 ↑0.22 ，同比去年 ↑14.67 ，查看房价详情>>二 手 房50 套 所在区域香洲 老香洲小区地址香洲珠海市香洲区老香洲为农街为农市场地图>>建筑年代1995-01-01',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'jason', '13509871234',"			        + "'张生', '0756-12345678-123', 150, 120, '58自来客', '五洲花城2期', '2', '1320');");			stmt.executeUpdate("insert into leads(title, priority, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, area, total, customer_source, building_name, building_no, room_no) values("			        + "'初始测试数据-柠溪楼盘', '3不重要紧急', CURRENT_TIMESTAMP(), 'jason', '出租', " + "'5房', '柠溪', "			        + "'本月均价8260元/㎡，环比上月 ↑0.22 ，同比去年 ↑14.67 ，查看房价详情>>二 手 房50 套 所在区域香洲 老香洲小区地址香洲珠海市香洲区老香洲为农街为农市场地图>>建筑年代1995-01-01',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'jason', '13509871234',"			        + "'张生', '0756-12345678-123', 180, 5000, '58自来客', '五洲花城2期', '2', '1320');");			stmt.executeUpdate("insert into leads(title, priority, create_date, creator, status, type, "			        + "region, intro, remark, lowest_price, agent_fee, introducer, sales, follower, follower_phone, owner, owner_phone, area, total, "			        + "customer_source, building_name, building_no, room_no) values("			        + "'初始测试数据-前山地皮', '4不重要不紧急', CURRENT_TIMESTAMP(), 'd_user1', '已售', " + "'地皮', '前山', "			        + "'本月均价8260元/㎡，环比上月 ↑0.22 ，同比去年 ↑14.67 ，查看房价详情>>二 手 房50 套 所在区域香洲 老香洲小区地址香洲珠海市香洲区老香洲为农街为农市场地图>>建筑年代1995-01-01',"			        + "'remark.....', 7000, 7500, " + "'介绍人金', 'kim', 'd_user1', '13509871234',"			        + "'张生', '0756-12345678-123', 40000, 3000, '58自来客', '五洲花城2期', '2', '1320');");			stmt.executeUpdate("insert into support_case(title, create_date, creator, status, type, case_desc, note) values("			        + "'这是一个建议示例', CURRENT_TIMESTAMP(), 'jason', '新提交','出错', '这是一个建议示例，您可以在这里提交你所遇到的问题，我们会尽快跟进。', '这是回答的地方');");			stmt.executeUpdate("create table if not exists order_header(id bigint auto_increment PRIMARY KEY, order_no VARCHAR(50) not null, type varchar(50), status varchar(50), creator VARCHAR(50), create_date TIMESTAMP, remark varchar(256));");			stmt.executeUpdate("create table if not exists order_item(id bigint auto_increment PRIMARY KEY, order_id bigint, item_name VARCHAR(50), item_desc VARCHAR(50), quantity decimal(10,2), unit_price decimal(10,2), status varchar(50), FOREIGN KEY(order_id) REFERENCES order_header(id) );");			stmt.executeUpdate("insert into order_header(order_no, type, status, creator, create_date,  remark) values("			        + "'SalesOrder001', 'SALES_ORDER', 'New', 'jason', CURRENT_TIMESTAMP(), '这是一个销售订单示例');");			stmt.executeUpdate("insert into order_item(order_id, item_name, item_desc, quantity, unit_price) values("			        + "1, 'P001', 'iPad Air', 1, 3200);");			stmt.close();			// conn.commit();			conn.close();		} catch (Exception e) {			e.printStackTrace();		}	}}