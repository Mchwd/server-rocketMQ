package com.dh.producer.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Producer implements Serializable {

    private String pid;
    private String msg;

}
