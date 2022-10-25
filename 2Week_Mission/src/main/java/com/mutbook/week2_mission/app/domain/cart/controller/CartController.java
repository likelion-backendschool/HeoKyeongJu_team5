package com.mutbook.week2_mission.app.domain.cart.controller;

import com.mutbook.week2_mission.app.base.rq.Rq;
import com.mutbook.week2_mission.app.domain.cart.entity.CartItem;
import com.mutbook.week2_mission.app.domain.cart.service.CartService;
import com.mutbook.week2_mission.app.domain.product.entity.Product;
import com.mutbook.week2_mission.app.domain.product.service.ProductService;
import com.mutbook.week2_mission.app.security.dto.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final Rq rq;

    @GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
    public String showList(Model model) {
        List<CartItem> cartItems = cartService.getItemsByMember(rq.getMember());

        model.addAttribute("cartItems", cartItems);

        return "cart/list";
    }

}