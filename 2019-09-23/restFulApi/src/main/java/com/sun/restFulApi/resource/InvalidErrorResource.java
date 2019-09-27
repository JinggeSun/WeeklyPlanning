package com.sun.restFulApi.resource;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class InvalidErrorResource {

    private String message;
    private Object object;
}
