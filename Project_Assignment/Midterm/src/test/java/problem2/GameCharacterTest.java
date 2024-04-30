package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameCharacterTest {

  private GameCharacter character;

  @BeforeEach
  void setUp() throws CombatPowerException, HealthLevelException {
    Name characterName = new Name("Cathy", null, "Qin");
    character = new GameCharacter(characterName, 23, 50.0, 75.0);
  }

  @Test
  void testIncreaseWealthLevel_ValidWealthIncrease() throws WealthLevelException {
    character.increaseWealthLevel(30.0);
    assertEquals(30.0, character.getWealthLevel(), 0.0);
  }

  @Test
  void testIncreaseWealthLevel_NegativeIncrease() {
    assertThrows(WealthLevelException.class, () -> character.increaseWealthLevel(-10.0));
    assertEquals(0.0, character.getWealthLevel());
  }

  @Test
  void testIncreaseWealthLevel_ExceedMaximum() {
    assertThrows(WealthLevelException.class, () -> character.increaseWealthLevel(130.0));
  }
}
