package com.example.foodorderfx.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {

    @Test
    void personAnlegen() {

        assertNotNull(new Person("Hans", "Peter"));


    }

    @Test
    void alleGruppenAusgeben() {

    }
}