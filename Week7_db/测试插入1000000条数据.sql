-- # 插入数据到订单表中，关闭自动提交，批量插入
DROP PROCEDURE IF EXISTS orders_initData;
DELIMITER $
CREATE PROCEDURE orders_initData()
BEGIN
    DECLARE i INT DEFAULT 0;
    set autocommit=0;
    WHILE i<=1000000 DO
			insert into `order` (id, user_id, total_price, created_on, updated_on)
			VALUES (UUID(), CEILING(rand()*100),10, now(), now());
        SET i = i+1;
    END WHILE;
    commit;
END $
CALL orders_initData();

-- # 插入数据到订单表中，自动提交，一条一条的插入
DROP PROCEDURE IF EXISTS orders_initData_one;
DELIMITER $
CREATE PROCEDURE orders_initData_one()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=1000000 DO
            insert into `order` (id, user_id, total_price, created_on, updated_on)
			VALUES (UUID(), CEILING(rand()*100),10, now(), now());
        SET i = i+1;
    END WHILE;
END $
CALL orders_initData_one();

-- # 批量插入 比 一条一条的插入速度快