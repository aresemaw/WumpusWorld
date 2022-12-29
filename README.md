# Wumpus World
## Background
The Wumpus world is a classic example of an artificial intelligence problem that involves logical reasoning and decision making. The game takes place in a cave with a grid of 4x4 rooms, where the objective is for the agent (the player) to pick up the gold and climb out of the cave without falling into a pit or being eaten by the Wumpus. The agent has to use its senses - smell, touch, and sight - to navigate the cave and make decisions about which actions to take.

The game has three main elements: the cave, the agent, and the Wumpus. The cave is made up of a grid of rooms, each of which can contain different objects or creatures. The agent is the player character, who can move around the cave and interact with the objects and creatures in it. The Wumpus is a creature that lives in the cave and will eat the agent if it gets too close.

The agent has a limited set of actions it can take. It can move up, down, left, or right, or it can shoot an arrow in a straight line in any of those directions. The agent also has a single arrow, which it can use to try to kill the Wumpus. If the Wumpus is hit, it will "scream" and the agent can then try to pick up the gold and climb out of the cave. However, if the agent falls into a pit or gets eaten by the Wumpus, the game is over.

The Wumpus world is a classic example of a knowledge-based AI problem, because the agent has to use its previous knowledge and experiences to make decisions about which actions to take. For example, if the agent smells a stench in a particular room, it knows that the Wumpus is nearby and it might want to avoid moving into that room. Similarly, if the agent feels a breeze in a room, it knows that there is a pit nearby and it might want to avoid moving into that room as well. By using these kinds of inferences, the agent can make rational decisions about which actions to take in order to achieve its goal of picking up the gold and climbing out of the cave




## Install 
### To compile
 *javac WumpusWorld.java* </br>
*java WumpusWorld*</br>

