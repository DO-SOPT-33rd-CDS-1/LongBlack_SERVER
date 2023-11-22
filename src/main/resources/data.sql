DROP TABLE IF EXISTS PARAGRAPH;
DROP TABLE IF EXISTS BOOKMARK;
DROP TABLE IF EXISTS POST;

CREATE TABLE BOOKMARK (
    bookmark_id  BIGINT     NOT NULL AUTO_INCREMENT,
    bookmark_idx BIGINT,
    PRIMARY KEY (bookmark_id)
);

CREATE TABLE PARAGRAPH (
    paragraph_id    BIGINT  NOT NULL AUTO_INCREMENT,
    content         VARCHAR(255)    NOT NULL,
    paragraph_type  VARCHAR(255)    NOT NULL,
    PRIMARY KEY (paragraph_id)
);

CREATE TABLE POST (
    post_id      BIGINT          NOT NULL AUTO_INCREMENT,
    title        VARCHAR(255)    NOT NULL,
    hexacode     VARCHAR(50)     NOT NULL,
    writer       VARCHAR(255)    NOT NULL,
    created_date DATE            NOT NULL,
    post_type    VARCHAR(1)      NOT NULL,
    PRIMARY KEY (post_id)
);


INSERT INTO POST (title, hexacode, writer, created_date, post_type) VALUES
  ('오픈갤러리 : 내 거실이 갤러리, 미술 시장의 빈틈을 파고든 원화 구독 서비스', '#FF5126', '박희정', '2023-11-09', 'B'),
  ('무스토이 : OMG와 슈퍼해피 정신으로, 아마존 1위 장난감이 되다', '#A3F4A5', '방민지', '2023-02-15', 'L'),
  ('애시드 리그 : 커피·고수·김치맛 식초, 4000개의 슈퍼마켓 매대를 꿰차다', '#A4F4A3', '손명지', '2023-03-30', 'B'),
  ('조병수 : 10년 뒤 서울엔 산과 강, 바람이 있을까 건축가가 묻다', '#5A61FF', '신민철', '2023-11-12', 'C'),
  ('코오롱스포츠 : 연 8000억 매출의 50년 아웃도어 브랜드, 오리진을 ···', '#5962FF', '이연진', '2023-11-12', 'K'),
  ('First, Learn to practice : 조금 더 계속하는 바로 그 순간', '#DEC197', '이우제', '2023-11-12', 'K'),
  ('엄커피 : 아버지가 브라질에 뿌린 커피콩, 아들을 바리스타 챔피언으로 ···', '#FF5126', '이준희', '2023-11-12', 'K'),
  ('아루히 : 손님과의 케미스트리로, ‘스강신청’ 오마카세 집이 되다', '#5962FF', '정채은', '2023-11-12', 'K');
