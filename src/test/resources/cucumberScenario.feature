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
  Scenario: Tentative de retrait d'argent d'un compte inexistant
    Given qu'aucun compte avec l'ID 1 n'existe
    When j'essaie de retirer 50.0 de ce compte
    Then une exception NotFoundException est levée
    And aucun enregistrement de compte n'est modifié

Feature: Transfert d'argent entre comptes :
  Scenario:Transfert d'argent entre comptes
  Given le compte avec l'ID 1 existe avec un solde de 200.0
  And le compte avec l'ID 2 existe avec un solde de 100.0
  When je transfère 50.0 du compte 1 au compte 2
  Then la vente du compte 1 est de 150.0
  And la vente du compte 2 est de 150.0

  Scenario:Tentative de transfert avec un montant supérieur au solde
  Given le compte avec l'ID 1 existe avec un solde de 100.0
  And le compte avec l'ID 2 existe avec un solde de 50.0
  When je tente de transférer 200.0 du compte 1 au compte 2Then une exception SoldeInsuffisantException est levée
  And la vente du compte 1 est de 100.0
  And la vente du compte 2 est de 50.0
