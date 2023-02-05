package com.disha.example.controller;


import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
    @ActiveProfiles(value = "test")
    public class WebControllerTest {
        @InjectMocks
        WebControllerTest webControllerTest;


        @Mock
        RabbitMQSender rabbitMQSender;

        @Test
        public void producerTest() {

            doNothing().when(rabbitMQSender).sendHospital(any(Hospital.class));
            doNothing().when(rabbitMQSender).sendPatient(any(Patient.class));

            //String result = webControllerTest.producer("hosId1", "name1", "city1");
        }


    }
}
