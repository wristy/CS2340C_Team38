package com.example.cs2340c_team38;
import com.example.cs2340c_team38.viewmodels.ConfigViewModel;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConfigViewModelTest {

    private ConfigViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ConfigViewModel();
    }

    @Test
    public void testIsValidConfig_withValidData(){
        viewModel.getPlayerName().setValue("John");
        viewModel.getDifficulty().setValue(1);
        viewModel.getCharacterSprite().setValue(1); // Directly setting the value

        viewModel.onButtonContinueClicked();

        assertEquals(Boolean.TRUE, viewModel.getIsValidConfig().getValue());
    }

    @Test
    public void testIsValidConfig_withInvalidData(){
        viewModel.getPlayerName().setValue("");
        viewModel.getDifficulty().setValue(null);
        viewModel.getCharacterSprite().setValue(null); // Directly setting the value

        viewModel.onButtonContinueClicked();

        assertNotEquals(Boolean.TRUE, viewModel.getIsValidConfig().getValue());
    }
}
