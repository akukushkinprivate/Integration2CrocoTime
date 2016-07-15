import com.google.gson.Gson;
import data.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 7/15/16.
 */
class Uploader {

    private InputFileFormat info;
    private Session session;
    private Gson gson;

    /**
     * Initialize
     * @param inputFileFormat
     * Object with settings
     */
    Uploader(InputFileFormat inputFileFormat) {
        info = inputFileFormat;
        gson = new Gson();
    }

    /**
     * Upload tracks
     */
    void upload() {
        if (session == null) auth();
        sendTracks();
    }

    /**
     * Send tracks
     */
    private void sendTracks() {
        for (Track track : info.getTracks()) {
            sendTrack(track);
        }
    }

    /**
     * Send track
     * @param track
     * Sending track
     */
    private void sendTrack(Track track) {
        doRequest(prepareSendTrackData(track));
    }

    /**
     * Request to server
     * @param data
     * Body of request
     * @return
     * Response message
     */
    private String doRequest(String data) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(info.getHost() + "?" + data);
            HttpResponse response = httpClient.execute(request);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Authorization
     */
    private void auth() {
        session = gson.fromJson(doRequest(prepareAuthData()), Session.class);
    }

    /**
     * Prepare track data
     * @param track
     * Track to prepare
     * @return
     * String query GET parameters track data
     */
    private String prepareSendTrackData(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("session=")
                .append(session.getSession())
                .append("&controller=WorkspaceActionController&query=");

        Params params = new Params();
        params.setTaskId(track.getTaskId());
        params.setEmployeeId(track.getEmployeeId());
        params.setBegin(ConvertDate(track.getPeriod().getStart()));
        params.setEnd(ConvertDate(track.getPeriod().getEnd()));
        params.setComment(track.getComment());

        InsertedTrack insertedTrack = new InsertedTrack();
        insertedTrack.setAction("insert");
        insertedTrack.setDomain("task_timings");
        insertedTrack.setParams(params);

        try {
            stringBuilder.append(URLEncoder.encode(gson.toJson(insertedTrack, InsertedTrack.class), "ASCII"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return stringBuilder.toString();
    }

    /**
     * Convert date
     * @param dateString
     * String containing date
     * @return
     * Numeric presentation date
     */
    private static Long ConvertDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            Date date = dateFormat.parse(dateString);
            return (date.getTime() + 10800000L) / 1000L;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Prepare auth data
     * @return
     * String query GET parameters auth data
     */
    private String prepareAuthData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("controller=LogonController&query=");

        User user = new User();
        user.setLogin(info.getUserEmail());
        user.setPassword(GetMd5Hash(info.getUserPassword()));

        Auth authData = new Auth();
        authData.setUser(user);

        try {
            stringBuilder.append(URLEncoder.encode(gson.toJson(authData, Auth.class), "ASCII"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return stringBuilder.toString();
    }

    /**
     * Get string MD5
     * @param plainText
     * String
     * @return
     * String MD5
     */
    private static String GetMd5Hash(String plainText) {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        m.reset();
        m.update(plainText.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashText = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashText.length() < 32 ) {
            hashText = "0" + hashText;
        }
        return hashText;
    }
}
