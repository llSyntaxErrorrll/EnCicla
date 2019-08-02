package com.jfcerquera2.encicla.entitys;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class ElementosEstacionEntity extends SugarRecord {

    //propiedades de la entidad

    @SerializedName("id")
    public int idElementoEstacion;

    @SerializedName("order")
    public long orderElement;
    public String name;
    public String address;
    public String description;
    public Double lat;
    public Double lon;
    public String type;
    public long capacity;
    public long bikes;
    public String places;
    public String picture;

    @SerializedName("bikes_state")
    public String bikesState;

    @SerializedName("places_state")
    public String placesState;

    public long closed;
    public long cdo;

    public long idEstacion;

    public ElementosEstacionEntity(){}

    public int getIdElementoEstacion() { return idElementoEstacion; }
    public void setIdElementoEstacion(int idElementoEstacion) { this.idElementoEstacion = idElementoEstacion; }

    public long getOrderElement() { return orderElement; }
    public void setOrderElement(long orderElement) { this.orderElement = orderElement; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLon() { return lon; }
    public void setLon(Double lon) { this.lon = lon; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public long getCapacity() { return capacity; }
    public void setCapacity(long capacity) { this.capacity = capacity; }

    public long getBikes() {return bikes; }
    public void setBikes(long bikes) { this.bikes = bikes; }

    public String getPlaces() { return places; }
    public void setPlaces(String places) { this.places = places; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public String getBikesState() { return bikesState; }
    public void setBikesState(String bikesState) { this.bikesState = bikesState; }

    public String getPlacesState() { return placesState; }
    public void setPlacesState(String placesState) { this.placesState = placesState; }

    public long getClosed() { return closed; }
    public void setClosed(long closed) { this.closed = closed; }

    public long getCdo() { return cdo; }
    public void setCdo(long cdo) { this.cdo = cdo; }

    public long getIdEstacion() { return idEstacion; }
    public void setIdEstacion(long idEstacion) { this.idEstacion = idEstacion; }
}
