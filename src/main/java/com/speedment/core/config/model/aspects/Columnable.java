/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
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
package com.speedment.core.config.model.aspects;

import com.speedment.core.config.model.Column;
import static com.speedment.core.config.model.ConfigUtil.findColumnByName;
import com.speedment.core.config.model.Table;
import com.speedment.core.exception.SpeedmentException;

/**
 *
 * @author Emil Forslund
 */
public interface Columnable extends Node {
    default Column getColumn() {
        return findColumnByName(
            ancestor(Table.class)
                .orElseThrow(() -> new SpeedmentException(
                    "Found no ancestor table from this " + 
                    getClass().getSimpleName() + "."
                )), 
            getName()
        );
    }
}
