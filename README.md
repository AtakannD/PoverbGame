# Proverb Game System

The Proverb Game System is designed to prompt users to complete a proverb and guess the correct one. It utilizes the Proverb class as a prompt, containing fullTxt, promptTxt, and origin variables. The Proverb class provides a suitable prompt for a given proverb, along with its origin and full text.

## Proverb Class

The `Proverb` class is used as a prompt in the game system. It contains the following attributes:

- `fullTxt`: A String representing the full text of the proverb.
- `promptTxt`: A String representing a prompt for the proverb suitable for use in the game.
- `origin`: A String representing the adjective that describes the culture from which the proverb originates.

The `Proverb` class provides methods to retrieve the prompt, origin, and full text of the given proverb.

## Usage Example

For a proverb with the full text: "Actions speak louder than words" and the origin: "English," the `Proverb` object will provide the following:

- Prompt: "There is an old English proverb: 'Actions speak louder than...'"
- Proverb: "There is an old English proverb: 'Actions speak louder than words.'"

## SimpleProverbManager Class

The `SimpleProverbManager` class reads all the data from the "proverbs.txt" file and manages a list of `Proverb` objects. It allows the list to be shuffled for random selection during the game.

## TurkishProverb and ChineseProverb Classes

The `TurkishProverb` and `ChineseProverb` classes are examples of extending the `Proverb` class to include culture-specific proverbs. These classes provide culture-specific origins for their respective proverbs.

## Implementation Details

- The `Proverb` class provides a constructor to initialize the `fullTxt`, `promptTxt`, and `origin` variables for each proverb.
- The `SimpleProverbManager` class reads data from the "proverbs.txt" file, creates `Proverb` objects, and manages them in a list.
- The `ProverbArrayListClient` and `ProverbClient` classes can use the `SimpleProverbManager` to access and shuffle the list of proverbs for gameplay.

## How to Run

1. Clone the repository or download the Java program files.

2. Run the `ProverbGameApp.java` file using a Java IDE or the command line.

3. Follow the on-screen instructions to play the proverb game and complete/guess the proverbs.

## Data Source

The proverbs used in the game system are sourced from the "proverbs.txt" file. Each proverb entry in the file should be in the format: "fullTxt,promptTxt,origin".
