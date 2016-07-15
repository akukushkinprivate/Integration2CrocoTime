package data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alex on 7/15/16.
 */
@Generated("org.jsonschema2pojo")
public class InputFileFormat {

    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("user.email")
    @Expose
    private String userEmail;
    @SerializedName("user.password")
    @Expose
    private String userPassword;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = new ArrayList<Track>();

    /**
     *
     * @return
     * The host
     */
    public String getHost() {
        return host;
    }

    /**
     *
     * @param host
     * The host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     *
     * @return
     * The userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     *
     * @param userEmail
     * The user.email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     *
     * @return
     * The userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     *
     * @param userPassword
     * The user.password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     *
     * @return
     * The tracks
     */
    public List<Track> getTracks() {
        return tracks;
    }

    /**
     *
     * @param tracks
     * The tracks
     */
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

}
