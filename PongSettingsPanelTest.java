package pong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PongSettingsPanelTest {

	@Test
	public void properSettingBoxId() {
		var settingsBox = new PongSettingsPanel();
		assertTrue(settingsBox.paddle1.paddleID==10);
		assertTrue(settingsBox.paddle2.paddleID==10);
		assertTrue(settingsBox.paddle3.paddleID==10);
		assertTrue(settingsBox.paddle4.paddleID==10);
		assertTrue(settingsBox.paddle5.paddleID==10);
		assertTrue(settingsBox.paddle6.paddleID==10);
		
	}

}
