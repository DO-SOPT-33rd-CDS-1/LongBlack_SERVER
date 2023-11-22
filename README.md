# ☕ LongBlack_SERVER
<img src="https://github.com/DO-SOPT-33rd-CDS-1/LongBlack_SERVER/assets/116873401/fd5a2fa5-663c-4eff-bb9a-15fd974e56b2" width = 400 height = 200 />

> 롱블랙은 24시간 안에 안 읽으면 콘텐츠가 사라지는 콘텐츠 구독 서비스이다. <br/>
> 하루 하나의 콘텐츠를 발행하고, 유료 멤버십 회원이라도 당일 발행된 콘텐츠를 놓치면 다음날엔 읽을 수 없도록 하는 시스템을 토입하고 있다.

<br />

## 💽 ERD

<img width="1139" alt="스크린샷 2023-11-22 오후 12 33 37" src="https://github.com/DO-SOPT-33rd-CDS-1/LongBlack_SERVER/assets/48898994/3003bee5-0dad-49aa-a455-8f7fd17bed79">


<br />

## 🌳 Branch


`main branch` : 배포 단위 브랜치

`dev branch` : main merge 전 거치는 branch

`feat branch`: 기능별 branch

- 할 일 Issue 등록 후, Issue 번호와 기능 내용으로 브랜치 생성
- 해당 브랜치 작업 후 완료 후 PR 보내기
- 로컬에서 먼저 충돌 해결한 후 올리기
- 서로 Approve & 리뷰 반영한 이후 merge
 
  <br />
## 🧵 Commit Convention

<div>
  
- init: 개발 환경 초기 세팅
- feat: 새로운 기능 구현
- fix: 버그 수정
- docs: 문서 추가, 수정, 삭제
- build: 빌드 시스템 및 외부에 영향을 미치는 사항 (라이브러리 추가 등)
- test: 테스트 추가 및 테스트 수정
- refactor: 코드 리팩토링
- chore: 그 외 자잘한 수정

</div>
<br />

## 🧶 Convention

<div>

1. 직관적이고 이해하기 쉬운 네이밍  <br>
2. 패키지 이름은 소문자로 구성한다. ex) `domain`, `controller`  <br>
3. 클래스, 인터페이스 이름은 명사로 작성하고 대문자 카멜표기법 적용한다. ex) `UserSeriveTest`  <br>
4. 테스트 클래스 이름은 항상 'Test'로 끝낸다.  <br>
5. 메서드 이름은 동사로 작성하고 소문자 카멜표기법을 적용한다. ex) `readBook`  <br>
6. EUNUM 이나 상수는 대문자 및 언더스코어로 작성한다. ex ) `DEFAULT_SCORE`  <br>
7. 변수는 소문자 카멜표기법 적용한다.   <br>
8. URL, 파일명 등은 kebab-case 를 사용한다 (원문 : USER LOGIN LOG, 케밥식: `user-login-log`)  <br>
9. 예외 케이스가 발생할 확률이 있는 경우, 가능한 빨리 리턴 또는 예외를 던질 수 있게 한다  <br>
- 예외는 반드시 처리하고 처리하지 않을 경우 주석으로 이유를 설명한다  <br>
10. 하나의 메소드와 클래스는 하나의 목적만 수행하게 만든다.  <br>
- 메소드는 최소한의 역할만 수행한다  <br>
- 클래스는 필요한 책임만 할당한다  <br>

</div>
