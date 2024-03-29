/*
 * Copyright 2011 Björn Raupach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * A stripped down version of Apache Commons ToStringBuilder.
 */
package org.beanstalk4j.utils;

public class ToStringBuilder {

    private final StringBuilder buffer;
    private boolean fieldsAppended;

    public ToStringBuilder(Object object) {
        buffer = new StringBuilder();
        fieldsAppended = false;
        appendCanonicalName(object);
        appendHashCode(object);
    }

    private void appendCanonicalName(Object obj) {
        buffer.append(obj.getClass().getCanonicalName());
    }

    private void appendHashCode(Object obj) {
        buffer.append('@');
        buffer.append(Integer.toHexString(obj.hashCode()));
    }

    @Override
    public String toString() {
        if (fieldsAppended) {
            buffer.append(']');
        }
        return buffer.toString();
    }

    public ToStringBuilder append(String fieldName, Object value) {
        if (value == null) {
            return append(fieldName, "nil");
        } else {
            return append(fieldName, value.toString());
        }

    }

    public ToStringBuilder append(String fieldName, String value) {
        if (!fieldsAppended) {
            buffer.append('[');
            fieldsAppended = true;
        } else {
            buffer.append(' ');
        }
        buffer.append(fieldName).append('=').append(value);
        return this;
    }
}
