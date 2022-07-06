package com.example.springbootwebservice.web.dto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void testdto(){
        String name= "test";
        int amount=1000;

        HelloResponseDto helloResponseDto = new HelloResponseDto(name,amount);

        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);


    }
}
