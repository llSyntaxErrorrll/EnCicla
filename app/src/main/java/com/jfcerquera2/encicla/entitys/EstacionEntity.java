package com.jfcerquera2.encicla.entitys;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class EstacionEntity extends SugarRecord {

    //propiedades de la entidad
    @SerializedName("id")
    public int idEstacion;
    public String name;
    public String desc;

    public EstacionEntity(){}

    public int getIdEstacion() { return idEstacion; }
    public void setIdEstacion(int idEstacion) { this.idEstacion = idEstacion; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}
