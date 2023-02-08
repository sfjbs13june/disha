package com.rama.app;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyClassBTest {
    @InjectMocks
    MyclassB myclassB;
    @Mock
    MyclassA myclassA;

    @Mock
    MyClassC myclassC;
    @BeforeEach
    void setUp(){
        myclassB= Mockito.mock(MyclassB.class);
        myclassC= Mockito.mock(MyClassC.class);
    }
    @Test
    public void TestgetResult() {
        String result = myclassB.getResult();
        assertEquals("my result", result);
    }
    @Test
    public void TestgetMyString() {
        String result = myclassB.getMyString("hello");
        assertEquals("my resulthello", result);
    }
    @Test
    public void TestgetClassCRestult() {
        when(myclassC.getMyAge(anyInt())).thenReturn(35);
        int result = myclassC.getMyAge(25);
        assertEquals(35, result);
    }
    @Test
    public void TestNoreturnData()
    {
        myclassB.NoreturnData("my data");
        String result = "my data";
        assertEquals("my data",result);
    }


}
