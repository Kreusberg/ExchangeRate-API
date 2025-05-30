package model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Model {

    @SerializedName("base_code")
    String base_code;

    @SerializedName("conversion_rates")
    Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
