# Game_of_Life1

The progress of the game is evolution: one generation changes another. Each generation is fully determined by the previous generation. The future of each cell
depends on its neighbours (adjacent cells).
Each cell has eight neighbors. We consider the universe to be periodic: border cells also have eight neighbors. For example:

If cell is right-border, its right (east) neighbor is leftmost cell in the same row.
If cell is bottom-border, its bottom (south) neighbor is topmost cell in the same column.



Corner cells use both solutions.

Evolution is controlled by two rules:

- An alive cell survives if has two or three alive neighbors; otherwise, it dies of boredom (<2) or overpopulation (>3)

- A dead cell is reborn if it has exactly three alive neighbors

<img width="647" alt="Screen Shot 2020-08-16 at 1 22 53 PM" src="https://user-images.githubusercontent.com/29640816/90342224-aa7a9b00-dfc3-11ea-9ee8-32d21711b7cc.png">


Need work on:

- increasing/decreasing evolution speed (use buttons or JSlider)

- color of cells (use JColorChooser or JComboBox)

- setting size of the new field (use JTextField or JDialog)

- save/load (use JFileChooser)

- and so on.
