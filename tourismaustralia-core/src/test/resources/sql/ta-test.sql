CREATE TABLE favorite (
  id bigint NOT NULL IDENTITY,
  page varchar(255) DEFAULT NULL,
  userId varchar(255) DEFAULT NULL,
  sort int DEFAULT NULL
);

CREATE TABLE user_favorites (
  userId varchar(255) NOT NULL,
  shareId varchar(255) DEFAULT NULL
);

INSERT INTO user_favorites VALUES ('206563d4-34c3-4368-a586-31032416173f','713z63d4-34c3-4368-a586-310qpa16173f'),('730263d4-34c3-4218-z586-30371516173f','713z63d4-34c3-4368-a586-31193796173f');

INSERT INTO favorite VALUES 
	(null,'/content/australia/page1','206563d4-34c3-4368-a586-31032416173f',3), 
	(null,'/content/australia/page2','206563d4-34c3-4368-a586-31032416173f',0), 
	(null,'/content/australia/page3','206563d4-34c3-4368-a586-31032416173f',1), 
	(null,'/content/australia/page4','206563d4-34c3-4368-a586-31032416173f',2);
