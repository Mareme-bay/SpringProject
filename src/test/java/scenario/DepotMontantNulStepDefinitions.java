package scenario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepotMontantNulStepDefinitions {
    private boolean compteExiste;
    private boolean exceptionIllegalArgumentExceptionLevee;

    @Given("le compte avec l'ID {int} existe")
    public void leCompteAvecIDExiste(Integer id) {
        // Simule l'existence du compte avec l'ID spécifié (vous devrez adapter cette logique à votre application)
        compteExiste = true;
    }

    @When("je tente de déposer {double} sur le compte avec l'ID {int}")
    public void jeTenteDeDeposerSurLeCompteAvecID(Double montant, Integer id) {
        // Tente de déposer un montant nul sur le compte (vous devrez adapter cette logique à votre application)
        try {
            if (compteExiste) {
                if (montant == 0.0) {
                    throw new IllegalArgumentException("Le montant du dépôt ne peut pas être nul.");
                }
                // Implémentez ici la logique de dépôt d'argent
                // Si le dépôt réussit, définissez une variable de contrôle
            }
        } catch (IllegalArgumentException e) {
            exceptionIllegalArgumentExceptionLevee = true;
        }
    }

    @Then("une exception IllegalArgumentException est levée")
    public void uneExceptionIllegalArgumentExceptionEstLevée() {
        // Vérifie si l'exception IllegalArgumentException a été levée
        assert exceptionIllegalArgumentExceptionLevee : "L'exception IllegalArgumentException n'a pas été levée.";
    }
}
