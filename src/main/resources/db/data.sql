insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('ssar@nate.com','최죠','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01011112222','1986-05-22', now(), 1);

insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('cos@nate.com','그노','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01022223333','2024-01-21', now(), 2);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('love@nate.com','채비니','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01050186937','2024-01-21', now(), 3);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('heidi@nate.com','기마얀','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01044541176','1986-01-21', now(), 4);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('smk@nate.com','민경','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01063947520','1986-01-11', now(), 5);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('pnk@nate.com','남뀨','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01065423114','1986-05-22', now(), 6);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('lej@nate.com','은지','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01065413987','1986-05-22', now(), 7);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('pumpkin@nate.com','나무네','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01090153141','1986-05-22', now(), 8);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('home@nate.com','집에가고싶다','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01047870123','1986-05-22', now(), 9);
insert into user_tb(`email`,`nickname`,`password`, `phone_num`, `birthdate`, `created_at`, `profile_id`)values('red@nate.com','학원가고싶다','$2a$12$gVcNmoob10Ru9ZGiskuhS.pfL4lcLwoEXLT7SMsylgDyt.JI3XomK','01015208950','2024-01-16', now(), 10);


insert into friend_tb(`user_id1`, `user_id2`) values ('1','3');
insert into friend_tb(`user_id1`, `user_id2`) values ('1','2');
insert into friend_tb(`user_id1`, `user_id2`) values ('1','4');
insert into friend_tb(`user_id1`, `user_id2`) values ('1','5');
insert into friend_tb(`user_id1`, `user_id2`) values ('1','9');
insert into friend_tb(`user_id1`, `user_id2`) values ('1','10');
insert into friend_tb(`user_id1`, `user_id2`) values ('2','3');
insert into friend_tb(`user_id1`, `user_id2`) values ('2','10');
insert into friend_tb(`user_id1`, `user_id2`) values ('2','9');
insert into friend_tb(`user_id1`, `user_id2`) values ('2','5');
insert into friend_tb(`user_id1`, `user_id2`) values ('2','4');
insert into friend_tb(`user_id1`, `user_id2`) values ('3','7');
insert into friend_tb(`user_id1`, `user_id2`) values ('3','6');
insert into friend_tb(`user_id1`, `user_id2`) values ('3','9');
insert into friend_tb(`user_id1`, `user_id2`) values ('3','10');
insert into friend_tb(`user_id1`, `user_id2`) values ('4','9');
insert into friend_tb(`user_id1`, `user_id2`) values ('4','7');
insert into friend_tb(`user_id1`, `user_id2`) values ('4','8');
insert into friend_tb(`user_id1`, `user_id2`) values ('4','10');


insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(1, '1', '안녕', '배경이미지1', '1234');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(2, '2', '윤채빈 남은혜 이력서 빨리 써라', '배경이미지2', '2345');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(3, '3', '집에 가고 싶다', '배경이미지3', '6547');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(4, '4', '그만 하고 싶어요.........', '배경이미지4', '9822');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(5, '5', '흐흐', '배경이미지5', '0021');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(6, '6', '먼데', '배경이미지6', '5612');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(7, '7', '키야', '배경이미지7', '7513');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(8, '8', '창원 가고 싶다', '배경이미지8', '1235');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(9, '9', '힝힝', '배경이미지9', '7852');
insert into profile_tb(user_id, profile_image, status_message, back_image, qr_code)
values(10, '10', '응응', '배경이미지10', '6540');