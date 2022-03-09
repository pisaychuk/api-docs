import com.bandwidth.BandwidthClient;
import com.bandwidth.http.response.ApiResponse;
import com.bandwidth.voice.models.DynamicResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Sample {
    public static final String USERNAME = System.getenv("BW_USERNAME");
    public static final String PASSWORD = System.getenv("BW_PASSWORD");
    public static final String ACCOUNT_ID = System.getenv("BW_ACCOUNT_ID");

    public static void main(String[] args) {
        // Conference id is returned after successfully creating a conference.
        String conferenceId = "conf-95ac8d8d-28e06798-2afe-434c-b0f4-666a79cd47f8";
        // Recording id is returned after retrieving a recording from the call.
        String recordingId = "r-d68201ef-d53e-4c6d-a743-1c1283909d41";

        BandwidthClient client = new BandwidthClient.Builder()
                .voiceBasicAuthCredentials(USERNAME, PASSWORD)
                .build();

        try {
            CompletableFuture<ApiResponse<DynamicResponse>> completableFuture = client.getVoiceClient().getAPIController().getDownloadConferenceRecordingAsync(ACCOUNT_ID, conferenceId, recordingId);
            System.out.println(completableFuture.get().getResult());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}