package com.disha.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationControllerTest {

    @Test
    public void addTest(){
        OperationController operationController = new OperationController();
        long result = operationController.add(5,6);
        Assertions.assertEquals(result,11);

    }

}
