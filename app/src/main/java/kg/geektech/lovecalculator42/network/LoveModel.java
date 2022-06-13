package kg.geektech.lovecalculator42.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoveModel implements Serializable {

    @SerializedName("fname")
    public String firstName;
    @SerializedName("sname")
    public String secondName;
    public String percentage;
    public String result;

}
