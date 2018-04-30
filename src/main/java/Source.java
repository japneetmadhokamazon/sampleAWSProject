
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;

public class Source {

    public static void main(String[] args) {

        AmazonSQS queue = AmazonSQSClientBuilder.defaultClient();
        CreateQueueRequest queueCreateRequest = new CreateQueueRequest("JavaMavenQueue")
                .addAttributesEntry("DelaySeconds", "30")
                .addAttributesEntry("MessageRetentionPeriod", "86400");

        try {
            System.out.println("Attempting to create queue now \n");
            queue.createQueue(queueCreateRequest);
        } catch (AmazonSQSException e) {
            if (e.getErrorCode().equals("QueueAlreadyExists")) {
                System.out.println("Queue with name already exists");
                throw e;
            }
        }




    }
}
