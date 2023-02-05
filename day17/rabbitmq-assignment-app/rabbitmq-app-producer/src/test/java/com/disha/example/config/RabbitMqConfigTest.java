package com.disha.example.config;


import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = "test")
public class RabbitMqConfigTest {
    @InjectMocks
    RabbitMQConfig rabbitMQConfig;

    @Test
    public void rabbitTemplateTest() {
        ConnectionFactory connectionFactory= Mockito.mock(ConnectionFactory.class);
        MessageConverter messageConverter= Mockito.mock(MessageConverter.class);
        AmqpTemplate rabbitTemplate=rabbitMQConfig.rabbitTemplate(connectionFactory);
    }
}}
