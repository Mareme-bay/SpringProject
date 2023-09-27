Feature: Création de compte

  Scenario: Un utilisateur peut créer un compte
    Given un utilisateur non enregistré
    When l'utilisateur clique sur le bouton "Créer un compte"
    Then un nouveau compte utilisateur est créé avec succès

Feature: Dépôt d'argent sur un compte

  Scenario: Déposer un montant sur un compte existant
    Given le compte avec l'ID 1 existe
    And le solde du compte avec l'ID 1 est de 100.0
    When je dépose 50.0 sur le compte avec l'ID 1
    Then le solde du compte avec l'ID 1 est de 150.0

  Scenario: Tentative de dépôt sur un compte inexistant
    Given le compte avec l'ID 1 n'existe pas
    When je tente de déposer 50.0 sur le compte avec l'ID 1
    Then une exception NotFoundException est levée

  Scenario: Tentative de dépôt avec un montant négatif
    Given le compte avec l'ID 1 existe
    When je tente de déposer -50.0 sur le compte avec l'ID 1
    Then une exception IllegalArgumentException est levée

  Scenario: Tentative de dépôt avec un montant nul
    Given le compte avec l'ID 1 existe
    When je tente de déposer 0.0 sur le compte avec l'ID 1
    Then une exception IllegalArgumentException est levée

Feature: Retrait d'argent d'un compte

  Scénario: Tentative de retrait d'argent d'un compte inexistant
  Étant donné qu'aucun compte avec l'ID 1 n'existe
  Quand j'essaie de retirer 50.0 de ce compte
  Alors une exception NotFoundException est levée
  Et aucun enregistrement de compte n'est modifié
