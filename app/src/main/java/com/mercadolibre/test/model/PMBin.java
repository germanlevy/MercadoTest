package com.mercadolibre.test.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GL on 20/11/2015.
 */
public class PMBin {

    @SerializedName("pattern")
    private String pattern;

    @SerializedName("exclusion_pattern")
    private String exclusion_pattern;

    @SerializedName("installment_pattern")
    private String installment_pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getExclusion_pattern() {
        return exclusion_pattern;
    }

    public void setExclusion_pattern(String exclusion_pattern) {
        this.exclusion_pattern = exclusion_pattern;
    }

    public String getInstallment_pattern() {
        return installment_pattern;
    }

    public void setInstallment_pattern(String installment_pattern) {
        this.installment_pattern = installment_pattern;
    }
}
