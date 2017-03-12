package cc.anmink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jamin on 2017/3/11.
 */
@Entity
public class SysSetting {
    @Id
    @GeneratedValue
    private Long id;
    private Integer site_status;
    private String description;
    private String count_code;
    private String copy_right;
    private String icp;

    public SysSetting() {
    }

    public SysSetting(Integer site_status, String description, String count_code, String copy_right, String icp) {
        this.site_status = site_status;
        this.description = description;
        this.count_code = count_code;
        this.copy_right = copy_right;
        this.icp = icp;
    }

    public Integer getSite_status() {
        return site_status;
    }

    public void setSite_status(Integer site_status) {
        this.site_status = site_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount_code() {
        return count_code;
    }

    public void setCount_code(String count_code) {
        this.count_code = count_code;
    }

    public String getCopy_right() {
        return copy_right;
    }

    public void setCopy_right(String copy_right) {
        this.copy_right = copy_right;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }
}
