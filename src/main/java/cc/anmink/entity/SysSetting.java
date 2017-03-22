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
    private String base_url;
    private String site_name;

    public SysSetting() {
    }

    public SysSetting(Integer site_status, String description, String count_code, String copy_right, String icp, String base_url, String site_name) {
        this.site_status = site_status;
        this.description = description;
        this.count_code = count_code;
        this.copy_right = copy_right;
        this.icp = icp;
        this.base_url = base_url;
        this.site_name = site_name;
    }

    public Long getId() {
        return id;
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

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }
}
