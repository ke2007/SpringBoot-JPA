package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.") //name에 값이 비워져있으면 오류
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
