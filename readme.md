# Deloison-Leclercq-POO

## readme de Deloison Lucas et Leclercq Victor pour le TP5


## Dans ce tp nous découvrons tout d'abord une introduction aux archives exécutables java et nous réaliserons le jeu de la bataille navale.

**Toutes les commandes doivent être effectuées à la racine du dossier /tp5**

**Pour générer la documentation des fichiers Ship.java, Cell.java, Sea.java et Game.java précédemment créés :**

> `javadoc src/battleship/Cell.java src/battleship/Ship.java src/battleship/Sea.java src/battleship/Game.java -d docs`

**Pour compiler les différentes classes du project :**

>`javac src/battleship/util/*.java src/battleship/*.java src/io/*.java src/tv/*.java -d classes`

**Pour compiler et éxecuter les différents tests du project il faut :**

- Compilation des fichiers tests :

> `javac -classpath test4poo.jar test/battleship/util/*.java test/battleship/*.java`

- Exécution des différents tests : 

> `java -jar test4poo.jar vlille.util.PositionTest`

> `java -jar test4poo.jar vlille.ShipTest`

> `java -jar test4poo.jar vlille.CellTest`

> `java -jar test4poo.jar vlille.SeaTest`

> `java -jar test4poo.jar vlille.GameTest`

**Execution des différents mains :**

- Execution du FirstBattleShipMain :

> `java battleship.FirstBattleShipMain`

- Execution du SecondBattleShipMain :

> `java battleship.SecondBattleShipMain`

- Execution du ThirdBattleShipMain :

> `java battleship.ThirdBattleShipMain`

**Création et éxecution des fichiers jars :**

- SecondBattleShipMain.jar :

> `jar cvfe SecondBattleShipMain.jar battleship.SecondBattleShipMain -C classes battleship`

> `java -jar SecondBattleShipMain.jar`

- ThirdBattleShipMain.jar :

> `jar cvfe ThirdBattleShipMain.jar battleship.ThirdBattleShipMain -C classes battleship`

> `java -jar ThirdBattleShipMain.jar`