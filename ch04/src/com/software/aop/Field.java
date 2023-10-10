package com.software.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("field")
public class Field {

    private String fieldId;

    private String fieldName;
    private Double area;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Field(String fieldId, String fieldName, Double area) {
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.area = area;
    }

    public Field() {
    }
}
