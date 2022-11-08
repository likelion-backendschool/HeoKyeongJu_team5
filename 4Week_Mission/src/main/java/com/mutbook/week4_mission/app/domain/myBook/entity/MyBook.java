package com.mutbook.week4_mission.app.domain.myBook.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mutbook.week4_mission.app.base.entity.BaseEntity;
import com.mutbook.week4_mission.app.domain.member.entity.Member;
import com.mutbook.week4_mission.app.domain.order.entity.OrderItem;
import com.mutbook.week4_mission.app.domain.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class MyBook extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    @JsonIgnore
    private Member owner;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    private Product product;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    private OrderItem orderItem;
}
