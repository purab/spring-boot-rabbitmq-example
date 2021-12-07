package in.purabtech.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

    @RabbitListener(queues = RabbitmqApplication.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as a generic AMQP 'Message' wrapper: {}", message.toString());
    }

    @RabbitListener(queues = RabbitmqApplication.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final CustomMessage customMessage) {
        log.info("Received message and deserialized to 'CustomMessage': {}", customMessage.toString());
    }
}
