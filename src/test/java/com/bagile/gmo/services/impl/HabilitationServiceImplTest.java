package com.bagile.tms.services.impl;

import com.bagile.tms.services.HabilitationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class HabilitationServiceImplTest {
    @Autowired
    private HabilitationService habilitationService;

    @Test
    void save() {
        String[] codes = {
                "DRIVER",
                "badge",
                "badge_type",
                "contact",
                "contract_type",
                "driver",
                "driver_zone",
                "habilitation",
                "insurance",
                "maintenance_plan",
                "maintenance_state",
                "maintenance_type",
                "owner",
                "supplier",
                "term_insurance",
                "user",
                "user_group",
                "user_group_owner",
                "user_group_warehouse",
                "vacation",
                "vacation_type",
                "vehicle",
                "vehicle_category",
                "warehouse",
                "zone",

        };

        habilitationService.save(codes);
    }
}