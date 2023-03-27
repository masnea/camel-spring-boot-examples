/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.observation.logging;

import java.util.Map;
import java.util.stream.Collectors;

import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.propagation.TraceContext;

public class LoggingSpanHandler extends SpanHandler {

    @Override
    public boolean end(TraceContext context, MutableSpan span, Cause cause) {
        System.out.println("SPAN FINISHED: traceId=" + span.traceId()
                + " spanId=" + span.id()
                + " parentId=" + span.parentId()
                + " operation=" + span.name()
                + " tags=" + span.tags().entrySet()
                + " logs=[" + span.annotations().stream().map(Map.Entry::getValue).collect(Collectors.toList())
                + "]");
        return true;
    }
}