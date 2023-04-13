INSERT INTO fitness.role(role) VALUES ('ADMIN');
INSERT INTO fitness.role(role) VALUES ('USER');

INSERT INTO fitness.status(status) VALUES ('ACTIVATED');
INSERT INTO fitness.status(status) VALUES ('DEACTIVATED');
INSERT INTO fitness.status(status) VALUES ('WAITING_ACTIVATION');

 INSERT INTO fitness.users
     VALUES ('70dd7919-705d-46bb-ba0b-c7cee7f68b62',
     'qwer',
     now(),
     now(),
     'ADMIN',
     'vit-s-v79@mail.ru',
     'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmaW8iOiJBRE1JTiIsIm1haWwiOiJ2aXQtcy12NzlAbWFpbC5ydSIsInN0YXR1cyI6IkFDVElWQVRFRCJ9.RZPPctOA4XsHzIaRSgb4o6KTGHq62njiJWQma1mCOFY',
     1,
     1)

INSERT INTO fitness.users
     VALUES ('1dc6fde7-5040-48f3-a384-4548400b35fb',
     'asdf',
     now(),
     now(),
     'USER',
     'vitaliysokolov1@gmail.com',
     'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmaW8iOiJVU0VSIiwibWFpbCI6InZpdGFsaXlzb2tvbG92MUBnbWFpbC5jb20iLCJzdGF0dXMiOiJXQUlUSU5HX0FDVElWQVRJT04ifQ.sLhtn12J1kE2iLVZS9YIQ93VLOXNsTgsIZPfge2CD3M',
     2,
     3)

INSERT INTO fitness.users_role
     VALUES ('70dd7919-705d-46bb-ba0b-c7cee7f68b62', 1)

INSERT INTO fitness.users_role
     VALUES ('1dc6fde7-5040-48f3-a384-4548400b35fb', 2)

INSERT INTO fitness.users_status
     VALUES ('70dd7919-705d-46bb-ba0b-c7cee7f68b62', 2)

INSERT INTO fitness.users_status
     VALUES ('1dc6fde7-5040-48f3-a384-4548400b35fb', 3)