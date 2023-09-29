package io.bootify.wallet.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeControllerTest {

    @Test
    public void testIndex() {
        HomeController homeController = new HomeController();
        String viewName = homeController.index();
        Assertions.assertEquals("home/index", viewName);
    }

}