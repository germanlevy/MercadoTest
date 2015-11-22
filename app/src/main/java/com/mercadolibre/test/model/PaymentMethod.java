package com.mercadolibre.test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by GL on 20/11/2015.
 */
public class PaymentMethod {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("payment_type_id")
    private String payment_type_id;

    @SerializedName("status")
    private String status;

    @SerializedName("secure_thumbnail")
    private String secure_thumbnail;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("deferred_capture")
    private String deferred_capture;

    @SerializedName("settings")
    private List<PMSettings> settings;

    @SerializedName("additional_info_needed")
    private List<String> additional_info_needed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(String payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSecure_thumbnail() {
        return secure_thumbnail;
    }

    public void setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDeferred_capture() {
        return deferred_capture;
    }

    public void setDeferred_capture(String deferred_capture) {
        this.deferred_capture = deferred_capture;
    }

    public List<PMSettings> getSettings() {
        return settings;
    }

    public void setSettings(List<PMSettings> settings) {
        this.settings = settings;
    }

    public List<String> getAdditional_info_needed() {
        return additional_info_needed;
    }

    public void setAdditional_info_needed(List<String> additional_info_needed) {
        this.additional_info_needed = additional_info_needed;
    }

    public String toString() {
        return name;
    }
}
