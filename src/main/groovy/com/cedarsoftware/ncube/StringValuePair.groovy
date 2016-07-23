/*
 * Copyright 2003-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cedarsoftware.ncube

import com.cedarsoftware.util.StringUtilities
import groovy.transform.CompileStatic

/**
 * Class used to carry one entry of the coordinate for NCube test input.
 *
 * @author John DeRegnaucourt (jdereg@gmail.com)
 *         <br>
 *         Copyright (c) Cedar Software LLC
 *         <br><br>
 *         Licensed under the Apache License, Version 2.0 (the "License")
 *         you may not use this file except in compliance with the License.
 *         You may obtain a copy of the License at
 *         <br><br>
 *         http://www.apache.org/licenses/LICENSE-2.0
 *         <br><br>
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *         See the License for the specific language governing permissions and
 *         limitations under the License.
 */
@CompileStatic
class StringValuePair extends MapEntry
{
    StringValuePair(String key, CellInfo value)
    {
        super(key, value)
    }

    int hashCode()
    {
        return hash(((String)key).toLowerCase()) ^ hash(value)
    }

    boolean equals(StringValuePair that)
    {
        if (that == this)
        {
            return true
        }

        if (!StringUtilities.equalsIgnoreCase((String)key, (String)that.key))
        {
            return false
        }
        if (value == null || that.value == null)
        {
            return value == null && that.value == null
        }
        return value.equals(that.value)
    }

    boolean equals(Object that)
    {
        if (!(that instanceof StringValuePair))
        {
            return false
        }
        return equals((StringValuePair)that)
    }
}
