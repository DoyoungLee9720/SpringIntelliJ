package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QOrder;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// CustomerRepository 확장 인터페이스 정의
@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    // Q도메인 클래스 선언
    private QOrder qOrder = QOrder.order;

    @Override
    public List<Order> selectOrders() {
        //select * from customer
        return queryFactory
                .select(qOrder)
                .from(qOrder)
                .fetch();
    }

    @Override
    public Order selectOrder(int orderId) {
        return queryFactory
                .select(qOrder)
                .where(qOrder.orderId.eq(orderId))
                .fetchOne();
    }

//    @Override
//    public List<Order> searchOrder(String nameCondition, int ageCondition) {
//        //QueryDSL 동적 쿼리 Builder 생성
//        BooleanBuilder builder = new BooleanBuilder();
//        if(nameCondition != null) {
//            builder.and(qOrder..eq(nameCondition));
//        }
//        if(ageCondition > 0) {
//            builder.and(qOrder.age.goe(ageCondition)); // goe : Greater Than or Equal
//        }
//
//        return queryFactory
//                .selectFrom(qOrder)
//                .where(builder) // 조건에 따라 동적쿼리 실행
//                .fetch();
//      }

//    @Override
//    public List<Order> searchKeyword(String keyword) {
//        // QuerySQL 동적 쿼리 Expression 생성
//        BooleanExpression express = qOrder
//                                        .name.containsIgnoreCase(keyword)
//                                        .or(qOrder.addr.containsIgnoreCase(keyword));
//
//        return queryFactory
//                .selectFrom(qOrder)
//                .where(express)
//                .fetch();
//    }
}