package api;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.json.JSONObject;

public class GmailAPI {

    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String user = "me";
    static Gmail service = null;
    //private static File filePath = new File(System.getProperty("user.dir") + "/credentials.json");
    private static File filePath = new File(System.getProperty("user.dir") + "/credentials.json");

    public static void main(String[] args) throws IOException, GeneralSecurityException, MessagingException {
        //sendEmail("nadaramirthavarshini@gmail.com","");
        System.out.println(filePath);
//        sendEmail("hrithiksawant80@gmail.com", "This is System Test Message");
    }

    public static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        email.writeTo(baos);
        String encodedEmail = com.google.api.client.util.Base64.encodeBase64URLSafeString(baos.toByteArray());
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    public static MimeMessage createEmail(String to, String from, String subject, String bodyText) throws MessagingException, IOException {

        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from)); //me
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to)); //
        email.setSubject(subject);

        email.setText(bodyText);

        return email;
    }

    public static boolean sendEmail(String To, String Message) throws IOException, GeneralSecurityException, MessagingException {
        boolean check = false;
        try {
            Gmail service = GmailAPI.getGmailService();
            MimeMessage Mimemessage = createEmail(To, "me", "Smart Parking", Message);

            Message message = createMessageWithEmail(Mimemessage);

            message = service.users().messages().send("me", message).execute();

            System.out.println("Message id: " + message.getId());
            System.out.println(message.toPrettyString());
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return check ;
    }

    private static String getAccessToken() {

        try {
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("grant_type", "refresh_token");
            params.put("client_id", ""); //Replace this
            params.put("client_secret", ""); //Replace this
            params.put("refresh_token",
                    ""); //Replace this

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.getOutputStream().write(postDataBytes);

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                buffer.append(line);
            }

            JSONObject json = new JSONObject(buffer.toString());
            String accessToken = json.getString("access_token");
            return accessToken;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Gmail getGmailService() throws IOException, GeneralSecurityException {

        InputStream in = new FileInputStream(filePath); // Read credentials.json
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Credential builder
        Credential authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
                        clientSecrets.getDetails().getClientSecret().toString())
                .build().setAccessToken("").setRefreshToken(
                "");//Replace this
        // Create Gmail service
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize)
                .setApplicationName(GmailAPI.APPLICATION_NAME).build();
        return service;
    }
}
