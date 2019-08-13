/**
 *
 * Copyright (c) 2006-2019, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.tool.core.internal.controller;

import com.speedment.common.injector.annotation.Inject;
import com.speedment.tool.core.component.UserInterfaceComponent;
import com.speedment.tool.core.resource.FontAwesome;
import com.speedment.tool.core.resource.MaterialIcon;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Emil Forslund
 */
public final class OutputController implements Initializable {

    private @Inject UserInterfaceComponent ui;
    private @FXML VBox log;
    private @FXML ScrollPane logPane;
    private @FXML ToggleButton wrapTextBtn;
    private @FXML Button clearLogBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Bindings.bindContent(
            log.getChildren(),
            ui.outputMessages()
        );

        logPane.fitToWidthProperty().bind(wrapTextBtn.selectedProperty());
        clearLogBtn.setOnAction(ev -> ui.outputMessages().clear());

        styleToolbarButton(wrapTextBtn, MaterialIcon.WRAP_TEXT.view());
        styleToolbarButton(clearLogBtn, FontAwesome.TRASH.view());
    }

    private void styleToolbarButton(ButtonBase btn, Node icon) {
        wrapTextBtn.setGraphic(icon);
        btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
}