/*
 * Copyright 2014 Björn Raupach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beanstalk4j.utils;

import org.junit.Test;
import static org.beanstalk4j.utils.IsoDateTimeFormat.parse;

public class IsoDateTimeFormatTest {
    
    @Test
    public void testParse() {
        parse("2009/11/16 19:56:20 +0100");
        parse("2014/06/02 13:47:29 +0200");
    }
    
}
