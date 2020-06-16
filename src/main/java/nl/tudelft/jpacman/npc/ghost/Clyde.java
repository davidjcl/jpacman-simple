package nl.tudelft.jpacman.npc.ghost;

import java.util.Map;
import java.util.Optional;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.Sprite;

/**
 * <p>
 * An implementation of the classic Pac-Man ghost Clyde.
 * </p>
 * <p>
 * Pokey needs a new nickname because out of all the ghosts,
 * Clyde is the least likely to "C'lyde" with Pac-Man. Clyde is always the last
 * ghost out of the regenerator, and the loner of the gang, usually off doing
 * his own thing when not patrolling the bottom-left corner of the maze. His
 * behavior is very random, so while he's not likely to be following you in hot
 * pursuit with the other ghosts, he is a little less predictable, and still a
 * danger.
 * </p>
 * <p>
 * <b>AI:</b> Clyde has two basic AIs, one for when he's far from Pac-Man, and
 * one for when he is near to Pac-Man. 
 * When Clyde is far away from Pac-Man (beyond eight grid spaces),
 * Clyde behaves very much like Blinky, trying to move to Pac-Man's exact
 * location. However, when Clyde gets within eight grid spaces of Pac-Man, he
 * automatically changes his behavior and runs away.
 * </p>
 * <p>
 * Source: http://strategywiki.org/wiki/Pac-Man/Getting_Started
 * </p>
 *
 * @author Jeroen Roosen
 */
public class Clyde extends Ghost {



    /**
     * The variation in intervals, this makes the ghosts look more dynamic and
     * less predictable.
     */
    private static final int INTERVAL_VARIATION = 50;

    /**
     * The base movement interval.
     */
    private static final int MOVE_INTERVAL = 250;


    /**
     * Creates a new "Clyde", a.k.a. "Pokey".
     *
     * @param spriteMap The sprites for this ghost.
     */
    public Clyde(Map<Direction, Sprite> spriteMap) {
        super(spriteMap, MOVE_INTERVAL, INTERVAL_VARIATION);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Clyde has two basic AIs, one for when he's far from Pac-Man, and one for
     * when he is near to Pac-Man. 
     * When Clyde is far away from Pac-Man (beyond eight grid spaces),
     * Clyde behaves very much like Blinky, trying to move to Pac-Man's exact
     * location. However, when Clyde gets within eight grid spaces of Pac-Man,
     * he automatically changes his behavior and runs away
     * </p>
     */
    @Override
    public Optional<Direction> nextAiMove() {
       
        return Optional.empty();
    }
}