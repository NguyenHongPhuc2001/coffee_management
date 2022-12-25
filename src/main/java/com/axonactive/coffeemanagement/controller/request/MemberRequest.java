package com.axonactive.coffeemanagement.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private String phone;

    private String name;

    private Integer bonus;
}
