/*
 * Copyright 2014 Google Inc. All Rights Reserved.
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

package com.google.openbidder.exchange.doubleclick.testing;

import com.google.openbidder.exchange.doubleclick.impression.DoubleClickImpressionRequest;
import com.google.openbidder.http.HttpRequest;
import com.google.openbidder.http.request.StandardHttpRequest;
import com.google.openbidder.http.util.HttpUtil;

/**
 * Extends {@link com.google.openbidder.api.impression.ImpressionRequest.Builder}
 * with additional features and defaults for unit testing on DoubleClick Ad Exchange.
 */
public class TestImpressionRequestBuilder
extends DoubleClickImpressionRequest.Builder {
  private static final HttpRequest DEFAULT_REQUEST = StandardHttpRequest.newBuilder()
      .setMethod("GET")
      .setUri("http://localhost")
      .build();

  protected TestImpressionRequestBuilder() {
    setHttpRequest(DEFAULT_REQUEST);
    setExchange(defaultExchange());
    setPriceCrypto(DoubleClickTestUtil.zeroPriceCrypto());
    setPriceName("price"); // PriceName.DEFAULT
  }

  public static TestImpressionRequestBuilder create() {
    return new TestImpressionRequestBuilder();
  }

  public TestImpressionRequestBuilder setPrice(double price) {
    HttpRequest.Builder httpRequest = HttpUtil.builder(getHttpRequest());
    setHttpRequest(httpRequest.addParameter("price", Double.toString(price)));
    return this;
  }

  public TestImpressionRequestBuilder addParameters(String... params) {
    HttpRequest.Builder httpRequest = HttpUtil.builder(getHttpRequest());
    setHttpRequest(httpRequest.addAllParameter(HttpUtil.toMultimap(params)));
    return this;
  }
}
