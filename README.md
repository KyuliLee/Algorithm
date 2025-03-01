# Algorithm

<p align="right">작성 일자 : 2024. 12. 11. 수.</p>

## 1. 문제점
예전에 이클립스 IDE에서 백준, 프로그래머스 문제를 풀면서 Algorithm 레파지토리를 만들어서 작업했었다. 오랜만에 레파지토리를 클론해서 인텔리제이 IDE에서 자바 파일을 만들고 실행하니 동일한 클래스명이 존재해서 자바 파일이 실행되지 않았다.<br><br>
<img src="duplicate class error.png" alt="에러 이미지" width="800"/>
<br><br>

## 2. 문제 원인
#### 클래스명의 중복
자바의 패키지에서 클래스명은 고유해야 한다. 하지만 프로그래머스 문제를 풀 때는 프로그래머스 사이트에서 문제를 풀고 그대로 복사, 붙여넣기를 해서 파일에 저장했으므로 `class Solution` 이 중복되었고 `duplicate class` 에러가 발생했다.
<br><br>

## 3. 해결 방법
#### (1) 파일명 수동 변경
*인텔리제이 IDE*에서 `class Solution` 을 파일명(예시 : PGS_카펫.java) 과 동일하게 바꿔준다.
#### (2) 파이썬 스크립트를 이용해 파일명 자동 변경
*파이썬 스크립트*를 활용해 `class Solution` 을 파일명(예시 : PGS_카펫.java) 과 동일하게 바꿔준다.<br>
[파이썬 스크립트 보러 가기](rename_java_classes.py)
<br><br>

## 4. 결과
두 번째 방법을 선택했고 파이썬 파일을 실행했다. 클래스명이 파일명과 동일하게 바뀐 것을 확인할 수 있었다.
<br><br>

## 5. 느낀 점
단순 반복 작업을 자동화하니까 편리했다. 이번에는 수정해야 하는 파일이 많지 않았지만 만약 수백 개, 수천 개의 파일을 수정해야 한다면 스크립트 사용은 필수라는 생각이 들었다.

<!---LeetCode Topics Start-->
# LeetCode Topics
## String
|  |
| ------- |
| [0020-valid-parentheses](https://github.com/KyuliLee/Algorithm/tree/master/0020-valid-parentheses) |
## Stack
|  |
| ------- |
| [0020-valid-parentheses](https://github.com/KyuliLee/Algorithm/tree/master/0020-valid-parentheses) |
<!---LeetCode Topics End-->