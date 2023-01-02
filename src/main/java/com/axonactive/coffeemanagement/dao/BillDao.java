package com.axonactive.coffeemanagement.dao;

import com.axonactive.coffeemanagement.controller.request.BillRequest;
import com.axonactive.coffeemanagement.entity.Bill;
import com.axonactive.coffeemanagement.entity.Drink;
import com.axonactive.coffeemanagement.entity.Food;
import com.axonactive.coffeemanagement.entity.Member;
import com.axonactive.coffeemanagement.utils.Enum.BillStatusEnum;

import java.util.List;

public interface BillDao {
    Bill findById(Long billId);

    List<Bill> findAll();

    Bill create(BillRequest billRequest);

    Bill update(BillRequest billRequest, Long billId);

    void delete(Long billId);

    List<Bill> findByCreatedDate(String createdDate);

    List<Bill> findByMember(Long memberId);

    List<Bill> findByPayment(Long paymentId);

    List<Bill> findByBarTableAndCreatedDate(Long barTableId, String createdDate);

    List<Bill> findByStatus(String status);

    List<Bill> findByTotalAndCreatedDate(Double total, String createdDate);

    List<Bill> findByMemberAndCreatedDate(Long memberId, String createdDate);

    List<Bill> findByTotalAndPromotionAndCreatedDate(Double total, Long promotionId, String createdDate);

    List<Bill> findByPromotionIsNotExpired(Long promotionId, boolean expired);

    Double findTotalByCreatedDateAndStatus(String createdDate, String status);

    Double findTotalByFoodAndDate(Long foodId, String date);

    Double findTotalByDrinkAndDate(Long drinkId, String date);

    List<Food> findFoodsWasBoughtInMonth(String date);

    List<Drink> findDrinksWasBoughtInMonth(String date);
}
