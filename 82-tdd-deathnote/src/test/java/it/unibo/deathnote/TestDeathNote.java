package it.unibo.deathnote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test 
    public void testIllegalRuleNumber() {
        assertThrows(new IllegalArgumentException(), deathNote.getRule(-1));
        assertThrows(new IllegalArgumentException(), deathNote.getRule(0));
        assertThrows(new IllegalArgumentException(), deathNote.getRule(RULES.size() + 1));
    }
}