package it.unibo.deathnote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImpl;

import static it.unibo.deathnote.api.DeathNote.RULES;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class TestDeathNote {

    private static final int INVALID_CAUSE_TIME = 100;
    private static final int INVALID_DETAILS_TIME = 6000 + INVALID_CAUSE_TIME;

    private DeathNote deathNote = new DeathNoteImpl();


    /**
     * I used anonymous classes che implementa Executable in quanto
     * assertThrows si aspetta come secondo argomento un Executable
     */
    @Test 
    public void testIllegalRuleNumber() {
        assertThrows(IllegalArgumentException.class , new Executable() {
            @Override 
            public void execute () {
                deathNote.getRule(-1);
            }
        });
        assertThrows(IllegalArgumentException.class ,new Executable() {
            @Override 
            public void execute () {
                deathNote.getRule(0);
            }
        });
        assertThrows(IllegalArgumentException.class , new Executable() {
            @Override 
            public void execute () {
                deathNote.getRule(RULES.size() + 1);
            }
        });
    }

    @Test
    void testRules() {
        for (int i = 1; i <= RULES.size(); i++) {
            assertNotNull(deathNote.getRule(i));
            assertFalse(deathNote.getRule(i).isBlank());
        }
    }

    @Test
    void testVerifyDeath() {
        assertFalse(deathNote.isNameWritten("Umano Uno"));
        deathNote.writeName("Umano Uno");
        assertTrue(deathNote.isNameWritten("Umano Uno"));
        assertFalse(deathNote.isNameWritten("Umano Due")); 
        assertFalse(deathNote.isNameWritten(""));
    }

    @Test
    void testCauseTimeframe() {
        assertThrows(Exception.class , new Executable() {
            @Override 
            public void execute () {
                deathNote.writeDeathCause("test death");
            }
        });

        deathNote.writeName("Persona Esempio");
        assertEquals("heart attack", );
    }
}    