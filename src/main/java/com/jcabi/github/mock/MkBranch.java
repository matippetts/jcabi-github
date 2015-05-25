/**
 * Copyright (c) 2013-2015, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.github.mock;

import com.jcabi.github.Branch;
import com.jcabi.github.Commit;
import com.jcabi.github.Coordinates;
import com.jcabi.github.Repo;
import javax.validation.constraints.NotNull;

/**
 * Mock Git branch.
 *
 * @author Chris Rebert (github@rebertia.com)
 * @version $Id$
 * @since 0.24
 */
public final class MkBranch implements Branch {
    /**
     * Storage.
     */
    private final transient MkStorage storage;

    /**
     * Login of the user logged in.
     */
    private final transient String self;

    /**
     * Repo name.
     */
    private final transient Coordinates coords;

    /**
     * Branch name.
     */
    private final transient String nam;

    /**
     * Commit sha.
     */
    private final transient String hash;

    /**
     * Public ctor.
     * @param stg Storage
     * @param login User to login
     * @param rep Repo
     * @param nom Branch name
     * @param sha Commit sha
     * @checkstyle ParameterNumberCheck (7 lines)
     */
    MkBranch(
        @NotNull(message = "stg can't be NULL") final MkStorage stg,
        @NotNull(message = "login can't be NULL") final String login,
        @NotNull(message = "rep can't be NULL") final Coordinates rep,
        @NotNull(message = "nom can't be NULL") final String nom,
        @NotNull(message = "sha can't be NULL") final String sha
    ) {
        this.storage = stg;
        this.self = login;
        this.coords = rep;
        this.nam = nom;
        this.hash = sha;
    }

    @Override
    @NotNull(message = "repository can't be NULL")
    public Repo repo() {
        return new MkRepo(this.storage, this.self, this.coords);
    }

    @Override
    @NotNull(message = "name is never NULL")
    public String name() {
        return this.nam;
    }

    @Override
    @NotNull(message = "commit is never NULL")
    public Commit commit() {
        return new MkCommit(this.storage, this.self, this.coords, this.hash);
    }
}
