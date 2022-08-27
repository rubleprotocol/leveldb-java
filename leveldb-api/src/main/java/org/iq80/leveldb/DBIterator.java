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

import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
public interface DBIterator
        extends Iterator<Map.Entry<byte[], byte[]>>, Closeable
{
    /**
     * Position at the first key in the source that is at or past target.
     * The iterator is Valid() after this call iff the source contains
     * an entry that comes at or past target.
     * If key larger than max key, Valid() return false.
     * @param key target
     */
    void seek(byte[] key);

    /**
     * Seek to the last key that is less than or equal to the target key.
     * { @link <a href="https://github.com/facebook/rocksdb/wiki/SeekForPrev"></a> }
     * @param key target
     */
    void seekForPrev(byte[] key);

    /**
     * Position at the first key in the source.  The iterator is {@link #Valid()}
     * after this call iff the source is not empty.
     */
    void seekToFirst();

    /**
     * Keep same as {@link #peekPrev()}.
     * @see #key()
     * @see #value()
     * @return the current entry
     */
    @Deprecated
    Map.Entry<byte[], byte[]> peekNext();

    /**
     * Keep same as {@link #hasNext()}.
     * Used in combination with {@link #seekToLast()},{@link #seekForPrev(byte[])},{@link #prev()}.
     * @return An iterator is either positioned at a key/value pair
     */
    boolean hasPrev();

    /**
     * Moves to the previous entry in the source.  After this call, {@link #Valid()} is
     * true iff the iterator was not positioned at the first entry in source.
     * REQUIRES: {@link #Valid()}
     * @return the current entry
     */
    Map.Entry<byte[], byte[]> prev();

    /**
     * Keep same as {@link #peekNext()}.
     * @see #key()
     * @see #value()
     * @return the current entry
     */
    @Deprecated
    Map.Entry<byte[], byte[]> peekPrev();

    /**
     *  Position at the last key in the source.  The iterator is {@link #Valid()}
     *  after this call iff the source is not empty.
     */
    void seekToLast();

    /**
     * An iterator is either positioned at a key/value pair, or
     * not valid.  This method returns true iff the iterator is valid.
     */
    boolean  Valid();

    /**
     * The returned slice is valid only until the next modification of
     * the iterator.
     * REQUIRES: {@link #Valid()}
     * @return the key for the current entry
     */
    byte[] key();

    /**
     * The returned slice is valid only until the next modification of
     * the iterator.
     * REQUIRES: {@link #Valid()}
     * @return the value for the current entry
     */
    byte[] value();
}
