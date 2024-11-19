# 🧮 계산기

# with Java

## 📜프로젝트 파일 구조
```java
📁src/
├── 📁calculator/
│   ├── 📁operator/
│   │   ├── AddOperation.java
│   │   ├── DivideOperation.java
│   │   ├── MultiplyOperation.java
│   │   ├── PowerOperation.java
│   │   ├── SubstractOperation.java
│   ├── Calculator.java
│   ├── CalculatorApp.java
│   ├── CalculatorInput.java
│   ├── Operation.java
│   ├── Operator.java
├── 📁exception/
│   ├── BadInputException.java
├── 📁history/
│   ├── History.java
│   ├── HistoryCondition.java
│   ├── HistoryData.java
│   ├── HistoryDataSearch.java
│   ├── HistoryInput.java
│   ├── HistoryInteraction.java
│   ├── HistoryOutput.java
│   ├── HistorySearch.java
├── 📁main/
│   ├── Main.java
├── 📁parser/
│   ├── Parser.java


```
- 사용 언어 : JAVA 
- 구현된 기능 : 연속 계산, 거듭제곱, 음수로 계산, 계산 기록 불러오기, 특정 계산 기록 가져오기



## ⭐ 유지 보수가 편리한 계산기를 만들었습니다!
1. 연산자를 enum 열거형과 추상 클래스를 활용해 손쉽게 추가할 수 있도록 확장성을 높였습니다.

2. HistoryData Class의 분리를 통해 데이터의 무결성을 유지하고 재사용성을 높였습니다.

3. Class간 참조를 줄이고 각 Class가 하나의 책임을 가지도록, 최대한 객체 지향적으로 설계했습니다.

4. 예외 처리를 확실하게 했습니다.


## 🗨️최대한 많이 배우려고 노력했습니다!
1. stream과 람다식, Map 등 공부하며 알게 된 내용들을 적극 활용했습니다.

2. 리팩토링을 정말 열심히 했습니다.



## 🛠 앞으로 개선하고 싶은 점도 많습니다.

1. 다양한 디자인 설계 패턴을 적용해보고 싶습니다! 

2. Generic을 고려한 코드 설계를 해보고 싶습니다!

3. Github 활용법을 연습해야겠습니다! ㅠㅠ



## ⌨️ 내가 고민했던 것들

-pull request 안된다고 터미널 막 눌렀다가 파일 다 날릴 뻔 했습니다! 하하하하! 덕분에 main의 커밋 수가 20+개 ..

- [
계산기에 새로 배운 기술을 도입한다면? <1>](https://roqkfchqh.tistory.com/48)   

- [ 	
Stream 공부하다 뇌에서 Steam 나옴😇 <2>](https://roqkfchqh.tistory.com/49)

- [	
트러블슈팅: Reducing a Stream <3>](https://roqkfchqh.tistory.com/51)

- [
Parser.java의 중요성을 깨달음 <4>](https://roqkfchqh.tistory.com/53)

- [	
Generic을 도대체 왜 쓸까? <5>](https://roqkfchqh.tistory.com/54)

- [	
Interface? or Method? <6>](https://roqkfchqh.tistory.com/55)

- [	
트러블슈팅: 왜 저장이 두번 되니? <7>](https://roqkfchqh.tistory.com/56)

- [
<finish> 가 아니라 리팩토링..](https://roqkfchqh.tistory.com/58)   

- [
인터페이스, 추상클래스.. 사용 가능할 것 같은데? <8>](https://roqkfchqh.tistory.com/59)   

- [
트러블슈팅 : 검색 결과..아아... <9>](https://roqkfchqh.tistory.com/60)   

- [
추상 클래스를 도입해보자 <10>](https://roqkfchqh.tistory.com/62)   

