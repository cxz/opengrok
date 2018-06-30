/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License (the "License").
 * You may not use this file except in compliance with the License.
 *
 * See LICENSE.txt included in this distribution for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at LICENSE.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */

/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 */
package org.opensolaris.opengrok.web.api.v1.controller;

import org.opensolaris.opengrok.configuration.RuntimeEnvironment;
import org.opensolaris.opengrok.web.suggester.provider.service.impl.SuggesterServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("/system")
public class SystemController {

    private final RuntimeEnvironment env = RuntimeEnvironment.getInstance();

    @PUT
    @Path("/refresh")
    @Consumes(MediaType.TEXT_PLAIN)
    public void refresh(final String project) {
        env.maybeRefreshIndexSearchers(Collections.singleton(project));
        SuggesterServiceImpl.getInstance().refresh(project);
    }

}
