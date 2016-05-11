CREATE TABLE user
(
    userSysId INT(11) NOT NULL,
    userId VARCHAR(50) NOT NULL,
    userEmail VARCHAR(200) NOT NULL,
    userPassword VARCHAR(200) NOT NULL,
    version INT(11),
    userStatus VARCHAR(25) NOT NULL,
    createOp VARCHAR(50) NOT NULL,
    updateOp VARCHAR(50) NOT NULL,
    userName VARCHAR(200) NOT NULL,
    userRemark VARCHAR(2000)
);
CREATE TABLE pro
(
    userId MEDIUMTEXT,
    jsonString TEXT,
    dataTime DATE,
    flag BIGINT(20) DEFAULT '0'
);

INSERT INTO user (userSysId, userId, userEmail, userPassword, version, userStatus, createOp, updateOp, userName, userRemark)
VALUES (1, '1', '1', '1', 1, '1', '1', '1', '1', '1');
INSERT INTO pro (userId, jsonString, dataTime, flag)
VALUES ('40659310', '{"tid":"1347680858916965","pay_date":"2016-04-21 09:05:54","consign_date":"2016-04-21 17:40:30","row":2,"orders":[{"total_fee":"89.90","num_iid":"PG1406770300","num":"1"},{"total_fee":"79.90","num_iid":"PG1600050302","num":"1"}]}', '2016-04-22', 0);

