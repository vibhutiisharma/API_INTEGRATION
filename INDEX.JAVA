// ApiClient.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {
    private static final String BASE_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";
    private String bearerToken;

    public boolean authenticate(String loginId, String password) {
        try {
            URL url = new URL(BASE_URL + "/assignment_auth.jsp");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String requestBody = String.format("{\"login_id\":\"%s\",\"password\":\"%s\"}", loginId, password);
            conn.getOutputStream().write(requestBody.getBytes());

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    bearerToken = response.toString();
                    return true;
                }
            } else {
                System.err.println("Authentication failed. HTTP error code: " + responseCode);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Implement methods for create, get customer list, delete, and update using the bearer token.
}
