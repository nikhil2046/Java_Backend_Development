package com.exercise.programs.designPattern.builder;

public class BuilderTest {
    public static void main(String[] args) {
      User user =   new User.UserBuilder()
              .setUserId("101")
              .setEmailId("testEmail")
              .setUsername("testUser")
              .build();

        System.out.println(user );
    }
}
