/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author King
 */
public class Violation {
    protected int id;
    protected String phone;
    protected String country;
    protected String city;          	   
    protected String picture_video;
    protected String violation_type; 
    protected int is_approved;    
    protected int is_expired;   
            
            
    public Violation() {}

    public Violation(String phone, String country, String city, String picture_video, String violation_type, int is_approved, int is_expired) {
        super();
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.picture_video = picture_video;
        this.violation_type = violation_type;
        this.is_approved = is_approved;
        this.is_expired = is_expired;   
    }

    public Violation(int id, String phone, String country, String city, String picture_video, String violation_type, int is_approved, int is_expired) {
        super();
        this.id = id;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.picture_video = picture_video;
        this.violation_type = violation_type;
        this.is_approved = is_approved;
        this.is_expired = is_expired;  
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPictureVideo() {
        return picture_video;
    }
    public void setPictureVideo(String picture_video) {
        this.picture_video = picture_video;
    }
    public String getViolationType() {
        return violation_type;
    }
    public void setViolationType(String violation_type) {
        this.violation_type = violation_type;
    }
    public int getIsApproved() {
        return is_approved;
    }
    public void setIsApproved(int is_approved) {
        this.is_approved = is_approved;
    }
    public int getIsExpired() {
        return is_expired;
    }
    public void setIsExpired(int is_expired) {
        this.is_expired = is_expired;
    }
}
