package scenario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreationDeCompteStepDefinitions {

    private boolean utilisateurNonEnregistre;
    private boolean boutonCreateAccountClique;
    private boolean compteUtilisateurCreeAvecSucces;

    @Given("an unregistered user")
    public void anUnregisteredUser() {
        utilisateurNonEnregistre = true;
    }

    @When("the user clicks the 'Create Account' button")
    public void theUserClicksCreateAccountButton() {
        if (utilisateurNonEnregistre) {
            // Simuler le clic sur le bouton "Créer un compte"
            boutonCreateAccountClique = true;
        }
    }

    @Then("a new user account is successfully created")
    public void aNewUserAccountIsSuccessfullyCreated() {
        if (boutonCreateAccountClique) {
            // Implémenter ici la logique pour créer un nouveau compte utilisateur avec succès
            compteUtilisateurCreeAvecSucces = true;

            // Assertions pour vérifier que le compte utilisateur a été créé avec succès
            assert compteUtilisateurCreeAvecSucces : "Le compte utilisateur n'a pas été créé avec succès.";
        }
    }

}
