package data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alex on 7/15/16.
 */
@Generated("org.jsonschema2pojo")
public class Track {

    @SerializedName("employee.id")
    @Expose
    private Integer employeeId;
    @SerializedName("task.id ")
    @Expose
    private Integer taskId;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("period")
    @Expose
    private Period period;

    /**
     *
     * @return
     * The employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     *
     * @param employeeId
     * The employee.id
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     *
     * @return
     * The taskId
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     *
     * @param taskId
     * The task.id
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     * The period
     */
    public Period getPeriod() {
        return period;
    }

    /**
     *
     * @param period
     * The period
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

}