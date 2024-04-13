<header>

# Aquarium Project
Author: Jakub Glazik<br>
<p>It is my first Java Based application in which i used OOP principles like for example inheritance, polimorphism and abstract objects.</p>

</header>

<p>I created an animated aquarium with swimming fish using the Swing and AWT libraries for the GUI. The core of the application is an object of the <b>InsideContainer</b> class, serving as the main component of the displayed aquarium. To update the content, I customized the overridden paint function, which is executed multiple times. The board refreshes itself automatically every 20/30ms.</p>

<p>I've used three separate classes for red, yellow, and blue fish, inheriting from a base class, named "Fish". This class have also some abstract methods that are override by other classes methods. Each fish object I created has a different speed and graphics, depending on the color selected by the user.

The abstract class Fish contains basic functions such as: 
- startPosition<br>
- randomVDirect<br>
- randomHDirect<br>

which are invoked in the constructor of each created fish. These functions ensure that each object is assigned a random initial position and a direction in which it should move.

The functions <b>randomMinTop, randomMaxBottom, randomMaxRight</b>, and randomMinLeft are responsible for defining arbitrary movement boundaries for each fish, preventing them from swimming monotonously from the right to the left end of the screen.

To make the movement more random, the boundaries within which the fish move change dynamically. They are set when the object is about to start moving in a particular direction. For this purpose, the aforementioned methods are repeatedly called in the code.</p>