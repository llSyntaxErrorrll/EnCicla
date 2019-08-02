package com.jfcerquera2.encicla.entitys;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LugaresCiclasEntity {

    public long date;
    public List<stations> stations = null;

    //contiene array de stations
    public class stations{

        public int id;
        public String name;
        public String desc;
        public List<items> items = null;

        //contiene array de items
        public class items{
            public int id;
            public Long order;
            public String name;
            public String address;
            public String description;
            public Double lat;
            public Double lon;
            public String type;
            public Long capacity;
            public Long bikes;
            public String places;
            public String picture;

            @SerializedName("bikes_state")
            public String bikesState;

            @SerializedName("places_state")
            public String placesState;

            public Long closed;
            public Long cdo;
        }
    }

}
