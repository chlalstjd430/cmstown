# cmstown
***

### 프로젝트 소개
***

프로젝트 및 기술 블로그를 위한 웹 페이지를 만들기 프로젝트입니다.
개인적으로 spring을 학습하기 위해 만들었고 
2019.10.21 ~ 2020.01.21 동안 https://www.cmstown.com 이라는 도메인을 통해 실제 운영되었습니다. 
해당 사이트는 20.01.22부로 폐쇄 되었고 이전 내용들은 새로운 [깃헙 블로그](https://chlalstjd430.github.io)로 이전되었습니다.
- 개발 참여 인원 : 개인 프로젝트
- 기간 : 2019.10.01 ~ 2019.10.30
- 개발 기술 : spring mvc, mybatis, java, mysql
- 외부 api : naver smart editor, java mail
- 역할 : 웹 프론트, 백 엔드 및 총괄


### 주요 기능
***

#### 1. 메인 페이지

![메인](https://user-images.githubusercontent.com/50758600/73132111-ecf57e00-4059-11ea-8cfc-dabc691911e0.jpg)


#### 2. 게시판


- 게시판 목록

  - 조회수 및 카테고리 기능

![게시판](https://user-images.githubusercontent.com/50758600/73132134-0eef0080-405a-11ea-8e7c-936cb6100e6c.jpg)

  

- 게시판 상세보기

![상세보기](https://user-images.githubusercontent.com/50758600/73132146-36de6400-405a-11ea-9c6a-6dac336a1351.png)

- 게시판 작성

  - fileUpload, naver smart editor 사용

![게시판작성](https://user-images.githubusercontent.com/50758600/73132154-507fab80-405a-11ea-89cc-b042df7c0636.jpg)


#### 3. 댓글

- 댓글 작성

  - 아이디/비밀번호 관리

  - 댓글 작성시 JavaMail을 통해 작성자 이메일과 블로그 사용자 메일에게 댓글 작성 알림 전송.

![댓글달기2](https://user-images.githubusercontent.com/50758600/73132196-efa4a300-405a-11ea-95f2-ccd06c2ba672.jpg)

- 댓글 수정

  - 입력했던 비밀번호를 검증하여 관리

![댓글달기(수정)](https://user-images.githubusercontent.com/50758600/73132222-5cb83880-405b-11ea-8168-c328145a6c4d.jpg)

- 댓글 삭제

  - 입력했던 비밀번호를 검증하여 관리

![댓글달기(삭제)](https://user-images.githubusercontent.com/50758600/73132230-7d808e00-405b-11ea-93a3-318ed5d58de5.jpg)

#### 4. 관리자

- 관리자 로그인

![관리자](https://user-images.githubusercontent.com/50758600/73132236-b882c180-405b-11ea-879f-5211acfc2d2d.jpg)

- 관리자 페이지

  - 로그인 성공시 제공되는 페이지

  - 게시판 작성 및 게시판 삭제,수정 페이지로 이동 가능.

![관리자2](https://user-images.githubusercontent.com/50758600/73132239-cf291880-405b-11ea-962b-ceb1f70bf80d.jpg)



