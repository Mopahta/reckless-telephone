package com.mopahta.recklesstelephone.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchInfoDTO {
    private String fullname;
    private String number;
    private String mail;
    private String position;
    private String department;

    public void trimFields() {
        if (fullname != null) {
            fullname = fullname.trim();
        }

        if (number != null) {
            number = number.trim();
        }

        if (mail != null) {
            mail = mail.trim();
        }

        if (position != null) {
            position = position.trim();
        }

        if (department != null) {
            department = department.trim();
        }
    }
}
