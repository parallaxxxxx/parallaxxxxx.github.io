DROP TABLE CHAT
CASCADE CONSTRAINTS;




CREATE TABLE CHAT (
	chatID NUMBER,
	fromID VARCHAR2(20),
	toID VARCHAR2(20),
	chatContent VARCHAR2(1000),
	chatTime DATE,
	CONSTRAINT PK_CHAT PRIMARY KEY (chatID)
);


CREATE SEQUENCE CHAT_SEQ
INCREMENT BY 1
START WITH 1;



SELECT *
FROM CHAT;


INSERT INTO CHAT
VALUES (CHAT_SEQ.NEXTVAL, 'bbb', 'trainer04', 'bbb가 4에게 222', SYSDATE)




SELECT * FROM CHAT
WHERE ((fromID = 'trainer04' AND toID = 'bbb') OR (fromID = 'bbb' AND toID = 'trainer04'))
ORDER BY chatTime




SELECT * FROM CHAT
WHERE ((fromID = 'trainer04' AND toID = 'bbb') OR (fromID = 'bbb' AND toID = 'trainer04'))
	AND chatID > (SELECT MAX(chatID) - 1 FROM CHAT)
ORDER BY chatTime





SELECT *
FROM CHAT
WHERE CHATTIME IN (SELECT MAX(CHATTIME) FROM CHAT WHERE toID = 'trainer04' GROUP BY FROMID)
ORDER BY CHATTIME DESC






AND chatID > (SELECT MAX(chatID) - 10 FROM CHAT)




