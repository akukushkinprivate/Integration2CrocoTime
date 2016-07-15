package data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alex on 7/15/16.
 */
@Generated("org.jsonschema2pojo")
public class Params {

    @SerializedName("task_id")
    @Expose
    private Integer taskId;
    @SerializedName("employee_id")
    @Expose
    private Integer employeeId;
    @SerializedName("begin")
    @Expose
    private Long begin;
    @SerializedName("end")
    @Expose
    private Long end;
    @SerializedName("comment")
    @Expose
    private String comment;

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
     * The task_id
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

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
     * The employee_id
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     *
     * @return
     * The begin
     */
    public Long getBegin() {
        return begin;
    }

    /**
     *
     * @param begin
     * The begin
     */
    public void setBegin(Long begin) {
        this.begin = begin;
    }

    /**
     *
     * @return
     * The end
     */
    public Long getEnd() {
        return end;
    }

    /**
     *
     * @param end
     * The end
     */
    public void setEnd(Long end) {
        this.end = end;
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

}
