Aaiz N Ahmed 

Project Details:

OS Used: 	   Windows 7/10
System Type:   64-bit Operating System

Language Used: Java
Compiler/Running environment: Java Development Kit (JDK) is required on the machine in which you
	want to run the program. Java Runtime Environment (JRE) should be fine to run the program as
	well.

Download Java SDK for your architecture using the following URL: 
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Build/Run: I used Eclipse IDE for this project. Inside eclipse create a new java project
		   and put all the .java files in one package and call it "proj4". Project4.java contains main(), run it 
		   and the game should start.

NOTE: I put the Horde data files outside the proj4 package but the can be placed inside the proj4 package as well.

Files initially provided:
1)	Project4.java
2)	GameInterface.java
3)	RecruitDialog.java
4)	InvasionDialog.java
5)	Gigantic.java
6)	Flammable.java
7)	Zombie.java
8)	ArmoredZombie.java
9)	GiantZombie.java
10)	InfectedZombie.java
11)	RadioactiveZombie.java
12)	StandardZombie.java
13)	VoodooZombie.java
14)	ZombieNinja.java
15)	ZombieScientist.java

The following data files were given as well:
1)	horde_1.data
2)	horde_2.data
3)	horde_3.data
4)	horde_4.data
5)	horde_5.data

Files written by me:
1)	Game.java
2)	Ant.java
3)	ArmyAnt.java
4)	BulletAnt.java
5)	CarpenterAnt.java
6)	CitronellaAnt.java
7)	FireAnt.java
8)	LeafcutterAnt.java
9)	PharaohAnt.java
10)	SugarAnt.java
11)	ThiefAnt.java
12)	WeaverAnt.java


Comments: This project is mainly about the inheritance in Java or object oriented programming. This project uses sub classes
          and interfaces. You need to have knowledge of Java inheritance rules and practices in order to understand this 
          project. For example, a parent class Ant.java is used to derive many other types of ants like FireAnt.java and
          ArmyAnt.java. My favorite part of the project was to figure out a way to read the horde data files, parse them 
          and create the zombies based on information. It is done inside "readHordeFile(String filename)" method in Game.java.
          Read the Appendix A for the details about all the types of the ants that needs to be implemented. 


Contact:  aaiznahmed@gmail.com or aaiza2@umbc.edu
LinkedIn: https://www.linkedin.com/in/aaizahmed
GitHub:   https://github.com/AaizAhmed
