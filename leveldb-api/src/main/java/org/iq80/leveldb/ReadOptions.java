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

public class ReadOptions
{
    /**
     * If true, all data read from underlying storage will be
     * verified against corresponding checksums.
     */
    private boolean verifyChecksums;

    /**
     * Should the data read for this iteration be cached in memory?
     * Callers may wish to set this field to false for bulk scans.
     */
    private boolean fillCache = true;

    /**
     * If "snapshot" is non-null, read as of the supplied snapshot
     * (which must belong to the DB that is being read and which must
     * not have been released).  If "snapshot" is null, use an implicit
     * snapshot of the state at the beginning of this read operation.
     */
    private Snapshot snapshot;

    public Snapshot snapshot()
    {
        return snapshot;
    }

    public ReadOptions snapshot(Snapshot snapshot)
    {
        this.snapshot = snapshot;
        return this;
    }

    public boolean fillCache()
    {
        return fillCache;
    }

    public ReadOptions fillCache(boolean fillCache)
    {
        this.fillCache = fillCache;
        return this;
    }

    public boolean verifyChecksums()
    {
        return verifyChecksums;
    }

    public ReadOptions verifyChecksums(boolean verifyChecksums)
    {
        this.verifyChecksums = verifyChecksums;
        return this;
    }
}
