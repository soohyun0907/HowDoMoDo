# ERD 설계

### Author: 김 형 택

> ### 테이블 목록 
>
> 1. 회원정보 
>    - email, 이름, 닉네임, pw, 성별
> 2. 지역별 극장
> 3. 예매 기록 
>    - 추천을 해줄 것이라면 추가적인 추천 요소가 필요
> 4. 추천 테이블
>    - 활동 전후 - 빅데이터 분석 결과
> 5. 맛집 테이블
> 6. 채팅목록 
>    - 사용자 아이디, 채팅방 정보
> 7. 채팅내용
>    - 가능하다면 로그, 안되면 테이블, 테이블에 파일 주소를 가지고 파일에 채팅 내용 저장

### My Role

#### 5. 맛집 테이블

> - **store_id** : 맛집 고유 ID (int)
> - **store_name** : 맛집 이름 (varchar)
> - **store_address** : 주소 (varchar)
> - **store_type** : 업종 분류 (varchar)
> - **store_review** : 맛집 리뷰 갯수 (int)
>   - 간단한 블로그 리뷰 크롤링으로 맛집 추천 가능 (확장 기능)
> - **store_star** : 평점 (float)
> - **store_info** : 맛집 정보 (varchar)
>   - 소개글, 영업 시간, 휴일 등 관련된 정보 