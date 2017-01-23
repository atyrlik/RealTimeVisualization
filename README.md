# RealTimeVisualization
Lors de la conception et les tests de notre outil, nous avons utilisé l'IDE IntelliJ IDEA. Cependant, l'outil ne dépend pas de fonctionnalités spécifiques à cet environnement et devrait donc fonctionner dans d'autres environnements.

Pour utiliser l'outil, il faut d'abord créer un projet contenant, dans les sources, deux dossiers. Le premier contient l'outil, et le deuxième contient le (ou les) programme à tester. Dans notre cas, notre outil est présent dans le dossier src/main, un premier programme à visualiser est présent dans src/toVisualize/abstractFactory et un deuxième (déplié) dans src/toVisualize/main (et test). Le programme à tester et ses tests doivent pouvoir être lancer directement dans le projet, toutes les dépendances doivent donc être résolues.

La deuxième étape consiste à insérer les appels au Logger dans le programme à visualiser. Pour cela, il faut modifier la classe "GenerateLoggedFile" pour lui indiquer où se trouve les fichiers du programme. Les deux lignes à modifier sont celles ci dessous:

```Java
spoon.addInputResource("src/toVisualize/main");
spoon.setSourceOutputDirectory("src/toVisualize/main-logged");
```

Il suffit d'indiquer le dossier contenant le programme à visualiser, ainsi que le nom du dossier à créer pour contenir la copie du programme avec les appels au Logger.

La dernière étape avant de lancer les tests consiste à modifier les classes de tests pour y ajouter la création et la fermeture du Logger. Cela permet ensuite de lancer directement les tests et de les visualiser. Chaques fichiers de test doit contenir le contenu ci dessous:

```Java
  @BeforeClass
    public static void setUp(){
    	Logger.open();
    }
    
	@AfterClass
    public static void tearDown(){
        Logger.close();
	}
  ```
  Il peut bien sûr avoir d'autre instructions dans les deux méthodes, tant que les méthodes open et close de Logger sont appelées.
  
Les tests peuvent maintenant être lancés directement dans l'environnement et la fenêtre de visualisation s'affiche directement, il n'y a rien de plus à configurer. Cependant, il n'est pas possible de lancer le programme directement (sans passer par les tests), car le Logger doit être ouvert avant de pouvoir recevoir les appels.
