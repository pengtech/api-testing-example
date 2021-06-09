package com.pnxtest.apiExample;


import com.pnxtest.core.PnxTest;
import com.pnxtest.core.api.PnxTestApplication;

@PnxTestApplication(envID = "qa")
public class MyPnxTestApplication {
    public static void main(String[] args){
        PnxTest.run(MyPnxTestApplication.class, args);
    }
}
