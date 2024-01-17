insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('ssar@nate.com','최죠','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01011112222','1986-05-22', now(), 1);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('cos@nate.com','그노','1111','01022223333','2024-01-17', now(), 2);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('love@nate.com','채비니','1111','01050186937','2024-01-17', now(), 3);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('heidi@nate.com','기마얀','1111','01044541176','1986-01-11', now(), 4);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('smk@nate.com','민경','1111','01063947520','1986-01-11', now(), 5);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('pnk@nate.com','남뀨','1111','01065423114','1986-05-22', now(), 6);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('lej@nate.com','은지','1111','01065413987','1986-05-22', now(), 7);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('pumpkin@nate.com','나무네','1111','01090153141','1986-05-22', now(), 8);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('home@nate.com','집에가고싶다','1111','01047870123','1986-05-22', now(), 9);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('red@nate.com','학원가고싶다','1111','01015208950','2024-01-16', now(), 10);


insert into friend_tb(`user_id1`, `user_id2`, is_favofite) values ('1','3', true);
insert into friend_tb(`user_id1`, `user_id2`, is_favofite) values ('1','2', true);
insert into friend_tb(`user_id1`, `user_id2`, is_favofite) values ('1','4', true);
insert into friend_tb(`user_id1`, `user_id2`, is_favofite) values ('1','5', false);
insert into friend_tb(`user_id1`, `user_id2`, is_favofite) values ('1','9', false);
insert into friend_tb(`user_id1`, `user_id2`, is_favofite) values ('1','10', false);


insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(1, '이미지1', '안녕', '배경이미지1', '1234');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(2, '이미지2', '윤채빈 남은혜 이력서 빨리 써라', '배경이미지2', '2345');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(3, '이미지3', '집에 가고 싶다', '배경이미지3', '6547');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(4, '이미지4', '그만 하고 싶어요.........', '배경이미지4', '9822');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(5, '이미지5', '흐흐', '배경이미지5', '0021');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(6, '이미지6', '먼데', '배경이미지6', '5612');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(7, '이미지7', '키야', '배경이미지7', '7513');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(8, '이미지8', '창원 가고 싶다', '배경이미지8', '1235');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(9, '이미지9', '힝힝', '배경이미지9', '7852');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(10, '이미지10', '응응', '배경이미지10', '6540');