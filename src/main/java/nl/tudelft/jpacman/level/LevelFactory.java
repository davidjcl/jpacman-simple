package nl.tudelft.jpacman.level;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.GhostColor;
import nl.tudelft.jpacman.npc.NPC;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;

/**
 * Factory that creates levels and units.
 * 
 * @author Jeroen Roosen <j.roosen@student.tudelft.nl>
 */
public class LevelFactory {

	/**
	 * The default value of a pellet.
	 */
	private static final int PELLET_VALUE = 10;
	
	/**
	 * The sprite store that provides sprites for units.
	 */
	private PacManSprites sprites;
	
	/**
	 * Creates a new level factory.
	 * @param spriteStore The sprite store providing the sprites for units.
	 */
	public LevelFactory(PacManSprites spriteStore) {
		this.sprites = spriteStore;
	}
	
	/**
	 * Creates a new level from the provided data.
	 * @param board The board with all ghosts and pellets occupying their squares.
	 * @param ghosts A list of all ghosts on the board.
	 * @param startPositions A list of squares from which players may start the game.
	 * @return A new level for the board.
	 */
	public Level createLevel(Board board, List<NPC> ghosts,
			List<Square> startPositions) {
		return new Level(board, ghosts, startPositions);
	}
	
	/**
	 * Creates a new ghost.
	 * @return The new ghost.
	 */
	public NPC createGhost() {
		return new RandomGhost(sprites.getGhostSprite(GhostColor.RED));
	}
	
	/**
	 * Creates a new pellet.
	 * @return The new pellet.
	 */
	public Pellet createPellet() {
		return new Pellet(PELLET_VALUE, sprites.getPelletSprite());
	}
	
	/**
	 * Implementation of an NPC that wanders around randomly.
	 * 
	 * @author Jeroen Roosen <j.roosen@student.tudelft.nl>
	 */
	private class RandomGhost extends NPC {

		/**
		 * The suggested delay between moves.
		 */
		private static final long DELAY = 200L;
		
		/**
		 * The sprite of this unit.
		 */
		private final Map<Direction, Sprite> sprite;
		
		/**
		 * Creates a new random ghost.
		 * @param ghostSprite The sprite for the ghost.
		 */
		private RandomGhost(Map<Direction, Sprite> ghostSprite) {
			this.sprite = ghostSprite;
		}
		
		@Override
		public long getInterval() {
			return (long) (DELAY * .75 + new Random().nextInt((int) DELAY / 2));
		}

		@Override
		public Direction nextMove() {
			Square square = getSquare();
			Random r = new Random();
			List<Direction> dirs = Lists.newArrayList(Direction.values());
			while (!dirs.isEmpty()) {
				Direction d = dirs.get(r.nextInt(dirs.size()));
				if (square.getSquareAt(d).isAccessibleTo(this)) {
					return d;
				}
			}
			return null;
		}

		@Override
		public Sprite getSprite() {
			return sprite.get(getDirection());
		}
	}
}
