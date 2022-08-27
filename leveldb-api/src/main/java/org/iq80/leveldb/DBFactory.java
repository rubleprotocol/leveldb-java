/*
 * Copyright (C) 2011 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package org.iq80.leveldb;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
public interface DBFactory
{
    /**
     * Open the database with the specified "name".
     * Caller should call {@link DB#close()} when it is no longer needed.
     * @return a heap-allocated database in DB
     * @throws IOException returns a non-OK status on error.
     */
    DB open(File path, Options options)
            throws IOException;

    /**
     * Destroy the contents of the specified database.
     * Be very careful using this method.
     * Note: For backwards compatibility, if DestroyDB is unable to list the
     * database files, Status::OK() will still be returned masking this failure.
     * @throws IOException may be not
     */
    void destroy(File path, Options options)
            throws IOException;

    /**
     * If a DB cannot be opened, you may attempt to call this method to
     * resurrect as much of the contents of the database as possible.
     * Some data may be lost, so be careful when calling this function
     * on a database that contains important information.
     * @throws IOException may be
     */
    void repair(File path, Options options)
            throws IOException;
}
