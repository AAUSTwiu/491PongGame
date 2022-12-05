package pongPackage;

import org.junit.*;
import static org.junit.Assert.*;

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