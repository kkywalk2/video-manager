# Video Manager
영상을 업로드 하고 hls로 인코딩하여 스트리밍 방식으로 웹에서 볼 수 있는 Spring 어플리케이션 개발

## 목표
- 도메인 레이어를 살리고 테스트하기 좋은 구조를 연습하기 위한 목적으로 개발
- 기능 자체는 최대한 간단하게 구현
- 불필요하더라도 우선 커버리지를 늘려보고 고민해보기

## 대충 설계
- 회원가입
- 로그인
- 나의 정보 조회
- Video 관리
  - Series를 무조건 먼저 생성해야 함
  - Video는 무조건 특정 Series 나 Group에 속해야함
  - Series를 생성하면 무조건 default group을 속함
  - 따로 Group을 지정하지 않으면 default group에 추가됨
  - Video가 업로드 되고 나면 인코딩이 진행되고 완료되면 볼 수 있게됨
  - 실제 파일을 위한 엔드포인트는 별도 분리
  - Series 공유
  - Video 삭제
  - Group 삭제
  - Series 삭제
  - Series의 리스트를 먼저 조회
  - Group의 리스트를 Series를 통해 조회
  - Video의 리스트를 Group을 통해 조회

## 여유 있음 할거
- 이메일 인증
- 자막 추가