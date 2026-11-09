package com.applytrack.applytrack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void appliedCanGoToInterview() {
        assertTrue(Status.APPLIED.canTransitionTo(Status.INTERVIEW));
    }

    @Test
    void appliedCanGoToRejected() {
        assertTrue(Status.APPLIED.canTransitionTo(Status.REJECTED));
    }

    @Test
    void interviewCanGoToOffer() {
        assertTrue(Status.INTERVIEW.canTransitionTo(Status.OFFER));
    }

    @Test
    void interviewCanGoToRejected() {
        assertTrue(Status.INTERVIEW.canTransitionTo(Status.REJECTED));
    }

    @Test
    void interviewCannotJumpToApplied() {
        assertFalse(Status.INTERVIEW.canTransitionTo(Status.APPLIED));
    }

    @Test
    void appliedCannotJumpToOffer() {
        assertFalse(Status.APPLIED.canTransitionTo(Status.OFFER));
    }

    // ---- naye tests ----

    @Test
    void offerCannotGoAnywhere() {
        for (Status next : Status.values()) {
            assertFalse(Status.OFFER.canTransitionTo(next));
        }
    }

    @Test
    void rejectedCannotGoAnywhere() {
        for (Status next : Status.values()) {
            assertFalse(Status.REJECTED.canTransitionTo(next));
        }
    }

    @Test
    void appliedCannotGoToItself() {
        assertFalse(Status.APPLIED.canTransitionTo(Status.APPLIED));
    }

    @Test
    void interviewCannotGoToItself() {
        assertFalse(Status.INTERVIEW.canTransitionTo(Status.INTERVIEW));
    }
}