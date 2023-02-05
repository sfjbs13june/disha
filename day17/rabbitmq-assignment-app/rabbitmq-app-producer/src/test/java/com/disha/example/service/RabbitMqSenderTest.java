package com.disha.example.service;



@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class RabbitMqSenderTest {



        @InjectMocks
        RabbitMQSender rabbitMQSender;

        @Mock
        AmqpTemplate amqpTemplate;

        @Test
        public void sendHospitalTest() {
            Hospital hos=new Hospital();
            // doNothing().when(amqpTemplate).convertAndSend(anyString(),anyString(),any(Employee.class));
            rabbitMQSender.sendHospital(hos);
//verify(amqpTemplate, times(1)).convertAndSend("exchange","queue",employee);
        }

        @Test
        public void sendPatientTest() {
            Patient pat=new Patient();
            // doNothing().when(amqpTemplate).convertAndSend(anyString(),anyString(),any(Employee.class));
            rabbitMQSender.sendPatient(pat);
//verify(amqpTemplate, times(1)).convertAndSend("exchange","queue",employee);
        }


    }


