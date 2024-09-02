package com.arifsyncjava.aboutapi.model;

public class DataModel {

    public record AboutResponse (Developer developer, Client client) {}
    public record Developer (String name, String email) {}
    public record Client (String browser, String os, String device) {}


}
