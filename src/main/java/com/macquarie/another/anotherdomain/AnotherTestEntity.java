package com.macquarie.another.anotherdomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by hopeng on 7/4/18.
 */
@Entity
public class AnotherTestEntity {

    @Id
    private String id;
    private Date createdBy;
    private Integer age;
    private BigDecimal amount;
    private ZonedDateTime updatedBy;
    private LocalDate localDate;
    private boolean abcRouteUsAPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ZonedDateTime getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(ZonedDateTime updatedBy) {
        this.updatedBy = updatedBy;
    }

}
