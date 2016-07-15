package data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alex on 7/15/16.
 */
@Generated("org.jsonschema2pojo")
public class InsertedTrack {

    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("params")
    @Expose
    private Params params;

    /**
     *
     * @return
     * The action
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @param action
     * The action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     *
     * @return
     * The domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     *
     * @param domain
     * The domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     *
     * @return
     * The params
     */
    public Params getParams() {
        return params;
    }

    /**
     *
     * @param params
     * The params
     */
    public void setParams(Params params) {
        this.params = params;
    }

}