강의를 듣고 SpringBoot JPA와 타임리프를 이용해서 만든 주문,회원,상품관리 서비스

## HelloShop.
![메인](https://user-images.githubusercontent.com/73016277/189328513-a14d8a7c-33b5-4f5f-92bf-572ba93b0706.jpg)
#### 홈 화면입니다 .
- - -
![member가입](https://user-images.githubusercontent.com/73016277/189328527-656e8aaf-d554-4502-9cae-dbfa57ea6cc7.jpg)
#### 회원가입 화면입니다 .

![화면 캡처 2022-09-09 194812](https://user-images.githubusercontent.com/73016277/189333708-fa929f04-e4a1-4e09-97b1-36d998556100.jpg)
```
submit버튼을 클릭하면 MemberController에서 GetMapping과 PostMapping으로 요청을 처리하고, 내부로직에 의해 
H2 DB로 데이터가 저장됩니다.

```

- - -
![member목록](https://user-images.githubusercontent.com/73016277/189328534-6a6b5ce2-1c7b-4000-97d4-fa71fc2fc076.jpg)
#### 저장된 회원을 화면에 뿌려서 회원목록 화면을 구성합니다
- - -
![itemcreate](https://user-images.githubusercontent.com/73016277/189328538-54048fb9-d635-43a6-90ca-c1c1aca46700.jpg)
#### 상품 등록 버튼을 눌렀을때 화면입니다
![화면 캡처 2022-09-09 195321](https://user-images.githubusercontent.com/73016277/189334612-e8c88c64-67ac-4bd9-8c49-5aba79db7e6a.jpg)

```
마찬가지로 submit버튼을 누르면 입력 Form에 있는 데이터들이 DB에 저장되게 됩니다
```
- - -
![item](https://user-images.githubusercontent.com/73016277/189328541-f40fff73-8150-4c47-ba80-7c41d495d522.jpg)
#### 상품목록 버튼을 눌렀을때 보여주는 화면입니다. 상품의 목록을 수정할 수 있습니다.
- - -
![item update](https://user-images.githubusercontent.com/73016277/189328544-4c97fa54-b293-4755-a998-21779fa8e422.jpg)
#### 상품목록의 수정 버튼을 눌렀을때 보여주는 화면입니다. 해당 상품의 정보를 바꿀수있습니다.
```
Submit 버튼을 누르면 Update쿼리가 날아갑니다
```
- - -
![itemlist](https://user-images.githubusercontent.com/73016277/189328547-fd18a46d-b98d-4475-9fba-5c1fef3461bc.jpg)
#### 데이터가 변경된 것을 확인할 수 있습니다.
- - -
![order](https://user-images.githubusercontent.com/73016277/189328550-291f7f5f-ae25-4325-a610-884c480686d4.jpg)

![orederlist](https://user-images.githubusercontent.com/73016277/189328552-4a4ad612-2ebc-45d2-b59d-88cf57494784.jpg)
#### 상품 주문 버튼을 눌렀을 때 보여주는 화면입니다. 회원을 선택하고 주문하고자하는 상품을 선택 수 있습니다.
- - -
![searchlist](https://user-images.githubusercontent.com/73016277/189328555-c02569d1-743f-4a24-9c3b-fa749c770555.jpg)
![orderserch](https://user-images.githubusercontent.com/73016277/189328559-65d19d40-9e55-4c2d-aeeb-5ad2d24e07c9.jpg)
#### 주문내역을 눌렀을때 보여주는 화면입니다. 
```
주문내역을 주문상태에 맞게 정렬해서 검색할 수 있는 화면입니다, 회원과 주문상태를 기준으로 조회합니다. 
```
- - -
![oredercancel](https://user-images.githubusercontent.com/73016277/189328563-324b325e-4247-41bd-b278-5bd965917b4a.jpg)
```
Cancel버튼을 누른 상품을 조회하는 화면입니다
```
