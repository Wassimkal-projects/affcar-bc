package com.wkprojects.affcar.service.dto.users;

public class InterestDto {

    private Long id;

    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "InterestDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
