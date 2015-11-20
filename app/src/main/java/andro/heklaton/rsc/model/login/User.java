package andro.heklaton.rsc.model.login;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "User")
public class User extends Model {

    @Column(name = "Status")
    @SerializedName("status")
    @Expose
    private String status;

    @Column(name = "Data", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("data")
    @Expose
    private Data data;

    @Column(name = "Config", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    @SerializedName("config")
    @Expose
    private Config config;

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The config
     */
    public Config getConfig() {
        return config;
    }

    /**
     *
     * @param config
     * The config
     */
    public void setConfig(Config config) {
        this.config = config;
    }

}