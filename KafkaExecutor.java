import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class KafkaExecutor {
  public static void main(String[] args) {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "test-group");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("auto.offset.reset", "earliest");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("max.poll.records", "10");
    props.put("max.poll.interval.ms", "300000");
    props.put("fetch.min.bytes", "1");
    props.put("fetch.max.wait.ms", "500");
    props.put("heartbeat.interval.ms", "3000");
    props.put("request.timeout.ms", "30000");
    props.put("connections.max.idle.ms", "540000");
    props.put("receive.buffer.bytes", "32768");
    props.put("send.buffer.bytes", "131072");
    props.put("client.id", "kafka-executor-client");
    props.put("security.protocol", "PLAINTEXT");
    props.put("sasl.mechanism", "PLAIN");
    props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin-secret\";");
    KafkaConsumer consumer = null;
    try {
      consumer = new KafkaConsumer<>(props);
    } finally {
      consumer.subscribe(Collections.singletonList("test-topic"));
    }
  }



  }

