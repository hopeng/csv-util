package com.macquarie.dimension.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by hopeng on 7/4/18.
 */
@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Date createdBy;
    private Integer age;
    private BigDecimal amount;
    private ZonedDateTime updatedBy;
    private LocalDate localDate;
    private Boolean enabled;
    private Boolean abcRouteUsAPrice;
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id='" + id + '\'' +
                ", createdBy=" + createdBy +
                ", age=" + age +
                ", amount=" + amount +
                ", updatedBy=" + updatedBy +
                ", localDate=" + localDate +
                ", enabled=" + enabled +
                ", abcRouteUsAPrice=" + abcRouteUsAPrice +
                ", currency=" + currency +
                '}';
    }
}
