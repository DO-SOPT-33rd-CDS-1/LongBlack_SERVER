DROP TABLE IF EXISTS BOOKMARK;
DROP TABLE IF EXISTS LIKEY;
DROP TABLE IF EXISTS STAMP;
DROP TABLE IF EXISTS PARAGRAPH;
DROP TABLE IF EXISTS POST;

CREATE TABLE POST (
    post_id        BIGINT          NOT NULL   AUTO_INCREMENT  PRIMARY KEY,
    title          VARCHAR(255)    NOT NULL,
    hexacode       VARCHAR(50)     NOT NULL,
    writer         VARCHAR(255)    NOT NULL,
    created_date    DATE            NOT NULL,
    post_type      VARCHAR(1)      NOT NULL
);

CREATE TABLE PARAGRAPH (
    paragraph_id    BIGINT          NOT NULL   AUTO_INCREMENT  PRIMARY KEY,
    content         VARCHAR(255)    NOT NULL,
    paragraph_type  VARCHAR(255)    NOT NULL,
    post_id         BIGINT,
    FOREIGN KEY (post_id) REFERENCES POST(post_id)
);

CREATE TABLE BOOKMARK (
    bookmark_id     BIGINT   NOT NULL AUTO_INCREMENT   PRIMARY KEY,
    bookmark_idx    INT,
    post_id         BIGINT,
    FOREIGN KEY (post_id)  REFERENCES POST(post_id)
);

CREATE TABLE LIKEY (
    likey_id   BIGINT NOT NULL AUTO_INCREMENT   PRIMARY KEY,
    post_id    BIGINT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES POST(post_id)
);

CREATE TABLE STAMP (
    stamp_id   BIGINT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
    post_id    BIGINT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES POST(post_id)
);


INSERT INTO POST (title, hexacode, writer, created_date, post_type) VALUES
  ('오픈갤러리 : 내 거실이 갤러리, 미술 시장의 빈틈을 파고든 원화 구독 서비스', '#FF5126', '박희정', '2023-11-09', 'B'),
  ('무스토이 : OMG와 슈퍼해피 정신으로, 아마존 1위 장난감이 되다', '#A3F4A5', '방민지', '2023-02-15', 'L'),
  ('애시드 리그 : 커피·고수·김치맛 식초, 4000개의 슈퍼마켓 매대를 꿰차다', '#A4F4A3', '손명지', '2023-03-30', 'B'),
  ('조병수 : 10년 뒤 서울엔 산과 강, 바람이 있을까 건축가가 묻다', '#5A61FF', '신민철', '2023-11-12', 'C'),
  ('코오롱스포츠 : 연 8000억 매출의 50년 아웃도어 브랜드, 오리진을 말하다', '#5962FF', '이연진', '2023-11-12', 'K'),
  ('First, Learn to practice : 조금 더 계속하는 바로 그 순간', '#DEC197', '이우제', '2023-11-12', 'K'),
  ('엄커피 : 아버지가 브라질에 뿌린 커피콩, 아들을 바리스타 챔피언으로 만들다', '#FF5126', '이준희', '2023-11-12', 'K'),
  ('아루히 : 손님과의 케미스트리로, ‘스강신청’ 오마카세 집이 되다', '#5962FF', '정채은', '2023-11-12', 'K');


INSERT INTO PARAGRAPH(content, paragraph_type, post_id) VALUES
   ('롱블랙 프렌즈 L', 'SUBHEADING', 1),
   ('얼마 전 B네 집에 놀러갔는데, 거실에 못 보던 그림이 걸려있더라. 물감 결이 살아있는 걸 보니 원화였어.', 'TEXT', 1),
   ('내가 프리즈 서울에 다녀와 봐서 알잖아. 그림이 좀 비싼 게 아니란 거. 계속 들여다보고 있으니까, B가 말해주더라. 그림 구독 서비스를 이용 중이래. 회사 이름은 오픈갤러리.', 'TEXT', 1),
   ('원화를 구독한다니. 처음 듣는 비즈니스 모델이잖아? 그냥 넘어갈 수 없지. 박의규 오픈갤러리 대표를 만나 속속들이 물어봤어.', 'TEXT', 1),
   ('Chapter 1.', 'SUBHEADING', 1),
   ('5만3000점의 그림으로 취향을 알려주다', 'SUBHEADING', 1),
   ('오픈갤러리가 보유한 그림은 5만 3000여 점에 달해. 어떤 그림이 있냐고?', 'TEXT', 1),
   ('홈페이지에 들어갔더니, 가을에 어울리는 큐레이션 코너가 있네. 푸른 하늘을 배경으로 흩날리는 단풍잎들, 그리고 캔버스를 가로지르는 리본. 그 끝에 묶여 있는 편지 한 통. 거실에 앉아 그림만 봐도 ‘가을이 왔구나’싶을 것 같아. 한지의 한 종류인 장지에 그린 거래. 그냥 수채화인줄 알았는데, 실물로 보면 느낌이 좀 다르겠는데?', 'TEXT', 1),
   ('다른 그림도 볼까? ‘작품 보기’ 메뉴에 들어가면, 오픈갤러리가 보유한 모든 그림을 볼 수 있어. 노출 순서는 랜덤. 인기순이나 조회순 정렬이 아닌 게 인상적이야. 남의 취향을 따라가지 말란 건가?', 'TEXT', 1),
   ('기분 전환하는 덴 풍경화가 딱이지. 그림 하나가 눈에 띄었어. 울창한 고목 여섯 그루에 연두색, 초록색 잎이 가득해. 따사로운 햇빛을 받으며 서있지. 그 아래 펼쳐진 넓은 들판. 라벤더가 한가득 흐드러지게 피었어. 작품 이름은 「성밖숲」. 그림 밑에 ‘렌털/전시중’이라 적힌 걸 보니 지금은 대여할 수 없나 봐. 아쉽네.', 'TEXT', 1),
   ('과일이나 컵 등을 그린 정물화부터 점묘화, 데생, 인물화, 민화, 팝아트까지. 그림 스타일도 소재도 다르니 내 취향대로 고를 수 있어.', 'TEXT', 1);

INSERT INTO BOOKMARK (bookmark_idx, post_id) VALUES
(1, 1);

INSERT INTO LIKEY (post_id) VALUES
(1);

INSERT INTO STAMP (post_id) VALUES
(1);