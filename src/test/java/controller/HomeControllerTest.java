package controller;

import io.bootify.wallet.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class HomeControllerTest {

    @Test
    public void testIndex() {
        HomeController homeController = new HomeController();
        Model model = mock(Model.class);

        String viewName = homeController.index();

        assertEquals("home/index", viewName);
    }
}
