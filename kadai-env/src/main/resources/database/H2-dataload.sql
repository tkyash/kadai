/* load the records. */
insert into t_user values('0001','apple','1991-1-1','東京都江東区豊洲四丁目1-1','0312345678','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','ACTV','2015-06-02 14:29:00');
insert into t_user values('0002','orange','1992-2-2','東京都中央区月島一丁目3-9','0387654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','INIT','2015-06-03 14:29:00');
insert into t_user values('0003','banana','1993-3-3','東京都中央区築地一丁目1-1','09012345678','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','DELETE','2015-06-04 14:29:00');
insert into t_user values('0004','peach','1994-4-4','東京都中央区銀座一丁目7-12','09087654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','ACTV','2015-06-05 14:29:00');
insert into t_user values('0005','pineapple','1995-5-5','東京都千代田区有楽町一丁目11-1','08012345678','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','ACTV','2015-06-06 14:29:00');
insert into t_user values('0006','pear','1996-6-6','東京都千代田区霞が関二丁目1-1','08087654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK','ACTV','2015-06-07 14:29:00');

insert into t_role values('0001','ADMN');
insert into t_role values('0001','USER');
insert into t_role values('0002','USER');
insert into t_role values('0003','USER');
insert into t_role values('0004','USER');
insert into t_role values('0005','USER');
insert into t_role values('0006','USER');

commit;
