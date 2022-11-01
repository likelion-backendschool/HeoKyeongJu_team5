package com.mutbook.week3_mission.app.domain.rebate.controller;

import com.mutbook.week3_mission.util.Util;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin/rebate")
public class AdminRebateController {
    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String showRebateList(){
        return "admin/rebate/list";
    }
    @PostMapping("/makeData")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public String makeData(String yearMonth) {
        int monthEndDay = Util.date.getEndDayOf(yearMonth);

        String fromDateStr = yearMonth + "-01 00:00:00.000000";
        String toDateStr = yearMonth + "-%02d 23:59:59.999999".formatted(monthEndDay);
        LocalDateTime fromDate = Util.date.parse(fromDateStr);
        LocalDateTime toDate = Util.date.parse(toDateStr);

        return "fromDateStr : %s<br>toDateStr : %s".formatted(fromDateStr, toDateStr);
    }
}
