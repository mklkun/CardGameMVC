package org.example.cardgame;

import org.assertj.core.api.Assertions;
import org.example.cardgame.model.NormalDeck;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.internal.NoExitSecurityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@ExtendWith(MockitoExtension.class)
class MainTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NormalDeck.class);

    InputStream stdin = System.in;

    PrintStream stdout = System.out;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @BeforeEach
    void setUp() {
        System.setSecurityManager(new NoExitSecurityManager(System.getSecurityManager()));
    }

    @AfterEach
    void tearDown () {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Test
    void mainGameShouldTerminateWithAWinner() {
        // GIVEN
        System.setIn(new ByteArrayInputStream("Jack\n\n\nq\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);

        System.setOut(ps);

        // WHEN
        try {
            Main.main(new String[0]);
        } catch (RuntimeException e) {
            LOGGER.info("Game exited: [{}]", e.getMessage());
        }

        String outputText = byteArrayOutputStream.toString();
        String key = "Winner";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        // THEN
        String expectedPattern = "is Jack !";
        Assertions.assertThat(output).containsPattern(expectedPattern);
    }
}