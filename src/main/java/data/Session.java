package data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alex on 7/15/16.
 */
@Generated("org.jsonschema2pojo")
public class Session {

    @SerializedName("session")
    @Expose
    private String session;

    /**
     *
     * @return
     * The session
     */
    public String getSession() {
        return session;
    }

    /**
     *
     * @param session
     * The session
     */
    public void setSession(String session) {
        this.session = session;
    }

}
