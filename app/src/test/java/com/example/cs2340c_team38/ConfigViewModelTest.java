package com.example.cs2340c_team38;
import com.example.cs2340c_team38.viewmodels.ConfigViewModel;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConfigViewModelTest {

    private ConfigViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ConfigViewModel();
    }

    @Test
    public void testIsValidConfig_withValidData() {
        viewModel.getPlayerName().setValue("John");
        viewModel.getDifficulty().setValue(1);
        viewModel.getCharacterSprite().setValue(1);

        assertTrue(viewModel.isValidConfig());
    }

    @Test
    public void testIsValidConfig_withInvalidData() {
        viewModel.getPlayerName().setValue("");
        viewModel.getDifficulty().setValue(null);
        viewModel.getCharacterSprite().setValue(null);

        assertFalse(viewModel.isValidConfig());
    }

    @Test
    public void testOnButtonContinueClicked_withValidData() {
        viewModel.getPlayerName().setValue("John");
        viewModel.getDifficulty().setValue(1);
        viewModel.getCharacterSprite().setValue(1);
        viewModel.onButtonContinueClicked();

        assertTrue(viewModel.getIsValidConfig().getValue());
    }

    @Test
    public void testOnButtonContinueClicked_withInvalidData() {
        viewModel.getPlayerName().setValue("");
        viewModel.getDifficulty().setValue(null);
        viewModel.getCharacterSprite().setValue(null);
        viewModel.onButtonContinueClicked();

        assertFalse(viewModel.getIsValidConfig().getValue());
    }

    // Note: The method `onSplitTypeChanged` interacts with Android's RadioGroup,
    // which is not straightforward to test without using tools like Robolectric or Mockito.
    // We're skipping it in this basic test.
}